package domain.usecase.card.repository;

import domain.aggregate.card.Card;

public interface ICardRepository {
    void add(Card card);

    Card getCardById(String cardId);

    void save(Card card);
}
