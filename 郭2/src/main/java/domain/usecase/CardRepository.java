package domain.usecase;

import domain.entity.Card;
import domain.entity.Workflow;

import java.util.ArrayList;

public class CardRepository {
    private ArrayList<Card> cardList = new ArrayList<Card>();

    public void add(Card card) {
        cardList.add(card);
    }

    public Card getCardById(String cardId){
        for (Card each:cardList) {
            if(cardId.equals(each.getCardId()))
                return each;
        }
        throw new RuntimeException("not found");
    }
}
