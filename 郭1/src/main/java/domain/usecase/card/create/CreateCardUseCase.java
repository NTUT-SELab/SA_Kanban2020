package domain.usecase.card.create;

import domain.entity.Card;
import domain.usecase.card.CardRepository;

public class CreateCardUseCase {
    private CardRepository cardRepository;

    public CreateCardUseCase(CardRepository cardRepository){
        this.cardRepository = cardRepository;
    }

    public void execute(CreateCardInput input, CreateCardOutput output ) {

        Card newCard = new Card() ;
        newCard.setName( input.getCardName() ) ;

        cardRepository.save( newCard ) ;

        output.setCardId( newCard.getId()) ;

    }


}
