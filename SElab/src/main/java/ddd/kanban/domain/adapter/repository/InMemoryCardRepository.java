package ddd.kanban.domain.adapter.repository;

import ddd.kanban.domain.model.card.Card;
import ddd.kanban.domain.usecase.repository.CardRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class InMemoryCardRepository implements CardRepository {
    private List<Card> cards;

    public InMemoryCardRepository(){
        cards = new ArrayList<Card>();
    }

    @Override
    public void add(Card card){
        cards.add(card);
    }

    @Override
    public void update(Card card){
        for(int i = 0 ; i < cards.size() ; i ++)
        {
            if(cards.get(i).getId() == card.getId())
            {
                cards.set(i, card);
            }
        }
    }

    @Override
    public void save(Card card){
    }

    @Override
    public Optional<Card> findById(String cardId){
        return cards.stream()
                    .filter(findCardById(cardId))
                    .findFirst();
    }

    private static Predicate<Card> findCardById(String cardId){
        return card -> card.getId().equals(cardId);
    }
}
