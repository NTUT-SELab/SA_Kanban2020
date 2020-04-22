package domain.entity;

import java.util.UUID;

public class Card {
    private String _id ;
    private String _name ;
    public Card(){
        this._id = UUID.randomUUID().toString();
    }
    public void setName( String name) {
        this._name = name ;
    }

    public String getName() {
        return this._name ;
    }

    public String getId() {
        return this._id ;
    }
}
