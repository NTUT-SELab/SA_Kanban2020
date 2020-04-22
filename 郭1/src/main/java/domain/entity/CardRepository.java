package domain.entity;

import java.util.HashMap;

public class CardRepository {
    private HashMap<String, Card> _cardRepository ;
    private static CardRepository _instance;

    private CardRepository(){
        _cardRepository = new HashMap<String, Card>() ;
    }

    public static CardRepository getInstance() {
        if ( _instance == null )
            _instance = new CardRepository() ;
        return _instance;
    }
    public void add( Card newCard ){
        this._cardRepository.put(newCard.getId(), newCard) ;
    }

    public Card get( String id ){
        return this._cardRepository.get(id) ;
    }
}
