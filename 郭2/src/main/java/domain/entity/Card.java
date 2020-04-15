package domain.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Card {
    private String cardId;
    private String cardName;
    private String stageId;
    public Card(String cardName, String stageId){
        this.cardName = cardName;
        this.cardId = UUID.randomUUID().toString();
        this.stageId = stageId;
    }

    public String getCardId() {
        return cardId;
    }

    public String getStageId() {
        return stageId;
    }

    public String getCardName() {
        return cardName;
    }
}
