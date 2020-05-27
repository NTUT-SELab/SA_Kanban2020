package ddd.kanban.usecase.workflow;

import ddd.kanban.domain.model.workflow.Lane;
import ddd.kanban.domain.model.workflow.Workflow;
import ddd.kanban.usecase.workflow.entity.LaneEntity;
import ddd.kanban.usecase.workflow.entity.WorkflowEntity;

import java.util.List;
import java.util.stream.Collectors;

public class WorkflowEntityMapper {
    public static Workflow mappingWorkflowFrom(WorkflowEntity workflowEntity){

        List<Lane> lanes = workflowEntity.getLaneEntities()
                                    .stream()
                                    .map(laneEntity -> LaneEntityMapper.mappingColumnFrom(laneEntity))
                                    .collect(Collectors.toList());
        Workflow workflow = new Workflow(workflowEntity.getId(), workflowEntity.getTitle(), workflowEntity.getBoardId(), lanes);
        return workflow;
    }

    public static WorkflowEntity mappingWorkflowEntityFrom(Workflow workflow){
        WorkflowEntity workflowEntity = new WorkflowEntity(workflow.getId(), workflow.getTitle(), workflow.getBoardId());
        List<LaneEntity> laneEntities = workflow.getLanes()
                                            .stream()
                                            .map(lane -> LaneEntityMapper.mappingColumnEntityFrom(lane))
                                            .collect(Collectors.toList());
        workflowEntity.setLaneEntities(laneEntities);
        return workflowEntity;
    }
}
