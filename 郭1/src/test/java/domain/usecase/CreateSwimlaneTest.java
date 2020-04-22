package domain.usecase;

import domain.adapter.WorkflowRepositoryImpl;
import domain.controller.CreateSwimlaneInputImpl;
import domain.controller.CreateSwimlaneOutputImpl;
import domain.entity.Workflow;
import domain.usecase.swimlane.create.CreateSwimlaneInput;
import domain.usecase.swimlane.create.CreateSwimlaneOutput;
import domain.usecase.swimlane.create.CreateSwimlaneUseCase;
import domain.usecase.workflow.WorkflowRepository;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class CreateSwimlaneTest {

    @Test
    public void createSwimlane() {

        WorkflowRepository workflowRepository = new WorkflowRepositoryImpl();
        Workflow workflow = new Workflow();
        workflow.setName("workflow1");
        workflowRepository.save(workflow);
        String stageId = workflow.createStage("Develop");

        CreateSwimlaneUseCase createSwimlaneUseCase = new CreateSwimlaneUseCase(workflowRepository);
        CreateSwimlaneInput createSwimlaneInput = new CreateSwimlaneInputImpl();
        CreateSwimlaneOutput createSwimlaneOutput = new CreateSwimlaneOutputImpl();

        createSwimlaneInput.setName("Ready");
        createSwimlaneInput.setStageId(stageId);
        createSwimlaneInput.setWorkflowId(workflow.getId());

        createSwimlaneUseCase.execute(createSwimlaneInput,createSwimlaneOutput);


        assertNotNull(createSwimlaneOutput.getSwimlaneId());
    }

}
