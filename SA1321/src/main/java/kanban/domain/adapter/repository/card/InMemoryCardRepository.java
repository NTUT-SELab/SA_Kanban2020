package kanban.domain.adapter.repository.card;

import kanban.domain.model.aggregate.card.Card;
import kanban.domain.usecase.card.repository.ICardRepository;

import java.util.ArrayList;
import java.util.List;

public class InMemoryCardRepository implements ICardRepository {

    private List<Card> cards;

    public InMemoryCardRepository() {
        cards = new ArrayList<Card>();
    }

    @Override
    public void add(Card card) {
        cards.add(card);
    }
}
