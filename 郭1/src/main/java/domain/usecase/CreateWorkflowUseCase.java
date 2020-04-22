package domain.usecase;

import domain.controller.CreateWorkflowOutputInterface;
import domain.entity.Workflow;

import domain.controller.CreateWorkflowInputInterface;
import domain.entity.WorkflowRepository;


public class CreateWorkflowUseCase {
    private CreateWorkflowInputInterface _createWorkflowInput;
    private CreateWorkflowOutputInterface _createWorkflowOutput;

    public void execute() {
        Workflow newWorkflow = new Workflow();
        newWorkflow.setName(_createWorkflowInput.getWorkflowName());

        WorkflowRepository workflowRepository = WorkflowRepository.getInstance();
        workflowRepository.add(newWorkflow);

        _createWorkflowOutput.setWorkFlowId(newWorkflow.getId());

    }

    public void setCreateWorkflowInput(CreateWorkflowInputInterface createWorkflowInput) {
        this._createWorkflowInput = createWorkflowInput;
    }

    public void setCreateWorkflowOutput(CreateWorkflowOutputInterface createWorkflowOutputInterface) {
        this._createWorkflowOutput = createWorkflowOutputInterface;
    }
}
