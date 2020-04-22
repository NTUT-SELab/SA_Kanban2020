package ddd.kanban.domain.model.card;

public class Task {

    private String id;
    private String name;

    public Task(String id, String name){
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }


}
