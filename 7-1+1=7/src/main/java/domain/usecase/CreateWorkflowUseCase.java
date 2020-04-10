package domain.usecase;

import domain.model.Workflow;

public class CreateWorkflowUseCase {
    private WorkflowRepository workflowRepository;

    public CreateWorkflowUseCase(WorkflowRepository workflowRepository) {
        this.workflowRepository = workflowRepository;
    }

    public void execute(CreateWorkflowInput input, CreateWorkflowOutput output) {
        String workflowId = workflowRepository.add(new Workflow(input.getWorkflowName(), "B1"));

        output.setWorkflowId(workflowId);
    }
}
