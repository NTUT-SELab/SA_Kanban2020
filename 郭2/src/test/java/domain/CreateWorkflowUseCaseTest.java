package domain;

import domain.usecase.CreateWorkflowUseCase;
import domain.usecase.WorkflowRepository;
import domain.usecase.WorkflowUseCaseInput;
import domain.usecase.WorkflowUseCaseOutput;

import org.junit.*;

import static org.junit.Assert.*;

public class CreateWorkflowUseCaseTest {

    @Test
    public void WorkflowUseCaseInputTest(){
        WorkflowUseCaseInput input = new WorkflowUseCaseInput();

        input.setWorkflowName("workflow1");

        assertEquals("workflow1", input.getWorkflowName());
    }

    @Test
    public void WorkflowUseCaseOutputTest(){
        WorkflowUseCaseOutput output = new WorkflowUseCaseOutput();

        output.setWorkflowName("workflow1");

        assertEquals("workflow1", output.getWorkflowName());
    }

    @Test
    public void WorkflowRepositoryTest(){
        WorkflowRepository workflowRepository = new WorkflowRepository();
        CreateWorkflowUseCase createWorkflowUseCase = new CreateWorkflowUseCase(workflowRepository);
        WorkflowUseCaseInput input = new WorkflowUseCaseInput();
        WorkflowUseCaseOutput output = new WorkflowUseCaseOutput();

        input.setWorkflowName("workflow1");

        createWorkflowUseCase.execute(input, output);

        try {
            assertEquals("workflow1", workflowRepository.getWorkflowById(output.getWorkflowId()).getWorkflowName());
            workflowRepository.getWorkflowById("???").getWorkflowName();
        } catch (Exception e){
            assertEquals("not found", e.getMessage());
        }
    }

    @Test
    public void createWorkflowTest(){
        WorkflowRepository workflowRepository = new WorkflowRepository();
        CreateWorkflowUseCase createWorkflowUseCase = new CreateWorkflowUseCase(workflowRepository);
        WorkflowUseCaseInput input = new WorkflowUseCaseInput();
        WorkflowUseCaseOutput output = new WorkflowUseCaseOutput();

        input.setWorkflowName("workflow1");

        createWorkflowUseCase.execute(input, output);

        assertNotNull(output.getWorkflowId());
        assertEquals("workflow1", output.getWorkflowName());
    }
}
