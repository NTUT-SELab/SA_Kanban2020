package domain.controller;

public class CreateStageInputImpl implements CreateStageInputInterface {
    private String _name ;

    public void setStageName(String name) {
        this._name = name;
    }

    public String getStageName() {
        return this._name ;
    }
}
