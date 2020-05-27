package ddd.kanban.usecase.repository;

import ddd.kanban.domain.model.FlowEvent;
import ddd.kanban.usecase.board.Entity.BoardEntity;

import java.util.List;

public interface FlowEventRepository {
    void add(FlowEvent flowEvent);

    void save(FlowEvent flowEvent);

    List<FlowEvent> findAll();
}
