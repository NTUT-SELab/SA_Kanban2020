package ddd.kanban.domain.model.workflow;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;

public class Workflow {
    private List<Column> columns = new ArrayList<Column>();
    private String id;
    private String title;

    public Workflow(String id, String title){
        this.id = id;
        this.title = title;
    }

    public String createColumn(String columnName, String workflowId){
//         這邊要呼叫repository來New嗎?
        Column column = new Column(columnName, UUID.randomUUID().toString(), workflowId);
        columns.add(column);
        return column.getTitle();
    }

    public Column findColumnById(String columnId){
        return columns.stream()
                .filter(judgeColumnId(columnId))
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }

    public static Predicate<Column> judgeColumnId(String columnId){
        return column -> column.getId().equals(columnId);
    }


    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }


}
