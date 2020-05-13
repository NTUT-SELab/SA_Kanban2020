package controller;

import ddd.kanban.adapter.repository.board.InMemoryBoardRepository;
import ddd.kanban.adapter.repository.workflow.InMemoryWorkflowRepository;
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
    public Controller(){
        boardRepository = new InMemoryBoardRepository();
        this.workflowRepository = new InMemoryWorkflowRepository();
        this.domainEventBus = new DomainEventBus();
        this.domainEventBus.register(new DomainEventHandler(workflowRepository, boardRepository, this.domainEventBus));
        this.entityMapper = new EntityMapper();
    }

    public void createBoard() {

        CreateBoardUseCase createBoardUseCase = new CreateBoardUseCase(boardRepository, domainEventBus);
        CreateBoardInput createBoardInput = new CreateBoardInput(title, description);
        CreateBoardOutput createBoardOutput = new CreateBoardOutput();
        createBoardUseCase.execute(createBoardInput, createBoardOutput);
    }


}
