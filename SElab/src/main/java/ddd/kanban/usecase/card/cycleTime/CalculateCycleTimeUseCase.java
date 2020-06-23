package ddd.kanban.usecase.card.cycleTime;

import ddd.kanban.domain.model.FlowEvent;
import ddd.kanban.usecase.repository.FlowEventRepository;
import ddd.kanban.usecase.repository.WorkflowRepository;
import ddd.kanban.usecase.kanbanboard.workflow.entity.ColumnEntity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CalculateCycleTimeUseCase {

    private FlowEventRepository flowEventRepository;
    private WorkflowRepository workflowRepository;

    public CalculateCycleTimeUseCase(WorkflowRepository workflowRepository, FlowEventRepository flowEventRepository) {
        this.workflowRepository = workflowRepository;
        this.flowEventRepository = flowEventRepository;
    }

    public void execute(CalculateCycleTimeInput calculateCycleTimeInput, CalculateCycleTimeOutput calculateCycleTimeOutput){
        List<FlowEventPair> flowEventPairs;
        List<String> laneIntervalIds;
        CycleTime cycleTime;

        flowEventPairs = getCardFlowEventPairs(calculateCycleTimeInput.getCardId());
        laneIntervalIds = getLaneIntervalIds(calculateCycleTimeInput.getWorkflowId(), calculateCycleTimeInput.getBeginningLaneId(), calculateCycleTimeInput.getEndLaneId());
        cycleTime = calculateCycleTime(flowEventPairs, laneIntervalIds);

        calculateCycleTimeOutput.setCycleTime(cycleTime);
    }


    private List<FlowEventPair> getCardFlowEventPairs(String cardId) {
        List<FlowEventPair> flowEventPairs = new ArrayList<>();

        FlowEvent committed = null;

        for(FlowEvent flowEvent: this.flowEventRepository.findAll()){
            if (flowEvent.getCardId().equals(cardId)){
                if (committed == null){
                    committed = flowEvent;
                }else{
                    flowEventPairs.add(new FlowEventPair(committed, flowEvent));
                    committed = null;
                }
            }
        }
        if (committed != null)
            flowEventPairs.add(new FlowEventPair(committed, null));
        return flowEventPairs;
    }

    private List<String> getLaneIntervalIds(String workflowId, String beginningLaneId, String endLaneId) {
        List<ColumnEntity> laneEntities = this.workflowRepository.findById(workflowId).getLaneEntities();
        List<String> laneIntervalIds = laneEntities.stream()
                                                    .map(laneEntity -> laneEntity.getId())
                                                    .collect(Collectors.toList());

        return laneIntervalIds;
    }

    private CycleTime calculateCycleTime(List<FlowEventPair> flowEventPairs, List<String> laneIntervalIds) {
        long diff = flowEventPairs.stream()
                    .mapToLong(flowEventPair -> flowEventPair.getCycleTime().getMillisecond())
                    .sum();
        return new CycleTime(diff);
    }
}
