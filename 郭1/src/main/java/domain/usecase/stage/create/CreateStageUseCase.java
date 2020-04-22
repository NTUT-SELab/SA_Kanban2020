package domain.usecase.stage.create;

import domain.entity.Workflow;
import domain.adapter.WorkflowRepositoryImpl;

public class CreateStageUseCase {

    private WorkflowRepositoryImpl workflowRepository;

    public CreateStageUseCase(WorkflowRepositoryImpl workflowRepository){
        this.workflowRepository = workflowRepository;
    }

    public void execute(CreateStageInput createStageInput, CreateStageOutput createStageOutput) {

        Workflow workflow = workflowRepository.getWorkFlowById(createStageInput.getWorkflowId());

        String stageId = workflow.createStage(createStageInput.getStageName());
        workflowRepository.save(workflow);

        createStageOutput.setStageId(stageId) ;
    }


}
