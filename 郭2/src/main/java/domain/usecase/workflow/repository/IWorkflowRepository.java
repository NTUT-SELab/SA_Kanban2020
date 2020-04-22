package domain.usecase.workflow.repository;

import domain.aggregate.workflow.Workflow;

public interface IWorkflowRepository {
    void add(Workflow workflow);

    Workflow getWorkflowById(String workflowId);

    void save(Workflow workflow);
}
