package domain.controller;

import domain.usecase.task.create.CreateTaskOutput;

public class CreateTaskOutputImpl implements CreateTaskOutput {
    private String taskId;
    public void setTaskId(String id) {
        this.taskId = id;
    }

    public String getTaskId() {
        return this.taskId;
    }
}
