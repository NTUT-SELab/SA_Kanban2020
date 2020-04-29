package ddd.kanban.domain.model.workflow;

import java.util.ArrayList;
import java.util.List;

public class Column {

    private String title;
    private String id;
    private String workflowId;
    private List<CommittedCard> committedCards;

    public Column(String title, String id, String workflowId){
        this.workflowId = workflowId;
        this.id = id;
        this.title = title;
        this.committedCards = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public String getId() {
        return id;
    }

    public String commitCard(String cardId, String workflowId) {
        CommittedCard committedCard = new CommittedCard(cardId, workflowId);
        this.committedCards.add(committedCard);
        return cardId;
    }

    public List<CommittedCard> getCommittedCards() {
        return committedCards;
    }

}
