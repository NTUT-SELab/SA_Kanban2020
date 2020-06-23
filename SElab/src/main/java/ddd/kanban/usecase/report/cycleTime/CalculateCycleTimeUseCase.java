package ddd.kanban.usecase.report.cycleTime;

import ddd.kanban.domain.model.DomainEventBus;
import ddd.kanban.domain.model.FlowEvent;
import ddd.kanban.domain.model.report.CycleTimeCalculator;
import ddd.kanban.usecase.repository.FlowEventRepository;
import ddd.kanban.usecase.repository.WorkflowRepository;
import ddd.kanban.usecase.kanbanboard.workflow.entity.ColumnEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CalculateCycleTimeUseCase {

    private FlowEventRepository flowEventRepository;
    private WorkflowRepository workflowRepository;
    private DomainEventBus domainEventBus;

    public CalculateCycleTimeUseCase(WorkflowRepository workflowRepository, FlowEventRepository flowEventRepository, DomainEventBus domainEventBus) {
        this.workflowRepository = workflowRepository;
        this.flowEventRepository = flowEventRepository;
        this.domainEventBus = domainEventBus;
    }

    public void execute(CalculateCycleTimeInput calculateCycleTimeInput, CalculateCycleTimeOutput calculateCycleTimeOutput){
        CycleTimeCalculator cycleTimeCalculator = new CycleTimeCalculator();
        String cardId = calculateCycleTimeInput.getCardId();
        List<FlowEventPair> flowEventPairs;
        List<String> laneIntervalIds;
        CycleTime cycleTime;

        flowEventPairs = getCardFlowEventPairs(cardId);
        laneIntervalIds = getLaneIntervalIds(calculateCycleTimeInput.getWorkflowId(), calculateCycleTimeInput.getBeginningLaneId(), calculateCycleTimeInput.getEndLaneId());
        cycleTime = cycleTimeCalculator.calculateCycleTime(cardId, flowEventPairs, laneIntervalIds);

        domainEventBus.postAll(cycleTimeCalculator);

        calculateCycleTimeOutput.setCycleTime(cycleTime);
    }


    private List<FlowEventPair> getCardFlowEventPairs(String cardId) {
        List<FlowEvent> cardFlowEvents = this.flowEventRepository.findAll().stream()
                                                                            .filter(flowEvent -> flowEvent.getCardId().equals(cardId))
                                                                            .collect(Collectors.toList());
        List<FlowEventPair> flowEventPairs = new ArrayList<>();
        FlowEvent committed = null;
        boolean isCommitted = true;

        if (cardFlowEvents.size()%2  != 0) cardFlowEvents.add(null);
        for(FlowEvent flowEvent: cardFlowEvents){
            if (isCommitted)
                committed = flowEvent;
            else
                flowEventPairs.add(new FlowEventPair(committed, flowEvent));
            isCommitted = isCommitted == false;
        }
        return flowEventPairs;
    }

    private List<String> getLaneIntervalIds(String workflowId, String beginningLaneId, String endLaneId) {
        List<ColumnEntity> columnEntities = this.workflowRepository.findById(workflowId).getColumnEntities();
        int beginLaneEntityIndex = columnEntities.indexOf(findColumnByColumnId(columnEntities, beginningLaneId));
        int endLaneEntityIndex = columnEntities.indexOf(findColumnByColumnId(columnEntities, endLaneId));
        List<String> laneIntervalIds = columnEntities.subList(beginLaneEntityIndex, endLaneEntityIndex+1)
                                                    .stream()
                                                    .map(laneEntity -> laneEntity.getId())
                                                    .collect(Collectors.toList());

        return laneIntervalIds;
    }

    private ColumnEntity findColumnByColumnId(List<ColumnEntity> columnEntities, String columnId){
        return columnEntities.stream()
                .filter(findColumnById(columnId))
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }

    private Predicate<ColumnEntity> findColumnById(String columnId){
        return ColumnEntity -> ColumnEntity.getId().equals(columnId);
    }
}
