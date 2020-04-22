package ddd.kanban.domain.usecase.inputdata;

public class CreateColumnInput {
    private String columnName;
    private String workflowId;

    public CreateColumnInput(String columnName, String workflowId){
        this.columnName = columnName;
        this.workflowId = workflowId;
    }

    public String getColumnName() {
        return columnName;
    }

    public String getWorkflowId() {
        return workflowId;
    }


}
