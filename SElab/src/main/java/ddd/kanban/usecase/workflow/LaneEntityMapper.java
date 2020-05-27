package ddd.kanban.usecase.workflow;

import ddd.kanban.domain.model.workflow.Column;
import ddd.kanban.domain.model.workflow.Lane;
import ddd.kanban.usecase.workflow.entity.LaneEntity;

public class LaneEntityMapper {

    public static Lane mappingColumnFrom(LaneEntity laneEntity){
        Lane lane = new Column(laneEntity.getId(), laneEntity.getTitle(), laneEntity.getWorkflowId());
        lane.setCommittedCards(laneEntity.getCommittedCards());
        return lane;
    }

    public static LaneEntity mappingColumnEntityFrom(Lane lane){
        LaneEntity laneEntity = new LaneEntity(lane.getId(), lane.getTitle(), lane.getWorkflowId());
        laneEntity.setCommittedCards(lane.getCommittedCards());
        return laneEntity;
    }
}
