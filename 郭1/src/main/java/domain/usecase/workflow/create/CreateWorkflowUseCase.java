package domain.usecase.workflow.create;

import domain.entity.Workflow;
import domain.adapter.WorkflowRepositoryImpl;


public class CreateWorkflowUseCase {



    public void execute(CreateWorkflowInput createWorkflowInput, CreateWorkflowOutput createWorkflowOutput) {
        Workflow newWorkflow = new Workflow();

        newWorkflow.setName(createWorkflowInput.getWorkflowName());

        WorkflowRepositoryImpl workflowRepository = new WorkflowRepositoryImpl();
        workflowRepository.save(newWorkflow);

        createWorkflowOutput.setWorkFlowId(newWorkflow.getId());

    }

}
