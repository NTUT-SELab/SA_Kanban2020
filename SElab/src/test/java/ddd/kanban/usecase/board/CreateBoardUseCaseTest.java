package ddd.kanban.usecase.board;

import ddd.kanban.adapter.presenter.board.create.CreateBoardPresenter;
import ddd.kanban.adapter.repository.board.InMemoryBoardRepository;
import ddd.kanban.adapter.repository.workflow.InMemoryWorkflowRepository;
import ddd.kanban.domain.model.DomainEventBus;
import ddd.kanban.domain.model.board.Board;
import ddd.kanban.domain.model.workflow.Workflow;
import ddd.kanban.usecase.DomainEventHandler;
import ddd.kanban.usecase.HierarchyInitial;
import ddd.kanban.usecase.board.DTO.BoardDTO;
import ddd.kanban.usecase.board.create.CreateBoardInput;
import ddd.kanban.usecase.board.create.CreateBoardOutput;
import ddd.kanban.usecase.board.create.CreateBoardUseCase;
import ddd.kanban.usecase.repository.BoardRepository;
import ddd.kanban.usecase.repository.WorkflowRepository;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CreateBoardUseCaseTest {
    private BoardRepository boardRepository;
    private WorkflowRepository workflowRepository;
    private DomainEventBus domainEventBus;
    private HierarchyInitial hierarchyInitial;
    private String boardId;

    @Before
    public void setUp() {
        boardRepository = new InMemoryBoardRepository();
        this.workflowRepository = new InMemoryWorkflowRepository();
        this.domainEventBus = new DomainEventBus();
        this.domainEventBus.register(new DomainEventHandler(workflowRepository, boardRepository, this.domainEventBus));
        hierarchyInitial = new HierarchyInitial(boardRepository, workflowRepository, domainEventBus);
        this.CreateBoardByHierarchyInitial();
    }

    private void CreateBoardByHierarchyInitial(){
        this.boardId = hierarchyInitial.CreateBoard();
    }

    @Test
    public void testCreateBoardUseCase() {
        assertEquals(1, boardRepository.findAll().size());
        CreateBoardUseCase createBoardUseCase = new CreateBoardUseCase(boardRepository, domainEventBus);
        CreateBoardInput createBoardInput = new CreateBoardInput("TestBoard", "This is board that save in memory");
        CreateBoardOutput createBoardOutput = new CreateBoardPresenter();
        createBoardUseCase.execute(createBoardInput, createBoardOutput);

        Board board = BoardEntityMapper.mappingBoardFrom(boardRepository.findById(createBoardOutput.getBoardId()));
        assertEquals("TestBoard", board.getTitle());
        assertEquals("This is board that save in memory", board.getDescription());

        assertEquals(2, boardRepository.findAll().size());

    }

    @Test
    public void testCreateBoardShouldCreateDefaultWorkflow() {
        Board board = BoardEntityMapper.mappingBoardFrom(boardRepository.findById(this.boardId));
        assertEquals("Board1", board.getTitle());
        assertEquals(1, boardRepository.findAll().size());

        Workflow workflow = workflowRepository.findAll().get(0);
        assertEquals(1, workflowRepository.findAll().size());
        assertEquals("default workflow", workflow.getTitle());
    }

    @Test
    public void testCreateBoardShouldCreateDefaultWorkflowAndThenWorkflowShouldCreateDefaultLane() {
        Board board = BoardEntityMapper.mappingBoardFrom(boardRepository.findById(this.boardId));

        assertEquals(1, board.getWorkflowIds().size());
    }
}
