package domain.entity;

import java.util.UUID;

public class Task {
    private String id;
    private String name;

    public Task(){
        this.id = UUID.randomUUID().toString();
    }

    public void setName(String taskName) {
        this.name = taskName;
    }

    public String getName() {
        return this.name;
    }

    public String getId() {
        return this.id;
    }
}
