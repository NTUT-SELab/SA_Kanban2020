package ddd.kanban.domain.usecase.repository;

import ddd.kanban.domain.model.card.Card;

import java.util.Optional;

public interface CardRepository {
    void add(Card card);

    void update(Card card);

    void save(Card card);

    Optional<Card> findById(String cardId);
}
