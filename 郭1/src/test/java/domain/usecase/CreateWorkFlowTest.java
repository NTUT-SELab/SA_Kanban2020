package domain.usecase;

import domain.controller.CreateWorkflowInputImpl;
import domain.controller.CreateWorkflowInputInterface;
import domain.controller.CreateWorkflowOutputImpl;
import domain.controller.CreateWorkflowOutputInterface;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CreateWorkFlowTest {
    @Test
    public void createWorkflow(){
        CreateWorkflowUseCase createWorkflowUseCase = new CreateWorkflowUseCase();
        CreateWorkflowInputInterface createWorkflowInput = new CreateWorkflowInputImpl();
        CreateWorkflowOutputInterface createWorkflowOutput = new CreateWorkflowOutputImpl();

        createWorkflowInput.setWorkflowName("workflow1");
        ///
        createWorkflowUseCase.setCreateWorkflowInputInterface(createWorkflowInput);
        createWorkflowUseCase.setCreateWorkflowOutputInterface(createWorkflowOutput);


        createWorkflowUseCase.execute();

        assertNotNull(createWorkflowOutput.getWorkflowId());

    }


}
