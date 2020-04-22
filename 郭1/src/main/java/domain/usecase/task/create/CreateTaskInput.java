package domain.usecase.task.create;

public interface CreateTaskInput {
    public void setTaskName(String name ) ;
    public String getTaskName() ;

    void setCardId(String cardId);
    public String getCardId();
}
