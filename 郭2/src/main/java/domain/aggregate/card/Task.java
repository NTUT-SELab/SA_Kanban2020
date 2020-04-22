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
    public String getCardId() {
        return cardId;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getTaskId() {
        return taskId;
    }
}
