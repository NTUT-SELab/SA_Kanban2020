package domain;

import domain.usecase.*;

import org.junit.*;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CreateStageUseCaseTest {
    private WorkflowRepository workflowRepository;
    private CreateWorkflowUseCase createWorkflowUseCase;
    private WorkflowUseCaseOutput workflowOutput;
    @Before
    public void SetUp(){
        workflowRepository = new WorkflowRepository();
        createWorkflowUseCase = new CreateWorkflowUseCase(workflowRepository);
        WorkflowUseCaseInput input = new WorkflowUseCaseInput();
        workflowOutput = new WorkflowUseCaseOutput();
        input.setWorkflowName("workflow1");

        createWorkflowUseCase.execute(input, workflowOutput);
    }

    @Test
    public void StageUseCaseInputTest(){
        StageUseCaseInput input = new StageUseCaseInput();
        input.setWorkflowId("123");
        input.setStageName("stage1");
        assertEquals("123",input.getWorkflowId());
        assertEquals("stage1", input.getStageName());
    }

    @Test
    public void StageUseCaseOutputTest(){
        StageUseCaseOutput output = new StageUseCaseOutput();
        output.setWorkflowId("123");
        output.setStageId("123");
        output.setStageName("stage1");
        assertEquals("123",output.getWorkflowId());
        assertEquals("123", output.getStageId());
        assertEquals("stage1", output.getStageName());
    }

    @Test
    public void CreateStageTest() {
        CreateStageUseCase createStageUseCase = new CreateStageUseCase(workflowRepository);
        StageUseCaseInput input = new StageUseCaseInput();
        StageUseCaseOutput output = new StageUseCaseOutput();
        input.setWorkflowId(workflowOutput.getWorkflowId());
        input.setStageName("stage1");

        createStageUseCase.execute(input,output);

        assertEquals(workflowOutput.getWorkflowId(), output.getWorkflowId());
        assertNotNull(output.getStageId());
        assertEquals("stage1", output.getStageName());
    }
}
