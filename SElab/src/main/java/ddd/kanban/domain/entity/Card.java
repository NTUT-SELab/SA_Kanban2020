package ddd.kanban.domain.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class Card {
    private final List<Task> tasks;
    private String name;
    private String id;

    public Card(String id, String name){
        this.id = id;
        this.name = name;
        tasks = new ArrayList<Task>();
    }

    public void createTask(String taskName) {
        tasks.add(new Task("001", taskName));
    }

    public Optional<Task> findById(String taskId){
        return tasks.stream()
                    .filter(given(taskId))
                    .findFirst();
    }

    public static Predicate<Task> given(String id){
        return task -> task.getId().equals(id);
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

}
