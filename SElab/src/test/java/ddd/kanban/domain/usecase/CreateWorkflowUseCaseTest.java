package ddd.kanban.domain.usecase;

import ddd.kanban.domain.adapter.repository.InMemoryWorkflowRepository;
import ddd.kanban.domain.model.workflow.Workflow;
import ddd.kanban.domain.usecase.inputdata.CreateWorkflowInput;
import ddd.kanban.domain.usecase.outputdata.CreateWorkflowOutput;
import ddd.kanban.domain.usecase.repository.WorkflowRepository;
import org.junit.Before;
import org.junit.Test;

import java.util.UUID;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CreateWorkflowUseCaseTest {
    private WorkflowRepository inMemoryWorkflowRepository;
    private String workflowId;
    @Before
    public void setUp(){
        workflowId = UUID.randomUUID().toString();
        inMemoryWorkflowRepository = new InMemoryWorkflowRepository();
    }
    @Test
    public void testCreateWorkflow() {
        CreateWorkflowUseCase createWorkflowUseCase = new CreateWorkflowUseCase(inMemoryWorkflowRepository);
        CreateWorkflowInput createWorkflowInput = new CreateWorkflowInput(workflowId,"Workflow 1");
        CreateWorkflowOutput createWorkflowOutput = new CreateWorkflowOutput();
        createWorkflowUseCase.execute(createWorkflowInput, createWorkflowOutput);
        assertEquals("Workflow 1", createWorkflowOutput.getWorkflowName());
        assertNotNull(createWorkflowOutput.getWorkflowId());
    }
}
