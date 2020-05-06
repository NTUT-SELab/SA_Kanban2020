package ddd.kanban.usecase.board;

import ddd.kanban.adapter.repository.board.InMemoryBoardRepository;
import ddd.kanban.adapter.repository.workflow.InMemoryWorkflowRepository;
import ddd.kanban.domain.model.DomainEventBus;
import ddd.kanban.domain.model.board.Board;
import ddd.kanban.domain.model.workflow.Workflow;
import ddd.kanban.usecase.DTO.BoardDTO;
import ddd.kanban.usecase.DomainEventHandler;
import ddd.kanban.usecase.EntityMapper;
import ddd.kanban.usecase.board.create.CreateBoardInput;
import ddd.kanban.usecase.board.create.CreateBoardOutput;
import ddd.kanban.usecase.board.create.CreateBoardUseCase;
import ddd.kanban.usecase.repository.BoardRepository;
import ddd.kanban.usecase.repository.WorkflowRepository;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CreateBoardIntegrationTest {
    private BoardRepository boardRepository;
    private WorkflowRepository workflowRepository;
    private DomainEventBus domainEventBus;
    private EntityMapper entityMapper;

    @Before
    public void setUp(){
        this.boardRepository = new InMemoryBoardRepository();
        this.workflowRepository = new InMemoryWorkflowRepository();
        this.domainEventBus = new DomainEventBus();
        this.domainEventBus.register(new DomainEventHandler(workflowRepository, boardRepository, this.domainEventBus));
        this.entityMapper = new EntityMapper();
    }

    @Test
    public void testCreateBoardShouldCreateDefaultWorkflowAndThenWorkflowShouldCreateDefaultLane(){
        CreateBoardUseCase createBoardUseCase = new CreateBoardUseCase(boardRepository, domainEventBus);
        CreateBoardInput createBoardInput = new CreateBoardInput("IntegrationTestBoard","This is board that save in memory");
        CreateBoardOutput createBoardOutput = new CreateBoardOutput();
        createBoardUseCase.execute(createBoardInput, createBoardOutput);

        assertEquals("IntegrationTestBoard", createBoardOutput.getBoardName());
        assertEquals("This is board that save in memory", createBoardOutput.getBoardDescription());

        assertEquals(1, boardRepository.findAll().size());

        Board board = entityMapper.mappingBoardEntityFrom(boardRepository.findById(createBoardOutput.getBoardId()));
        assertEquals(1, board.getWorkflowIds().size());

        Workflow workflow = workflowRepository.findById(board.getWorkflowIds().get(0));
        assertEquals(createBoardOutput.getBoardId(), workflow.getBoardId());

        assertEquals(1, workflow.getColums().size());
    }

}
