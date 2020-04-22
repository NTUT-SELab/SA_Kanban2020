package domain.entity;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Card {
    private String _id ;
    private String _name ;
    private Map<String, Task> taskMap;

    public Card(){
        this._id = UUID.randomUUID().toString();
        this.taskMap = new HashMap<String, Task>();
    }
    public void setName( String name) {
        this._name = name ;
    }

    public String getName() {
        return this._name ;
    }

    public String getId() {
        return this._id ;
    }

    public Map<String, Task> getTaskMap(){
        return taskMap;
    }

    public String createTask(String taskName) {
        Task newTask = new Task();
        newTask.setName(taskName);
        taskMap.put(newTask.getId(), newTask);
        System.out.println("size:"+taskMap.size());
        return newTask.getId();
    }
}
