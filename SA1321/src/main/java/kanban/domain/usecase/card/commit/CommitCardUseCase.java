package kanban.domain.usecase.card.commit;

import kanban.domain.model.Workflow;
import kanban.domain.usecase.workflow.WorkflowRepository;

public class CommitCardUseCase {

    private WorkflowRepository workflowRepository;

    public CommitCardUseCase(WorkflowRepository workflowRepository) {
        this.workflowRepository = workflowRepository;
    }

    public void execute(CommitCardInput input, CommitCardOutput output) {
        Workflow workflow = workflowRepository.getWorkflowById(input.getWorkflowId());
        String cardId = workflow.commitCardInStage(input.getCardId(), input.getStageId());
        workflowRepository.save(workflow);

        output.setCardId(cardId);
    }
}
