package domain.entity;

import java.util.UUID;

public class Workflow {
    private String name;
    private String id;

    public Workflow(){
        this.id = UUID.randomUUID().toString();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return this.id;
    }
}
