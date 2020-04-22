package kanban.domain.usecase;

import kanban.domain.Utility;
import kanban.domain.adapter.repository.board.InMemoryBoardRepository;
import kanban.domain.adapter.repository.workflow.InMemoryWorkflowRepository;
import kanban.domain.usecase.board.repository.IBoardRepository;
import kanban.domain.usecase.workflow.commit.CommitWorkflowInput;
import kanban.domain.usecase.workflow.commit.CommitWorkflowOutput;
import kanban.domain.usecase.workflow.commit.CommitWorkflowUseCase;
import kanban.domain.usecase.workflow.repository.IWorkflowRepository;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CommitWorkflowTest {

    IBoardRepository boardRepository;
    IWorkflowRepository workflowRepository;
    Utility utility;

    @Before
    public void setUp() throws Exception {
        boardRepository = new InMemoryBoardRepository();
        workflowRepository = new InMemoryWorkflowRepository();
        utility = new Utility(boardRepository, workflowRepository);
    }

    @Test
    public void Should_Workflow_Can_Commit_In_Board() {
        String boardId = utility.createBoard("board");
        CommitWorkflowUseCase commitWorkflowUseCase = new CommitWorkflowUseCase(boardRepository);
        CommitWorkflowInput input = new CommitWorkflowInput();
        CommitWorkflowOutput output = new CommitWorkflowOutput();

        input.setBoardId(boardId);
        input.setWorkflowId("workflowId");
        commitWorkflowUseCase.execute(input, output);
        assertEquals("workflowId",output.getWorkflowId());

    }
}
