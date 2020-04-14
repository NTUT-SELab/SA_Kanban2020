package ddd.kanban.domain.usecase;

import ddd.kanban.domain.entity.Card;
import ddd.kanban.domain.entity.Task;

import java.util.Optional;

public class CreateTaskUseCase {
    private CardRepository taskRepository;

    public CreateTaskUseCase(){
        taskRepository = new CardRepository();
    }

    public void execute(CreateTaskInput createTaskInput, CreateTaskOutput createTaskOutput) {
        Card card = taskRepository.findById(createTaskInput.getCardId());
        card.createTask(createTaskInput.getTaskName());

        Optional<Task> task = card.findById("001");
        task.ifPresent(t -> {
            createTaskOutput.setTaskName(t.getName());
        });
    }
}
