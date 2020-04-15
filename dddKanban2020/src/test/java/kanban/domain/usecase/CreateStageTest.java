package kanban.domain.usecase;

import kanban.domain.model.Workflow;
import kanban.domain.usecase.CreateStageOutput;
import kanban.domain.usecase.CreateStageUseCase;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CreateStageTest {

    @Test
    public void createStage(){

        WorkflowRepository repository = new WorkflowRepository();

        repository.add(new Workflow("123-456-789"));

        CreateStageUseCase createStageUseCase =
                new CreateStageUseCase(repository);

        CreateStageInput input = new CreateStageInput();
        CreateStageOutput output = new CreateStageOutput();

        input.setWorkflowId("123-456-789");
        input.setStageName("Backlog");

        createStageUseCase.execute(input, output);


        assertNotNull(output.getStageId());


    }

}
