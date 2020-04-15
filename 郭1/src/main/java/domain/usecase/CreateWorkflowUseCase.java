package domain.usecase;

import domain.entity.Workflow;

import domain.usecase.CreateWorkflowInputInterface;
import domain.usecase.CreateWorkflowOutputInterface;


public class CreateWorkflowUseCase implements CreateWorkflowOutputInterface{
    private CreateWorkflowInputInterface createWorkflowInputInterface;
    private CreateWorkflowOutputInterface createWorkflowOutputInterface;

    public void execute() {
        Workflow workflow = new Workflow();
        workflow.setName(createWorkflowInputInterface.getWorkflowName());

        createWorkflowOutputInterface.setWorkFlowId(workflow.getId());

    }

    public void setCreateWorkflowInputInterface(CreateWorkflowInputInterface createWorkflowInputInterface) {
        this.createWorkflowInputInterface = createWorkflowInputInterface;
    }

    public void setCreateWorkflowOutputInterface(CreateWorkflowOutputInterface createWorkflowOutputInterface) {
        this.createWorkflowOutputInterface = createWorkflowOutputInterface;
    }



    public String getWorkflowId() {
        return null;
    }

    public void setWorkFlowId(String id) {

    }
}
