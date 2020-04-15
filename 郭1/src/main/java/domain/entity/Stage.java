package domain.entity;

import java.util.UUID;

public class Stage {
    private String name;
    private String id;

    public Stage(){
        this.id = UUID.randomUUID().toString();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return this.id;
    }
}
