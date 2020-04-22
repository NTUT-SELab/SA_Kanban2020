package domain.usecase.card;

import domain.entity.Card;

public interface CardRepository {
    void save(Card newCard);

    Card get(String id);
}
