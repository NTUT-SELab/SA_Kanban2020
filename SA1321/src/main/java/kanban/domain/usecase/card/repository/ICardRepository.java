package kanban.domain.usecase.card.repository;

import kanban.domain.model.aggregate.card.Card;

public interface ICardRepository {
    void add(Card card);
}
