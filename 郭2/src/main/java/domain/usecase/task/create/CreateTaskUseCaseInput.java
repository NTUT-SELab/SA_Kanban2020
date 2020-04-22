package domain.usecase.task.create;

public class CreateTaskUseCaseInput {
    private String cardId;
    private String taskName;

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getCardId() {
        return cardId;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskName() {
        return taskName;
    }
}
