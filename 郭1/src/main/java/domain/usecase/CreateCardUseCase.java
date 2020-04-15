package domain.usecase;

import domain.entity.Card;

public class CreateCardUseCase {
    private CreateCardInputInterface _input ;
    private CreateCardOutputInterface _output ;

    public void execute( CreateCardInputInterface input, CreateCardOutputInterface output ) {
        this._input = input ;
        this._output = output ;

        Card newCard = new Card() ;
        newCard.setName( input.getCardName() ) ;

        output.setCardId( newCard.getId()) ;
    }


}
