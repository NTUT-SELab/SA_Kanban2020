package kanban.domain.usecase.workflow.create;

import kanban.domain.model.Workflow;
import kanban.domain.usecase.workflow.WorkflowRepository;

public class CreateWorkflowUseCase {
    private WorkflowRepository workflowRepository;

    public CreateWorkflowUseCase(WorkflowRepository workflowRepository){
        this.workflowRepository= workflowRepository;
    }

    public void execute(CreateWorkflowInput input, CreateWorkflowOutput output) {

        Workflow workflow= new Workflow(input.getWorkflowName());
        workflowRepository.add(workflow);
        output.setWorkflowName(workflow.getName());
        output.setWorkflowId(workflow.getWorkflowId());
    }
}