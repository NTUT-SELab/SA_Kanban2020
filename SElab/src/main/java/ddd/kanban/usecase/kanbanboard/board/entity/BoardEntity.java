package ddd.kanban.usecase.kanbanboard.board.entity;

import java.util.ArrayList;
import java.util.List;

public class BoardEntity {
    private final String id;
    private String title;
    private String description;
    private List<String> workflowIds;

    public BoardEntity(String id, String title, String description){
        this.id = id;
        this.title = title;
        this.description = description;
        this.workflowIds = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getWorkflowIds() {
        return workflowIds;
    }

    public void setWorkflowIds(List<String> workflowIds) {
        this.workflowIds = workflowIds;
    }
}
