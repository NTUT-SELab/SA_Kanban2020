package domain.usecase;

import domain.entity.Stage;
import domain.entity.Workflow;

public class CreateStageUseCase {
    private WorkflowRepository workflowRepository;
    private Stage stage;

    public CreateStageUseCase(WorkflowRepository workflowRepository){
        this.workflowRepository = workflowRepository;
    }

    public void execute(StageUseCaseInput input, StageUseCaseOutput output) {
        Workflow workflow = workflowRepository.getWorkflowById(input.getWorkflowId());
        stage = new Stage(input.getWorkflowId(), input.getStageName());
        workflow.addStage(stage);
        output.setWorkflowId(stage.getWorkflowId());
        output.setStageName(stage.getStageName());
        output.setStageId(stage.getStageId());
    }
}
