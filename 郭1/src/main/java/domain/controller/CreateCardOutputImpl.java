package domain.controller;

import domain.usecase.CreateCardOutputInterface;

public class CreateCardOutputImpl implements CreateCardOutputInterface {
    private String _id ;
    public void setCardId(String id) {
        this._id = id ;
    }

    public String getCardId() {
        return this._id;
    }
}
