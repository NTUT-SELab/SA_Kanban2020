package ddd.kanban.domain.usecase;

import ddd.kanban.domain.entity.Card;
import ddd.kanban.domain.entity.Task;

public class CardRepository {
    public CardRepository(){

    }

    public Card findById(String cardId){
        return new Card(cardId,"testCard");
    }

    public void save(Card card) {
    }
}
