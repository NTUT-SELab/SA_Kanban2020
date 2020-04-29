package ddd.kanban.usecase.card.create;

import ddd.kanban.adapter.repository.board.InMemoryBoardRepository;
import ddd.kanban.adapter.repository.card.InMemoryCardRepository;
import ddd.kanban.adapter.repository.workflow.InMemoryWorkflowRepository;
import ddd.kanban.domain.model.DomainEventBus;
import ddd.kanban.domain.model.card.Card;
import ddd.kanban.domain.model.workflow.Column;
import ddd.kanban.domain.model.workflow.Workflow;
import ddd.kanban.usecase.Create;
import ddd.kanban.usecase.DomainEventHandler;
import ddd.kanban.usecase.repository.BoardRepository;
import ddd.kanban.usecase.repository.CardRepository;
import ddd.kanban.usecase.repository.WorkflowRepository;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CreateCardUseCaseTest {
    private CardRepository cardRepository;
    private Create create;
    private String boardId;
    private String workflowId;
    private String columnId;
    private DomainEventBus domainEventBus;
    private WorkflowRepository workflowRepository;
    private BoardRepository boardRepository;

    @Before
    public void setUp(){
        cardRepository = new InMemoryCardRepository();

        this.workflowRepository = new InMemoryWorkflowRepository();
        this.boardRepository = new InMemoryBoardRepository();
        create = new Create(boardRepository, workflowRepository);
        this.boardId = create.CreateBoard();
        this.workflowId = create.CreateWorkflow(this.boardId);
        this.columnId = create.CreateColumn(this.workflowId);
        this.domainEventBus = new DomainEventBus();
        domainEventBus.register(new DomainEventHandler(this.workflowRepository));
    }

    @Test
    public void testCreateCardUseCase(){
        String cardName = "TestCard";

        CreateCardUseCase createCardUseCase = new CreateCardUseCase(cardRepository, domainEventBus);
        CreateCardInput createCardInput = new CreateCardInput(cardName, this.boardId, this.workflowId, this.columnId);
        CreateCardOutput createCardOutput = new CreateCardOutput();

        createCardUseCase.execute(createCardInput, createCardOutput);

        Card card = cardRepository.findById(createCardOutput.getCardId());

        assertEquals(card.getTitle(), createCardOutput.getCardTitle());

        Workflow workflow = workflowRepository.findById(this.workflowId);
        Column column = workflow.findColumnById(this.columnId);

        assertEquals(1, column.getCommittedCards().size());

    }



}
