package ddd.kanban.domain.usecase;

import ddd.kanban.domain.model.workflow.Workflow;
import ddd.kanban.domain.usecase.inputdata.CreateWorkflowInput;
import ddd.kanban.domain.usecase.outputdata.CreateWorkflowOutput;
import ddd.kanban.domain.usecase.repository.WorkflowRepository;

public class CreateWorkflowUseCase {
    private WorkflowRepository workflowRepository;
    public CreateWorkflowUseCase(WorkflowRepository workflowRepository){
        this.workflowRepository = workflowRepository;
    }

    public void execute(CreateWorkflowInput createWorkflowInput, CreateWorkflowOutput createWorkflowOutput) {
        Workflow workflow = new Workflow(createWorkflowInput.getWorkflowId(),createWorkflowInput.getWorkflowName());
        workflowRepository.add(workflow);
        workflowRepository.save(workflow);
        createWorkflowOutput.setWorkflowId(workflow.getId());
        createWorkflowOutput.setWorkflowName(workflow.getName());
    }
}