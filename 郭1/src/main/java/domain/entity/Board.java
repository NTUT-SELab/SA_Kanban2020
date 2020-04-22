package domain.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Board {
    private String id;
    private String name;
    private List<Workflow> workflows;

    public Board(){
        workflows = new ArrayList<Workflow>();
        this.id = UUID.randomUUID().toString();
    }

    public void add(Workflow workflow){
        workflows.add(workflow);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }
}
