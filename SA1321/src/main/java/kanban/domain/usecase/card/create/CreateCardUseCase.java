package kanban.domain.usecase.card.create;

import kanban.domain.model.aggregate.card.Card;
import kanban.domain.usecase.card.CardRepository;
import kanban.domain.usecase.card.commit.CommitCardInput;
import kanban.domain.usecase.card.commit.CommitCardOutput;
import kanban.domain.usecase.card.commit.CommitCardUseCase;
import kanban.domain.usecase.workflow.repository.WorkflowRepository;

public class CreateCardUseCase {

    private WorkflowRepository workflowRepository;
    private CardRepository cardRepository;

    public CreateCardUseCase(WorkflowRepository workflowRepository, CardRepository cardRepository) {
        this.workflowRepository = workflowRepository;
        this.cardRepository = cardRepository;
    }

    public void execute(CreateCardInput input, CreateCardOutput output) {
        Card card = new Card(input.getCardName());
        cardRepository.add(card);
        output.setCardId(card.getCardId());
        output.setCardName(card.getCardName());

        CommitCardUseCase commitCardUseCase = new CommitCardUseCase(workflowRepository);
        CommitCardInput commitCardInput = new CommitCardInput();
        commitCardInput.setCardId(card.getCardId());
        commitCardInput.setStageId(input.getStageId());
        commitCardInput.setWorkflowId(input.getWorkflowId());
        CommitCardOutput commitCardOutput = new CommitCardOutput();

        commitCardUseCase.execute(commitCardInput, commitCardOutput);
    }

}
