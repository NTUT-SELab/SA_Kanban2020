package domain.adapter;

import domain.entity.Stage;
import domain.entity.Swimlane;
import domain.entity.Workflow;
import domain.usecase.workflow.WorkflowRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;

public class WorkflowRepositoryImpl implements WorkflowRepository {
    private HashMap<String, Workflow> _workflowRepository ;
    private Connection conn;

    public WorkflowRepositoryImpl(){
        _workflowRepository = new HashMap<String, Workflow>() ;
    }

    public Workflow getWorkFlowById(String id){
        return this._workflowRepository.get(id) ;
    }

    public void save(Workflow workflow) {

        try {
            this._workflowRepository.put(workflow.getId(), workflow);
            this.conn = DatabaseImpl.getConnection();
            add(workflow.getId(), workflow.getName());
            conn.close();
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }


    public void add(String workflowId, String workflowName){
        //save card
        String sql = "INSERT INTO kanban.workflow(id, name) VALUES (?,?)";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,workflowId);
            ps.setString(2,workflowName);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        PreparedStatement ps1 = null;
        sql = "INSERT INTO kanban.stage(id, name) VALUES (?,?)";
        try {
            System.out.println(_workflowRepository.get(workflowId).getStageMap().values().size());
            for(Stage stage : _workflowRepository.get(workflowId).getStageMap().values() ){
                System.out.println(stage.getName() + stage.getId());
                ps1 = conn.prepareStatement(sql);
                ps1.setString(1,stage.getId());
                ps1.setString(2,stage.getName());
                ps1.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (ps1 != null) {
                try {
                    ps1.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        PreparedStatement ps2 = null;
        sql = "INSERT INTO kanban.swimlane(id, name) VALUES (?,?)";
        try {
            System.out.println(_workflowRepository.get(workflowId).getStageMap().values().size());
            for(Stage stage : _workflowRepository.get(workflowId).getStageMap().values() ){
                for(Swimlane swimlane : stage.getSwimlaneMap().values()){
                    ps2 = conn.prepareStatement(sql);
                    ps2.setString(1,swimlane.getId());
                    ps2.setString(2,swimlane.getName());
                    ps2.executeUpdate();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (ps2 != null) {
                try {
                    ps2.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
