package ddd.kanban.usecase.kanbanboard.board.Inmemory;

import ddd.kanban.adapter.presenter.kanbanboard.board.create.CreateBoardPresenter;
import ddd.kanban.adapter.repository.board.InMemoryBoardRepository;
import ddd.kanban.adapter.repository.workflow.InMemoryWorkflowRepository;
import ddd.kanban.domain.model.DomainEventBus;
import ddd.kanban.domain.model.kanbanboard.board.Board;
import ddd.kanban.domain.model.kanbanboard.workflow.Workflow;
import ddd.kanban.usecase.kanbanboard.board.mapper.BoardEntityMapper;
import ddd.kanban.usecase.domainevent.handler.DomainEventHandler;
import ddd.kanban.usecase.HierarchyInitial;
import ddd.kanban.usecase.kanbanboard.workflow.commit.CommitWorkflowInput;
import ddd.kanban.usecase.kanbanboard.workflow.commit.CommitWorkflowOutput;
import ddd.kanban.usecase.kanbanboard.workflow.commit.CommitWorkflowUseCase;
import ddd.kanban.usecase.kanbanboard.board.create.CreateBoardInput;
import ddd.kanban.usecase.kanbanboard.board.create.CreateBoardOutput;
import ddd.kanban.usecase.kanbanboard.board.create.CreateBoardUseCase;
import ddd.kanban.usecase.repository.BoardRepository;
import ddd.kanban.usecase.repository.WorkflowRepository;
import ddd.kanban.usecase.kanbanboard.workflow.create.CreateWorkflowInput;
import ddd.kanban.usecase.kanbanboard.workflow.create.CreateWorkflowOutput;
import ddd.kanban.usecase.kanbanboard.workflow.create.CreateWorkflowUseCase;
import org.junit.Before;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CommitWorkflowUseCaseTest {

    private BoardRepository boardRepository;
    private WorkflowRepository workflowRepository;
    private String boardId;
    private DomainEventBus domainEventBus;
    private HierarchyInitial hierarchyInitial;

    @Before
    public void setUp() {
        boardRepository = new InMemoryBoardRepository();
        this.workflowRepository = new InMemoryWorkflowRepository();
        this.domainEventBus = new DomainEventBus();
        this.domainEventBus.register(new DomainEventHandler(workflowRepository, boardRepository, domainEventBus));
        hierarchyInitial = new HierarchyInitial(boardRepository, workflowRepository, domainEventBus);
        boardId = hierarchyInitial.CreateBoard();
    }

    @Test
    public void testCreateBoardShouldCreateWorkflowAndCommitToBoard() {
        CreateBoardUseCase createBoardUseCase = new CreateBoardUseCase(boardRepository, domainEventBus);
        CreateBoardInput createBoardInput = new CreateBoardInput("board", "Test");
        CreateBoardOutput createBoardOutput = new CreateBoardPresenter();

        createBoardUseCase.execute(createBoardInput, createBoardOutput);

        Board board = BoardEntityMapper.mappingBoardFrom(boardRepository.findById(createBoardOutput.getBoardId()));
        assertEquals(1, board.getWorkflowIds().size());
    }

    @Test
    public void testCreateWorkflowShouldCommitToBoard() {
        Board board = BoardEntityMapper.mappingBoardFrom(boardRepository.findById(boardId));

        assertEquals(1, board.getWorkflowIds().size());

        CreateWorkflowUseCase createWorkflowUseCase = new CreateWorkflowUseCase(workflowRepository, domainEventBus);
        CreateWorkflowInput createWorkflowInput = new CreateWorkflowInput("Workflow2", boardId);
        CreateWorkflowOutput createWorkflowOutput = new CreateWorkflowOutput();

        createWorkflowUseCase.execute(createWorkflowInput, createWorkflowOutput);

        assertEquals(2, board.getWorkflowIds().size());
    }

    @Test
    public void testCommitWorkflowUseCase() {
        Workflow workflow = new Workflow(UUID.randomUUID().toString(),"Test Commit Workflow to It's Board", this.boardId);
        workflow.clearDomainEvents();

        Board board = BoardEntityMapper.mappingBoardFrom(boardRepository.findById(boardId));
        assertEquals(1, board.getWorkflowIds().size());

        CommitWorkflowInput commitWorkflowInput = new CommitWorkflowInput(this.boardId, workflow.getId());
        CommitWorkflowOutput commitWorkflowOutput = new CommitWorkflowOutput();
        CommitWorkflowUseCase commitWorkflowUseCase = new CommitWorkflowUseCase(this.boardRepository, domainEventBus);

        commitWorkflowUseCase.execute(commitWorkflowInput, commitWorkflowOutput);

        board = BoardEntityMapper.mappingBoardFrom(boardRepository.findById(boardId));
        assertEquals(2, board.getWorkflowIds().size());

        assertEquals(workflow.getId(), commitWorkflowOutput.getWorkflowId());
        assertEquals(board.getId(), commitWorkflowOutput.getBoardId());
    }
}