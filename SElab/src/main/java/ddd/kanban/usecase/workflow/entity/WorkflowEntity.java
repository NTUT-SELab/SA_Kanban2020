package ddd.kanban.usecase.workflow.entity;

import java.util.List;

public class WorkflowEntity {
    private String id;
    private String title;
    private String boardId;
    private List<LaneEntity> laneEntities;

    public WorkflowEntity(String id, String title, String boardId) {
        this.id = id;
        this.title = title;
        this.boardId = boardId;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBoardId() {
        return boardId;
    }

    public List<LaneEntity> getLaneEntities() {
        return laneEntities;
    }

    public void setLaneEntities(List<LaneEntity> laneEntities) {
        this.laneEntities = laneEntities;
    }
}
