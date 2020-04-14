package ddd.kanban.domain.entity;

public class Column {

    private String name;
    private String id;

    public Column(String name, String id){
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getColumnId() {
        return id;
    }
}
