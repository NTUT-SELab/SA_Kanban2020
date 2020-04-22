package domain.usecase;

import domain.controller.CreateCardInputImpl;
import domain.controller.CreateCardInputInterface;
import domain.controller.CreateCardOutputImpl;
import domain.controller.CreateCardOutputInterface;
import domain.entity.CardRepository;
import org.junit.Test;

import static org.junit.Assert.*;

public class CreateCardTest {

    @Test
    public void CreateCard() {
        CreateCardUseCase createCardUseCase = new CreateCardUseCase();
        CreateCardInputInterface CreateCardInput = new CreateCardInputImpl();
        CreateCardOutputInterface CreateCardOutput = new CreateCardOutputImpl();

        CardRepository cardRepository = CardRepository.getInstance();

        CreateCardInput.setCardName( "card1" ) ;
        createCardUseCase.execute( CreateCardInput, CreateCardOutput ) ;

        assertNotNull(cardRepository.get(CreateCardOutput.getCardId()));
    }
}
