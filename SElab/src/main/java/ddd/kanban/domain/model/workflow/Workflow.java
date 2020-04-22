package ddd.kanban.domain.model.workflow;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Predicate;

public class Workflow {
    private List<Column> columns = new ArrayList<Column>();
    private String id;
    private String name;

    public Workflow(String id, String  name){
        this.id = id;
        this.name = name;
    }

    public String createColumn(String columnName, String workflowId){
        Column column = new Column(columnName, UUID.randomUUID().toString(), workflowId);
        columns.add(column);
        return column.getName();
    }

    public Optional<Column> findColumnById(String columnId){
        return columns.stream().filter(judgeColumnId(columnId)).findFirst();
    }

    public static Predicate<Column> judgeColumnId(String columnId){
        return column -> column.getId().equals(columnId);
    }


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }


}
