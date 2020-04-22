package ddd.kanban.domain.usecase;

import ddd.kanban.domain.model.card.Card;
import ddd.kanban.domain.model.card.Task;
import ddd.kanban.domain.usecase.inputdata.CreateTaskInput;
import ddd.kanban.domain.usecase.outputdata.CreateTaskOutput;
import ddd.kanban.domain.usecase.repository.CardRepository;

import java.util.Optional;

public class CreateTaskUseCase {
    private CardRepository cardRepository;

    public CreateTaskUseCase(CardRepository cardRepository){
        this.cardRepository = cardRepository;
    }

    public void execute(CreateTaskInput createTaskInput, CreateTaskOutput createTaskOutput) {
        Optional<Card> card = cardRepository.findById(createTaskInput.getCardId());
        card.ifPresent(c -> {
            String taskName = c.createTask(createTaskInput.getTaskName());
                createTaskOutput.setTaskName(taskName);
                cardRepository.save(c);
        });
    }
}
