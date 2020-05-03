package ddd.kanban.usecase.workflow.create;

import ddd.kanban.domain.model.DomainEventBus;
import ddd.kanban.domain.model.workflow.Column;
import ddd.kanban.domain.model.workflow.Workflow;
import ddd.kanban.usecase.repository.WorkflowRepository;

import java.util.UUID;

public class CreateWorkflowUseCase {
    private WorkflowRepository workflowRepository;
    private DomainEventBus domainEventBus;
    public CreateWorkflowUseCase(WorkflowRepository workflowRepository, DomainEventBus domainEventBus){
        this.workflowRepository = workflowRepository;
        this.domainEventBus = domainEventBus;
    }

    public void execute(CreateWorkflowInput createWorkflowInput, CreateWorkflowOutput createWorkflowOutput) {
        Workflow workflow = new Workflow(UUID.randomUUID().toString(), createWorkflowInput.getWorkflowTitle(), createWorkflowInput.getBoardId());

        workflowRepository.add(workflow);
        workflowRepository.save();

        domainEventBus.postAll(workflow);

        createWorkflowOutput.setWorkflowId(workflow.getId());
        createWorkflowOutput.setWorkflowTitle(workflow.getTitle());

    }

}