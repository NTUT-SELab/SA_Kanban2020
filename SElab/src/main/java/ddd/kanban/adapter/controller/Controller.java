package ddd.kanban.adapter.controller;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import ddd.kanban.adapter.repository.board.InMemoryBoardRepository;
import ddd.kanban.adapter.repository.workflow.InMemoryWorkflowRepository;
import ddd.kanban.domain.model.DomainEvent;
import ddd.kanban.domain.model.DomainEventBus;
import ddd.kanban.usecase.DomainEventHandler;
import ddd.kanban.usecase.EntityMapper;
import ddd.kanban.usecase.board.create.CreateBoardInput;
import ddd.kanban.usecase.board.create.CreateBoardOutput;
import ddd.kanban.usecase.board.create.CreateBoardUseCase;
import ddd.kanban.usecase.repository.BoardRepository;
import ddd.kanban.usecase.repository.WorkflowRepository;

import java.util.UUID;


public class Controller {
    private BoardRepository boardRepository;
    private WorkflowRepository workflowRepository;
    private DomainEventBus domainEventBus;
    private EntityMapper entityMapper;

    public Controller(BoardRepository boardRepository, DomainEventBus domainEventBus){
        this.boardRepository = boardRepository;
        this.workflowRepository = new InMemoryWorkflowRepository();
        this.domainEventBus = domainEventBus;
        this.entityMapper = new EntityMapper();
    }

    public void createBoard(JsonObject jsonObject) {
        String title = jsonObject.get("title").getAsString();
        String description = jsonObject.get("description").getAsString();


        CreateBoardUseCase createBoardUseCase = new CreateBoardUseCase(boardRepository, domainEventBus);
        CreateBoardInput createBoardInput = new CreateBoardInput(title, description);
        CreateBoardOutput createBoardOutput = new CreateBoardOutput();
        createBoardUseCase.execute(createBoardInput, createBoardOutput);
    }

}