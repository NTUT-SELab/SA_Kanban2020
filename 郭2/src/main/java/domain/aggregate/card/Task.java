package domain.aggregate.card;

import java.util.UUID;

public class Task {
    private String taskId;
    private String cardId;
    private String taskName;

    public Task(String cardId, String taskName) {
        this.cardId = cardId;
        this.taskId = UUID.randomUUID().toString();
        this.taskName = taskName;
    }

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

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getTaskId() {
        return taskId;
    }
}
