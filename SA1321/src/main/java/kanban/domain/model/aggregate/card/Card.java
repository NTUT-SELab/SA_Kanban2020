package kanban.domain.model.aggregate.card;

import java.util.UUID;

public class Card {

    private String name;
    private String cardId;

    public Card(String name) {
        this.name = name;
        this.cardId = UUID.randomUUID().toString();
    }

    public String getCardId() {
        return cardId;
    }

    public String getCardName() {
        return name;
    }
}
