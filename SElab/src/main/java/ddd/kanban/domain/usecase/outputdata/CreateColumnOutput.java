package ddd.kanban.domain.usecase.outputdata;

public class CreateColumnOutput {

    private String columnId;
    private String columnName;

    public CreateColumnOutput(){

    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public void setColumnId(String columnId) {
        this.columnId = columnId;
    }

    public String getColumnId(){
        return this.columnId;
    }
}
