package kanban.domain.usecase;

import kanban.domain.Utility;
import kanban.domain.adapter.repository.board.InMemoryBoardRepository;
import kanban.domain.adapter.repository.card.InMemoryCardRepository;
import kanban.domain.adapter.repository.workflow.InMemoryWorkflowRepository;
import kanban.domain.model.aggregate.workflow.Workflow;
import kanban.domain.usecase.board.repository.IBoardRepository;
import kanban.domain.usecase.card.create.CreateCardInput;
import kanban.domain.usecase.card.create.CreateCardOutput;
import kanban.domain.usecase.card.create.CreateCardUseCase;
import kanban.domain.usecase.card.repository.ICardRepository;
import kanban.domain.usecase.workflow.repository.IWorkflowRepository;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CreateCardTest {

    private String boardId;
    private String workflowId;
    private String stageId;
    private IBoardRepository boardRepository;
    private IWorkflowRepository workflowRepository = new InMemoryWorkflowRepository();
    private ICardRepository cardRepository = new InMemoryCardRepository();
    private Utility utility;

    @Before
    public void setup() {
        boardRepository = new InMemoryBoardRepository();
        workflowRepository = new InMemoryWorkflowRepository();
        utility = new Utility(boardRepository, workflowRepository);
        boardId = utility.createBoard("test automation");
        workflowId = utility.createWorkflow(boardId,"workflowName");
        stageId = utility.createStage(workflowId,"stageName");
    }

    @Test
    public void Create_card_should_success() {
        Workflow workflow = workflowRepository.getWorkflowById(workflowId);
        assertEquals(0, workflow.getStageCloneById(stageId).getCardIds().size());

        CreateCardUseCase createCardUseCase = new CreateCardUseCase(workflowRepository, cardRepository);
        CreateCardInput input = new CreateCardInput();
        input.setCardName("card");
        input.setWorkflowId(workflowId);
        input.setStageId(stageId);
        CreateCardOutput output = new CreateCardOutput();

        createCardUseCase.execute(input, output);

        assertEquals("card", output.getCardName());
        assertNotNull(output.getCardId());

        workflow = workflowRepository.getWorkflowById(workflowId);
        assertEquals(1, workflow.getStageCloneById(stageId).getCardIds().size());
    }
}
