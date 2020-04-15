package ddd.kanban.domain.usecase;

public class CreateTaskInput {
    private String cardId;
    private String taskName;

    public CreateTaskInput(String taskId, String taskName){
        this.cardId = taskId;
        this.taskName = taskName;
    }

    public String getCardId() {
        return cardId;
    }

    public String getTaskName() {
        return taskName;
    }

}
