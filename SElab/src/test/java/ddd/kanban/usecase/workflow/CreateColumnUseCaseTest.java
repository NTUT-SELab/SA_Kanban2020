package ddd.kanban.usecase.workflow;

import ddd.kanban.adapter.repository.workflow.InMemoryWorkflowRepository;
import ddd.kanban.domain.model.workflow.Workflow;
import ddd.kanban.usecase.workflow.create.CreateColumnInput;
import ddd.kanban.usecase.workflow.create.CreateColumnOutput;
import ddd.kanban.usecase.repository.WorkflowRepository;
import ddd.kanban.usecase.workflow.create.CreateColumnUseCase;
import org.junit.Before;
import org.junit.Test;

import java.util.UUID;

import static junit.framework.TestCase.assertEquals;

public class CreateColumnUseCaseTest {
    private WorkflowRepository inMemoryWorkflowRepository;
    private String workflowId;

    @Before
    public void setUp(){
        workflowId = UUID.randomUUID().toString();
        inMemoryWorkflowRepository = new InMemoryWorkflowRepository();
        Workflow workflow = new Workflow(workflowId, "In Progress");
        inMemoryWorkflowRepository.add(workflow);
    }


    @Test
    public void testCreateColumn(){
        CreateColumnUseCase createColumnUseCase = new CreateColumnUseCase(inMemoryWorkflowRepository);
        CreateColumnInput createColumnInput = new CreateColumnInput("column", workflowId);
        CreateColumnOutput createColumnOutput = new CreateColumnOutput();

        createColumnUseCase.execute(createColumnInput, createColumnOutput);

        assertEquals("column", createColumnOutput.getColumnTitle());
    }
}
