package ddd.kanban.domain.usecase.repository;

import ddd.kanban.domain.model.workflow.Workflow;

import java.util.Optional;

public interface WorkflowRepository {
    void add(Workflow workflow);

    Optional<Workflow> findById(String workflowId);

    void save(Workflow workflow);
}
