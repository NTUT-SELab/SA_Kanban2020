package ddd.kanban.domain.model.Board;



public class Board {

    private String name;
    private String id;

    public Board(String id, String  name){
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
