package ddd.kanban.domain.usecase.inputdata;

public class CreateCardInput {

    private String cardName;
    private String cardDescription;

    public CreateCardInput(String cardName, String cardDescription){
        this.cardName = cardName;
        this.cardDescription = cardDescription;
    }

    public String getCardName() {
        return cardName;
    }

    public String getCardDescription() { return cardDescription; }
}
