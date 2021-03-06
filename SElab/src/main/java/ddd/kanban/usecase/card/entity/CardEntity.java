package ddd.kanban.usecase.card.entity;

import java.util.Date;
import java.util.List;

public class CardEntity {
    private String id;
    private String title;
    private List<TaskEntity> taskEntities;
    private String boardId;
    private String workflowId;
    private String ColumnId;
    private String description;
    private CardTypeEntity cardTypeEntity;
    private List<String> tags;
    private List<String> assignUsers;
    private Date plannedStartDate;
    private Date plannedFinishDate;
    private int priority;

    public CardEntity(String id, String title, String boardId, String workflowId, String ColumnId) {
        this.id = id;
        this.title = title;
        this.boardId = boardId;
        this.workflowId = workflowId;
        this.ColumnId = ColumnId;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public List<TaskEntity> getTaskEntities() {
        return taskEntities;
    }

    public void setTaskEntities(List<TaskEntity> taskEntities) {
        this.taskEntities = taskEntities;
    }

    public String getBoardId() {
        return boardId;
    }

    public String getWorkflowId() {
        return workflowId;
    }

    public String getColumnId() {
        return ColumnId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CardTypeEntity getCardTypeEntity() {
        return cardTypeEntity;
    }

    public void setCardTypeEntity(CardTypeEntity cardTypeEntity) {
        this.cardTypeEntity = cardTypeEntity;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public List<String> getAssignUsers() {
        return assignUsers;
    }

    public void setAssignUsers(List<String> assignUsers) {
        this.assignUsers = assignUsers;
    }

    public Date getPlannedStartDate() {
        return plannedStartDate;
    }

    public void setPlannedStartDate(Date plannedStartDate) {
        this.plannedStartDate = plannedStartDate;
    }

    public Date getPlannedFinishDate() {
        return plannedFinishDate;
    }

    public void setPlannedFinishDate(Date plannedFinishDate) {
        this.plannedFinishDate = plannedFinishDate;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
