package ddd.kanban.domain.model.report.event;

import ddd.kanban.domain.model.AbstractDomainEvent;

public class CycleTimeCalculated extends AbstractDomainEvent {
    public CycleTimeCalculated(String cardId, String endLaneId, String id){
        super(cardId, endLaneId, id);
    }
}