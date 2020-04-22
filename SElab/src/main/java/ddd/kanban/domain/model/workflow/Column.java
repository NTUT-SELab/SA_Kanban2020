package ddd.kanban.domain.model.workflow;

public class Column {

    private String name;
    private String id;
    private String workflowId;

    public Column(String name, String id, String workflowId){
        this.workflowId = workflowId;
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}
