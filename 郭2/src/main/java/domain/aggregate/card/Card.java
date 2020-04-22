package domain.aggregate.card;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Card {
    private String laneId;
    private String cardId;
    private String cardName;
    private List<Task> taskList;

    public Card(String cardName){
        taskList = new ArrayList<Task>();
        this.cardName = cardName;
        this.cardId = UUID.randomUUID().toString();
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getCardName() {
        return cardName;
    }

    public Task createTask(String cardId, String taskName) {
        return new Task(cardId, taskName);
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public void addTaskId(Task task) {
        taskList.add(task);
    }
}
