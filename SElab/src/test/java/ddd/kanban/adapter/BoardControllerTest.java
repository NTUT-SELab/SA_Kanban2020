package ddd.kanban.adapter;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import ddd.kanban.adapter.repository.board.InMemoryBoardRepository;
import ddd.kanban.adapter.repository.workflow.InMemoryWorkflowRepository;
import ddd.kanban.domain.model.DomainEventBus;
import ddd.kanban.usecase.DomainEventHandler;
import ddd.kanban.usecase.EntityMapper;
import ddd.kanban.usecase.repository.BoardRepository;
import ddd.kanban.usecase.repository.WorkflowRepository;
import org.junit.Before;
import org.junit.Test;
import ddd.kanban.adapter.controller.BoardController;

import static org.junit.Assert.assertEquals;

public class BoardControllerTest {
    private BoardRepository boardRepository;
    private WorkflowRepository workflowRepository;
    private DomainEventBus domainEventBus;
    private EntityMapper entityMapper;

    @Before
    public void setUp() {
        boardRepository = new InMemoryBoardRepository();
        this.workflowRepository = new InMemoryWorkflowRepository();
        this.domainEventBus = new DomainEventBus();
        this.domainEventBus.register(new DomainEventHandler(workflowRepository, boardRepository, this.domainEventBus));
        this.entityMapper = new EntityMapper();
    }

    @Test
    public void testControllerCreateBoard(){
        Gson gson =  new Gson();
        String json_Board = "{\"title\":\"hello\",\"description\":\"nope\"}";

        JsonParser jsonParser = new JsonParser();
        JsonObject jo = (JsonObject)jsonParser.parse(json_Board);


        BoardController c=new BoardController(boardRepository,domainEventBus);
        c.createBoard(jo);

        assertEquals(1,boardRepository.findAll().size());
    }

}
