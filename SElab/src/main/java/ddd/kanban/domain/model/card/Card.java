package ddd.kanban.domain.model.card;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Predicate;

public class Card {
    private final List<Task> tasks;
    private String id;

    private String name;
    private String description;

    public Card(String id, String name, String description){
        this.id = id;
        this.name = name;
        this.description = description;
        tasks = new ArrayList<Task>();
    }

    public String createTask(String taskName) {
        Task task = new Task(UUID.randomUUID().toString(), taskName);
        tasks.add(task);
        return task.getName();
    }

    public Optional<Task> findTaskById(String taskId){
        return tasks.stream()
                    .filter(given(taskId))
                    .findFirst();
    }

    public static Predicate<Task> given(String id){
        return task -> task.getId().equals(id);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() { return description; }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
