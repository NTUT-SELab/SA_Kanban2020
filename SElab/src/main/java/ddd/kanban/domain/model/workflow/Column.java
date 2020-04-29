package ddd.kanban.domain.model.workflow;

import ddd.kanban.domain.model.card.Card;

import java.util.ArrayList;
import java.util.List;

public class Column {

    private String title;
    private String id;
    private String workflowId;
    private List<Card> cards;

    public Column(String title, String id, String workflowId){
        this.workflowId = workflowId;
        this.id = id;
        this.title = title;
        this.cards = new ArrayList<Card>();
    }

    public String getTitle() {
        return title;
    }

    public String getId() {
        return id;
    }
}
