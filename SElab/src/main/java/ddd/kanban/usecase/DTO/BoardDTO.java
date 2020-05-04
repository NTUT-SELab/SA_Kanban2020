package ddd.kanban.usecase.DTO;

import java.util.ArrayList;
import java.util.List;

public class BoardDTO {
    private final String id;
    private String name;
    private String description;
    private List<String> workflowIds;

    public BoardDTO(String id, String name, String description){
        this.id = id;
        this.name = name;
        this.description = description;
        this.workflowIds = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
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
