package domain.usecase.workflow;

import domain.entity.Workflow;

public interface WorkflowRepository {

    Workflow getWorkFlowById(String id);

    void save(Workflow workflow);
}
