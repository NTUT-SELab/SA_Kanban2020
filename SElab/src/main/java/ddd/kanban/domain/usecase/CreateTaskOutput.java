package ddd.kanban.domain.usecase;

public class CreateTaskOutput {

    private String taskId;
    private String taskName;

    public CreateTaskOutput(){

    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }
}
