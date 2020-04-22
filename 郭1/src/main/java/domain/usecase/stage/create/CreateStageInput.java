package domain.usecase.stage.create;

public interface CreateStageInput {
    public void setWorkflowId(String id);
    public void setStageName( String name ) ;
    public String getStageName() ;
    public String getWorkflowId();
}
