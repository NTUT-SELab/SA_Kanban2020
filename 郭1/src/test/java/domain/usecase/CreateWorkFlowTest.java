package domain.usecase;

import domain.controller.CreateWorkflowInputImpl;
import domain.controller.CreateWorkflowOutputImpl;
import domain.usecase.workflow.create.CreateWorkflowInput;
import domain.usecase.workflow.create.CreateWorkflowOutput;
import domain.usecase.workflow.create.CreateWorkflowUseCase;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CreateWorkFlowTest {
    @Test
    public void createWorkflow(){
        CreateWorkflowUseCase createWorkflowUseCase = new CreateWorkflowUseCase();
        CreateWorkflowInput createWorkflowInput = new CreateWorkflowInputImpl();
        CreateWorkflowOutput createWorkflowOutput = new CreateWorkflowOutputImpl();

        createWorkflowInput.setWorkflowName("workflow1");


        createWorkflowUseCase.execute(createWorkflowInput, createWorkflowOutput);

        assertNotNull(createWorkflowOutput.getWorkflowId());

    }


}
