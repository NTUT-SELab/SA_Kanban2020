package domain.controller;

import domain.usecase.CreateStageOutputInterface;

public class CreateStageOutputImpl implements CreateStageOutputInterface {
    private String _id ;

    public void setStageId( String id ) {
        this._id = id ;
    }
    public String getStageId() {
        return this._id ;
    }
}
