package domain.entity;

import java.util.HashMap;

public class WorkflowRepository {
    private HashMap<String, Workflow> _workflowRepository ;
    private static WorkflowRepository _instance;

    private WorkflowRepository(){
        _workflowRepository = new HashMap<String, Workflow>() ;
    }

    public static WorkflowRepository getInstance() {
        if ( _instance == null )
            _instance = new WorkflowRepository() ;
        return _instance;
    }
    public void add( Workflow newWorkflow ){
        this._workflowRepository.put(newWorkflow.getId(), newWorkflow) ;
    }

    public Workflow get( String id ){
        return this._workflowRepository.get(id) ;
    }
}
