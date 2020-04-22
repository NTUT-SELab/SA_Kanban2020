package domain.usecase.stage.create;

import domain.usecase.board.create.CreateBoardUseCase;
import domain.usecase.board.create.CreateBoardUseCaseInput;
import domain.usecase.board.create.CreateBoardUseCaseOutput;
import domain.adapter.repository.board.InMemoryBoardRepository;
import domain.usecase.board.repository.IBoardRepository;
import domain.usecase.workflow.create.CreateWorkflowUseCase;
import domain.usecase.workflow.create.CreateWorkflowUseCaseInput;
import domain.usecase.workflow.create.CreateWorkflowUseCaseOutput;
import domain.adapter.repository.workflow.InMemoryWorkflowRepository;
import domain.usecase.workflow.repository.IWorkflowRepository;
import org.junit.*;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CreateStageUseCaseTest {
    private IWorkflowRepository workflowRepository;
    private IBoardRepository boardRepository;
    private CreateWorkflowUseCase createWorkflowUseCase;
    private CreateWorkflowUseCaseOutput workflowOutput;

    @Before
    public void SetUp(){
        boardRepository = new InMemoryBoardRepository();
        CreateBoardUseCase createBoardUseCase = new CreateBoardUseCase(boardRepository);
        CreateBoardUseCaseInput createBoardUseCaseInput = new CreateBoardUseCaseInput();
        CreateBoardUseCaseOutput createBoardUseCaseOutput = new CreateBoardUseCaseOutput();
        createBoardUseCaseInput.setBoardName("Kanban of KanbanDevelopment");
        createBoardUseCase.execute(createBoardUseCaseInput, createBoardUseCaseOutput);

        workflowRepository = new InMemoryWorkflowRepository();
        createWorkflowUseCase = new CreateWorkflowUseCase(workflowRepository, boardRepository);
        CreateWorkflowUseCaseInput input = new CreateWorkflowUseCaseInput();
        workflowOutput = new CreateWorkflowUseCaseOutput();
        input.setWorkflowName("KanbanDevelopment");
        input.setBoardId(createBoardUseCaseOutput.getBoardId());

        createWorkflowUseCase.execute(input, workflowOutput);
    }

    @Test
    public void CreateStageTest() {
        CreateStageUseCase createStageUseCase = new CreateStageUseCase(workflowRepository);
        CreateStageUseCaseInput input = new CreateStageUseCaseInput();
        CreateStageUseCaseOutput output = new CreateStageUseCaseOutput();
        input.setWorkflowId(workflowOutput.getWorkflowId());
        input.setStageName("ToDo");

        createStageUseCase.execute(input,output);

        assertEquals(workflowOutput.getWorkflowId(), output.getWorkflowId());
        assertNotNull(output.getStageId());
        assertEquals("ToDo", output.getStageName());
    }
}
