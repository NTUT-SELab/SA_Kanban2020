package domain.usecase;

import domain.entity.Workflow;

public class CreateWorkflowUseCase {
    private WorkflowRepository workflowRepository;

    public CreateWorkflowUseCase(WorkflowRepository workflowRepository) {
        this.workflowRepository = workflowRepository;
    }

    public void execute(WorkflowUseCaseInput input, WorkflowUseCaseOutput output) {
        Workflow workflow = new Workflow(input.getWorkflowName());
        workflowRepository.add(workflow);
        output.setWorkflowId(workflow.getWorkflowId());
        output.setWorkflowName(workflow.getWorkflowName());
    }
}
