package kanban.domain.usecase;

import kanban.domain.model.Stage;
import kanban.domain.model.Workflow;


public class CreateStageUseCase {
    private WorkflowRepository workflowRepository;

    public CreateStageUseCase(WorkflowRepository repository) {
        workflowRepository = repository;
    }

    public void execute(
            CreateStageInput input,
            CreateStageOutput output) {

        Workflow workflow =
                workflowRepository.findById(input.getWorkflowId());

        output.setStageId(workflow.createStage(input.getStageName()));


    }
}
