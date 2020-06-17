package ddd.kanban.usecase.workflow.mapper;

import ddd.kanban.domain.model.workflow.Column;
import ddd.kanban.usecase.workflow.entity.ColumnEntity;

public class ColumnEntityMapper {

    public static Column mappingColumnFrom(ColumnEntity columnEntity){
        Column column = new Column(columnEntity.getId(), columnEntity.getTitle(), columnEntity.getWorkflowId());
        column.setCommittedCards(columnEntity.getCommittedCards());
        return column;
    }

    public static ColumnEntity mappingColumnEntityFrom(Column column){
        ColumnEntity columnEntity = new ColumnEntity(column.getId(), column.getTitle(), column.getWorkflowId());
        columnEntity.setCommittedCards(column.getCommittedCards());
        return columnEntity;
    }
}
