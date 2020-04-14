package kanban.domain.usecase;

import kanban.domain.Utility;
import kanban.domain.usecase.workflow.create.CreateWorkflowInput;
import kanban.domain.usecase.workflow.create.CreateWorkflowOutput;
import kanban.domain.usecase.workflow.create.CreateWorkflowUseCase;
import kanban.domain.usecase.workflow.WorkflowRepository;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CreateWorkflowTest {

    private WorkflowRepository workflowRepository;
    private Utility utility;

    @Before
    public void setUp(){
        workflowRepository = new WorkflowRepository();
        utility = new Utility(workflowRepository);
    }

    @Test
    public void Create_workflow_should_success() {
        WorkflowRepository workflowRepository = new WorkflowRepository();
        CreateWorkflowUseCase createWorkflowUseCase = new CreateWorkflowUseCase(workflowRepository);

        CreateWorkflowInput input = new CreateWorkflowInput();
        input.setBoardId("boardId");
        input.setWorkflowName("workflow");

        CreateWorkflowOutput output = new CreateWorkflowOutput();

        createWorkflowUseCase.execute(input, output);

        assertNotNull(output.getWorkflowId());
        assertEquals("workflow", output.getWorkflowName());
    }

    @Test(expected = RuntimeException.class)
    public void Workflow_repository_should_throw_exception() {
        utility.createWorkflow("boardId","workflowName");
        workflowRepository.getWorkflowById("123-456-789");
    }
}
