package kanban.domain.usecase;

import kanban.domain.Utility;
import kanban.domain.usecase.card.commit.CommitCardInput;
import kanban.domain.usecase.card.commit.CommitCardOutput;
import kanban.domain.usecase.card.commit.CommitCardUseCase;
import kanban.domain.usecase.workflow.repository.WorkflowRepository;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CommitCardTest {

    private String workflowId;
    private String stageId;
    private WorkflowRepository workflowRepository = new WorkflowRepository();
    private Utility utility;

    @Before
    public void setup() {
        workflowRepository = new WorkflowRepository();
        utility = new Utility(workflowRepository);
        workflowId = utility.createWorkflow("boardId","workflowName");
        stageId = utility.createStage(workflowId,"stageName");
    }

    @Test
    public void Should_Card_Can_Commit_In_Stage() {
        CommitCardUseCase commitCardUseCase = new CommitCardUseCase(workflowRepository);
        CommitCardInput input = new CommitCardInput();
        input.setCardId("cardId");
        input.setWorkflowId(workflowId);
        input.setStageId(stageId);
        CommitCardOutput output = new CommitCardOutput();

        commitCardUseCase.execute(input, output);

        assertEquals("cardId", output.getCardId());
    }
}
