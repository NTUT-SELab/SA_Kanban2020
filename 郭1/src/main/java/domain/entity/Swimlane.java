package domain.entity;

import java.util.HashMap;
import java.util.Random;
import java.util.UUID;

public class Swimlane {

    private String id;
    private String name;
    private HashMap<String, Card> cards;


    public Swimlane(){
        cards = new HashMap<String, Card>();
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
