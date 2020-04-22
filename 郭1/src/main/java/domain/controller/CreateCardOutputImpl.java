package domain.controller;

import domain.usecase.card.create.CreateCardOutput;

public class CreateCardOutputImpl implements CreateCardOutput {
    private String _id ;
    public void setCardId(String id) {
        this._id = id ;
    }

    public String getCardId() {
        return this._id;
    }
}
