package domain.usecase;

import domain.controller.CreateCardInputInterface;
import domain.controller.CreateCardOutputInterface;
import domain.entity.Card;
import domain.entity.CardRepository;

public class CreateCardUseCase {
    private CreateCardInputInterface _input ;
    private CreateCardOutputInterface _output ;

    public void execute( CreateCardInputInterface input, CreateCardOutputInterface output ) {
        this._input = input ;
        this._output = output ;

        Card newCard = new Card() ;
        newCard.setName( input.getCardName() ) ;

        CardRepository cardRepository = CardRepository.getInstance() ;
        cardRepository.add( newCard ) ;


        output.setCardId( newCard.getId()) ;

    }


}
