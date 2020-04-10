package kanban.domain.usecase;

import kanban.domain.Utility;
import kanban.domain.model.Workflow;
import kanban.domain.usecase.stage.create.CreateStageInput;
import kanban.domain.usecase.stage.create.CreateStageOutput;
import kanban.domain.usecase.stage.create.CreateStageUseCase;
import kanban.domain.usecase.workflow.WorkflowRepository;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CreateStageTest {
    private String workflowId;
    private WorkflowRepository workflowRepository;
    private Utility utility;

    @Before
    public void setup() {
        workflowRepository = new WorkflowRepository();
        utility = new Utility(workflowRepository);
        workflowId = utility.createWorkflow("boardId", "workflowName");
    }

    @Test
    public void Create_stage_should_success() {
        CreateStageUseCase createStageUseCase = new CreateStageUseCase(workflowRepository);
        CreateStageInput input = new CreateStageInput();
        input.setStageName("stage");
        input.setWorkflowId(workflowId);
        CreateStageOutput output = new CreateStageOutput();

        createStageUseCase.execute(input, output);

        assertNotNull(output.getStageId());
        assertEquals("stage", output.getStageName());
    }

    @Test(expected = RuntimeException.class)
    public void GetStageNameById_should_throw_exception() {
        Workflow workflow = workflowRepository.getWorkflowById(workflowId);
        workflow.getStageById("123-456-789");
    }
}
