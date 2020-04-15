package ddd.kanban.domain.usecase;

public class CreateCardInput {
    private String cardName;

    public CreateCardInput(String name){
        this.cardName = name;
    }

    public String getCardName() {
        return cardName;
    }
}
