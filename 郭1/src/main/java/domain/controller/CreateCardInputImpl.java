package domain.controller;

public class CreateCardInputImpl implements CreateCardInputInterface {
    private String _name ;
    public void setCardName(String name) {
        this._name = name ;
    }

    public String getCardName() {
        return this._name ;
    }
}
