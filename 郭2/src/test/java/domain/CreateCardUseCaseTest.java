package domain;

import domain.usecase.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CreateCardUseCaseTest {
    private WorkflowRepository workflowRepository;
    private CreateWorkflowUseCase createWorkflowUseCase;
    private WorkflowUseCaseOutput workflowOutput;
    private CreateStageUseCase createStageUseCase;
    private StageUseCaseOutput stageOutput;

    @Before
    public void SetUp(){
        workflowRepository = new WorkflowRepository();
        createWorkflowUseCase = new CreateWorkflowUseCase(workflowRepository);
        WorkflowUseCaseInput workflowInput = new WorkflowUseCaseInput();
        workflowOutput = new WorkflowUseCaseOutput();
        workflowInput.setWorkflowName("workflow1");
        createWorkflowUseCase.execute(workflowInput, workflowOutput);

        createStageUseCase = new CreateStageUseCase(workflowRepository);
        stageOutput = new StageUseCaseOutput();
        StageUseCaseInput stageInput = new StageUseCaseInput();
        stageInput.setStageName("stage1");
        stageInput.setWorkflowId(workflowOutput.getWorkflowId());
        createStageUseCase.execute(stageInput, stageOutput);

    }
    @Test
    public void CreateCardUseCaseTest(){
        CardRepository cardRepository = new CardRepository();
        CreateCardUseCase createCardUseCase = new CreateCardUseCase(cardRepository);
        CreateCardUseCaseInput createCardUseCaseInput = new CreateCardUseCaseInput();
        CreateCardUseCaseOutput createCardUseCaseOutput = new CreateCardUseCaseOutput();
        createCardUseCaseInput.setCardName("card1");
        createCardUseCaseInput.setStageId(stageOutput.getStageId());
        createCardUseCaseInput.setWorkflowId(stageOutput.getWorkflowId());
        createCardUseCase.execute(createCardUseCaseInput, createCardUseCaseOutput);

        assertEquals("card1",createCardUseCaseOutput.getCardName());
        assertEquals(stageOutput.getStageId(),createCardUseCaseOutput.getStageId());
        assertNotNull(createCardUseCaseOutput.getCardId());
    }

}
