package ddd.kanban.domain.model.report.cycletimecalculatorservice.event;

import ddd.kanban.domain.model.AbstractDomainEvent;
import ddd.kanban.domain.model.report.cycletimecalculatorservice.CycleTime;

import java.util.List;

public class CycleTimeCalculated extends AbstractDomainEvent {
    private List<String> laneIntervalIds;
    private CycleTime cycleTime;

    public CycleTimeCalculated(String cardId, String cardName, List<String> laneIntervalIds, CycleTime cycleTime, String id){
        super(cardId, id);
        this.laneIntervalIds = laneIntervalIds;
        this.cycleTime = cycleTime;
    }

    public void setLaneIntervalIds(List<String> laneIntervalIds) {
        this.laneIntervalIds = laneIntervalIds;
    }

    public void setCycleTime(CycleTime cycleTime) {
        this.cycleTime = cycleTime;
    }
}
