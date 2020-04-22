package ddd.kanban.domain.usecase.inputdata;

public class CreateTaskInput {
    private String cardId;
    private String taskName;

    public CreateTaskInput(String cardId, String taskName){
        this.cardId = cardId;
        this.taskName = taskName;
    }

    public String getCardId() {
        return cardId;
    }

    public String getTaskName() {
        return taskName;
    }



}
