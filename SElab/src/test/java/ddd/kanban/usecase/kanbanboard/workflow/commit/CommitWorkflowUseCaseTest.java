package ddd.kanban.usecase.kanbanboard.workflow.commit;

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
    private DomainEventBus domainEventBus;
    private HierarchyInitial hierarchyInitial;

    @Before
    public void setUp() {
        boardRepository = new InMemoryBoardRepository();
        this.workflowRepository = new InMemoryWorkflowRepository();
        this.domainEventBus = new DomainEventBus();
        this.domainEventBus.register(new DomainEventHandler(workflowRepository, boardRepository, domainEventBus));
        hierarchyInitial = new HierarchyInitial(boardRepository, workflowRepository, domainEventBus);
    }

    @Test
    public void testCreateBoardShouldCreateWorkflowAndCommitToBoard() {
        String boardId = hierarchyInitial.CreateBoard();

        Board board = BoardEntityMapper.mappingBoardFrom(boardRepository.findById(boardId));
        assertEquals(1, board.getWorkflowIds().size());
    }

    @Test
    public void testCreateWorkflowShouldCommitToBoard() {
        String boardId = hierarchyInitial.CreateBoard();
        Board board = BoardEntityMapper.mappingBoardFrom(boardRepository.findById(boardId));

        assertEquals(1, board.getWorkflowIds().size());

        hierarchyInitial.CreateWorkflow(boardId);

        assertEquals(2, board.getWorkflowIds().size());
    }
}
