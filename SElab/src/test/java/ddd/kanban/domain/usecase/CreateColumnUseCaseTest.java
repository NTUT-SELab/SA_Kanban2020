package ddd.kanban.domain.usecase;

import ddd.kanban.domain.adapter.repository.InMemoryWorkflowRepository;
import ddd.kanban.domain.model.workflow.Workflow;
import ddd.kanban.domain.usecase.inputdata.CreateColumnInput;
import ddd.kanban.domain.usecase.outputdata.CreateColumnOutput;
import ddd.kanban.domain.usecase.repository.WorkflowRepository;
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

        assertEquals("column", createColumnOutput.getColumnName());
    }
}
