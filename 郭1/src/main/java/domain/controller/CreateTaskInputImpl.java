package domain.controller;

import domain.usecase.task.create.CreateTaskInput;

public class CreateTaskInputImpl implements CreateTaskInput {
    private String taskName;
    private String cardId;
    public void setTaskName(String name) {
        this.taskName = name;
    }

    public String getTaskName() {
        return this.taskName;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getCardId() {
        return this.cardId;
    }
}
