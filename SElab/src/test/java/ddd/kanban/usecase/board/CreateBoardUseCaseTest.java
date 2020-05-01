package ddd.kanban.usecase.board;

import ddd.kanban.adapter.repository.board.InMemoryBoardRepository;
import ddd.kanban.adapter.repository.board.SqliteBoardRepository;
import ddd.kanban.adapter.repository.workflow.InMemoryWorkflowRepository;
import ddd.kanban.domain.model.DomainEventBus;
import ddd.kanban.usecase.DomainEventHandler;
import ddd.kanban.usecase.board.create.CreateBoardInput;
import ddd.kanban.usecase.board.create.CreateBoardOutput;
import ddd.kanban.usecase.board.create.CreateBoardUseCase;
import ddd.kanban.usecase.repository.BoardRepository;
import ddd.kanban.usecase.repository.WorkflowRepository;
import org.junit.Before;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CreateBoardUseCaseTest {
    private BoardRepository boardRepository;
    private BoardRepository sqliteBoardRepository;
    private WorkflowRepository workflowRepository;
    private String boardId;
    private DomainEventBus domainEventBus;

    @Before
    public void setUp(){
        boardId = UUID.randomUUID().toString();
        boardRepository = new InMemoryBoardRepository();
        sqliteBoardRepository = new SqliteBoardRepository();
        this.workflowRepository = new InMemoryWorkflowRepository();
        this.domainEventBus = new DomainEventBus();
    }

    @Test
    public void testCreateBoardUseCase(){
        CreateBoardUseCase createBoardUseCase = new CreateBoardUseCase(boardRepository, domainEventBus);
        CreateBoardInput createBoardInput = new CreateBoardInput("TestBoard","This is board that save in memory");
        CreateBoardOutput createBoardOutput = new CreateBoardOutput();
        createBoardUseCase.execute(createBoardInput, createBoardOutput);
        assertEquals("TestBoard", createBoardOutput.getBoardName());
        assertEquals("This is board that save in memory", createBoardOutput.getBoardDescription());

    }

//    @Test
//    public void testCreateBoardUseCaseWithSQLite(){
//        CreateBoardUseCase createBoardUseCase = new CreateBoardUseCase(sqliteBoardRepository, domainEventBus);
//        CreateBoardInput createBoardInput = new CreateBoardInput("TestBoard2", "This is board that save in sqlite");
//        CreateBoardOutput createBoardOutput = new CreateBoardOutput();
//        createBoardUseCase.execute(createBoardInput, createBoardOutput);
//        assertEquals("TestBoard2", createBoardOutput.getBoardName());
//        assertEquals("This is board that save in sqlite", createBoardOutput.getBoardDescription());
//    }
}
