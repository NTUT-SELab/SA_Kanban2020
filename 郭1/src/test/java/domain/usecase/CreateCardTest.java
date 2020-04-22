package domain.usecase;

import domain.adapter.CardRepositoryImpl;
import domain.controller.CreateCardInputImpl;
import domain.controller.CreateCardOutputImpl;
import domain.adapter.CardRepositoryImpl;
import domain.entity.Card;
import domain.usecase.card.CardRepository;
import domain.usecase.card.create.CreateCardInput;
import domain.usecase.card.create.CreateCardOutput;
import domain.usecase.card.create.CreateCardUseCase;
import org.junit.Test;

import static org.junit.Assert.*;

public class CreateCardTest {

    @Test
    public void CreateCard() {
        CardRepository cardRepository = new CardRepositoryImpl();
        CreateCardUseCase createCardUseCase = new CreateCardUseCase(cardRepository);
        CreateCardInput CreateCardInput = new CreateCardInputImpl();
        CreateCardOutput CreateCardOutput = new CreateCardOutputImpl();


        CreateCardInput.setCardName( "card1" ) ;
        createCardUseCase.execute( CreateCardInput, CreateCardOutput ) ;

        assertNotNull(CreateCardOutput.getCardId());
    }
}
