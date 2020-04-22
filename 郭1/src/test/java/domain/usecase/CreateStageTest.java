package domain.usecase;

import domain.controller.CreateStageInputImpl;
import domain.controller.CreateStageOutputImpl;
import domain.entity.Workflow;
import domain.usecase.stage.create.CreateStageInput;
import domain.usecase.stage.create.CreateStageOutput;
import domain.usecase.stage.create.CreateStageUseCase;
import domain.adapter.WorkflowRepositoryImpl;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class CreateStageTest {
    @Test
    public void createStage() {

        WorkflowRepositoryImpl workflowRepository = new WorkflowRepositoryImpl();
        Workflow workflow = new Workflow();
        workflow.setName("workflow1");
        workflowRepository.save(workflow);

        CreateStageUseCase createStage = new CreateStageUseCase(workflowRepository) ;
        CreateStageInput createStageInput = new CreateStageInputImpl() ;
        CreateStageOutput createStageOutput = new CreateStageOutputImpl() ;

        createStageInput.setStageName("backlog");
        createStageInput.setWorkflowId(workflow.getId());

        createStage.execute( createStageInput, createStageOutput ) ;

        assertNotNull(createStageOutput.getStageId());
    }
}
