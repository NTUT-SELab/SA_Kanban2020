package ddd.kanban.domain.model.report;

import ddd.kanban.domain.model.DomainEvent;
import ddd.kanban.domain.model.PostableEventObject;
import ddd.kanban.domain.model.EventPostable;
import ddd.kanban.domain.model.report.event.CycleTimeCalculated;
import ddd.kanban.usecase.report.cycleTime.CycleTime;
import ddd.kanban.usecase.report.cycleTime.FlowEventPair;

import java.util.List;

public class CycleTimeCalculator implements EventPostable {

    private PostableEventObject postableEventObjectObject = new PostableEventObject();
    @Override
    public void addDomainEvent(DomainEvent event) {
        postableEventObjectObject.addDomainEvent(event);
    }

    @Override
    public List<DomainEvent> getDomainEvents() {
        return postableEventObjectObject.getDomainEvents();
    }

    @Override
    public void clearDomainEvents() {
        this.postableEventObjectObject.clearDomainEvents();
    }

    public CycleTime calculateCycleTime(String cardId, List<FlowEventPair> flowEventPairs, List<String> laneIntervalIds) {
        long diff = flowEventPairs.stream()
                                    .filter(flowEventPair -> laneIntervalIds.contains(flowEventPair.getLaneId()))
                                    .mapToLong(flowEventPair -> flowEventPair.getCycleTime().getMillisecond())
                                    .sum();
        addDomainEvent(new CycleTimeCalculated(cardId, "", ""));
        return new CycleTime(diff);
    }
}
