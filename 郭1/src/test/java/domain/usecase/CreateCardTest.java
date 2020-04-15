package domain.usecase;

import domain.controller.CreateCardInputImpl;
import domain.controller.CreateCardOutputImpl;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class CreateCardTest {

    @Test
    public void CreateCard() {
        CreateCardUseCase createCardUseCase = new CreateCardUseCase();
        CreateCardInputInterface CreateCardInput = new CreateCardInputImpl();
        CreateCardOutputInterface CreateCardOutput = new CreateCardOutputImpl();

        CreateCardInput.setCardName( "card1" ) ;
        createCardUseCase.execute( CreateCardInput, CreateCardOutput ) ;
        assertNotNull( CreateCardOutput.getCardId() ) ;
    }
}
