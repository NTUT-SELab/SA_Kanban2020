package ddd.kanban.domain.model.workflow;

import ddd.kanban.domain.model.AggregateRoot;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;

public class Workflow extends AggregateRoot {

    private List<Column> columns;
    private String id;
    private String title;
    private String boardId;

    public Workflow(String id, String title,String boardId){
        this.id = id;
        this.title = title;
        this.boardId = boardId;
        columns = new ArrayList<Column>();
    }

    public String createColumn(String columnName, String workflowId){
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
    public String getBoardId(){return boardId;}

}
