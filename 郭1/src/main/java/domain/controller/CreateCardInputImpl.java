package domain.controller;

import domain.usecase.card.create.CreateCardInput;

public class CreateCardInputImpl implements CreateCardInput {
    private String _name ;
    public void setCardName(String name) {
        this._name = name ;
    }

    public String getCardName() {
        return this._name ;
    }
}
