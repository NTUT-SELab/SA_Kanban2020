package ddd.kanban.usecase.card.create;

import ddd.kanban.adapter.repository.card.InMemoryCardRepository;
import ddd.kanban.domain.model.card.Card;
import ddd.kanban.domain.model.card.CardType;
import ddd.kanban.usecase.repository.CardRepository;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CreateCardUseCaseTest {
    private CardRepository cardRepository;

    @Before
    public void setUp(){
        cardRepository = new InMemoryCardRepository();
    }

    @Test
    public void testCreateCardUseCase(){
        String cardName = "TestCard";

        CreateCardUseCase createCardUseCase = new CreateCardUseCase(cardRepository);
        CreateCardInput createCardInput = new CreateCardInput(cardName);
        CreateCardOutput createCardOutput = new CreateCardOutput();

        createCardUseCase.execute(createCardInput, createCardOutput);

        assertEquals(cardName, createCardOutput.getCardTitle());
        assertEquals(cardDescription, createCardOutput.getCardDescription());
        assertEquals(cardCardType, createCardOutput.getCardCardType());
        assertEquals(cardTags, createCardOutput.getCardTags());
        assertEquals(cardAssignUsers, createCardOutput.getCardAssignUsers());
        assertEquals(cardPlannedStartDate, createCardOutput.getCardPlannedStartDate());
        assertEquals(cardPlannedFinishDate, createCardOutput.getCardPlannedFinishDate());
        assertEquals(cardPriority, createCardOutput.getCardPriority());

    }



}
