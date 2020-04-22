package domain.usecase.stage.create;

import domain.aggregate.workflow.Stage;
import domain.aggregate.workflow.Workflow;
import domain.usecase.workflow.repository.IWorkflowRepository;

public class CreateStageUseCase {
    private IWorkflowRepository workflowRepository;
    private Stage stage;

    public CreateStageUseCase(IWorkflowRepository workflowRepository){
        this.workflowRepository = workflowRepository;
    }

    public void execute(CreateStageUseCaseInput input, CreateStageUseCaseOutput output) {
        Workflow workflow = workflowRepository.getWorkflowById(input.getWorkflowId());
        stage = workflow.createStage(input.getStageName());

        workflow.addStage(stage);
        workflowRepository.save(workflow);

        output.setWorkflowId(stage.getWorkflowId());
        output.setStageName(stage.getStageName());
        output.setStageId(stage.getStageId());
    }
}
