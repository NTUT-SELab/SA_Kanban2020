package ddd.kanban.domain.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class Workflow {
    private final List<Column> columns = new ArrayList<Column>();

    public Workflow(){

    }

    public void createColumn(String columnName){
        columns.add(new Column("asdf", "001"));
    }

    public Optional<Column> findColumnById(String columnId){
        return columns.stream()
                      .filter(judgeColumnId(columnId))
                      .findFirst();
    }

    public static Predicate<Column> judgeColumnId(String columnId){
        return column -> column.getColumnId().equals(columnId);
    }


}
