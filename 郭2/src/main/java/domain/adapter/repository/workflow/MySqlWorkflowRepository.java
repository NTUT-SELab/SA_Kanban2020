package domain.adapter.repository.workflow;

import domain.adapter.database.DbConn;
import domain.aggregate.workflow.Stage;
import domain.aggregate.workflow.Swimlane;
import domain.aggregate.workflow.Workflow;
import domain.usecase.workflow.repository.IWorkflowRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqlWorkflowRepository implements IWorkflowRepository {
    private Connection conn;

    public MySqlWorkflowRepository() {
         conn = DbConn.getConnection();
    }

    public void add(Workflow workflow) {
        String sql = "INSERT INTO kanban.workflow(workflow_id,workflow_name) VALUES (?,?)";
        PreparedStatement ps = null;
        try {
            for(Stage stage : workflow.getStageList()) {
                addStage(stage);
            }
            for(Swimlane swimlane : workflow.getSwimlaneList()){
                addSwimlane(swimlane);
            }
            ps = conn.prepareStatement(sql);
            ps.setString(1,workflow.getWorkflowId());
            ps.setString(2,workflow.getWorkflowName());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public Workflow getWorkflowById(String workflowId) {
        String sql = "SELECT * FROM kanban.workflow WHERE workflow_id = '" + workflowId + "'";
        Workflow workflow = null;
        PreparedStatement ps = null;
        ResultSet rset = null;
        try {
            ps = conn.prepareStatement(sql);
            rset = ps.executeQuery();
            while (rset.next()) {
                workflow = new Workflow(rset.getString("workflow_name"));
                workflow.setWorkflowId(workflowId);
                workflow.setStageList(getStagesByWorkflowId(workflowId));
                workflow.setSwimlaneList(getSwimlanesByWorkflowId(workflowId));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rset != null) {
                try {
                    rset.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return workflow;
    }

    public void save(Workflow workflow) {
        String sql = "Insert Into kanban.workflow Values (? , ?) On Duplicate Key Update workflow_name= ?";
        PreparedStatement ps = null;
        try {

            for(Stage stage : workflow.getStageList()) {
                addStage(stage);
            }
            for(Swimlane swimlane : workflow.getSwimlaneList()) {
                addSwimlane(swimlane);
            }

            ps = conn.prepareStatement(sql);
            ps.setString(1,workflow.getWorkflowId());
            ps.setString(2,workflow.getWorkflowName());
            ps.setString(3,workflow.getWorkflowName());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void addStage(Stage stage) throws SQLException {
        String sql = "Insert Into kanban.stage Values (?, ?, ?) On Duplicate Key Update stage_name= ?";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, stage.getStageId());
            ps.setString(2, stage.getWorkflowId());
            ps.setString(3, stage.getStageName());
            ps.setString(4, stage.getStageName());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private List<Stage> getStagesByWorkflowId(String workflowId) {
        List<Stage> stageList = new ArrayList<Stage>();
        String sql = "SELECT * FROM kanban.stage WHERE workflow_id = '" + workflowId + "'";
        PreparedStatement ps = null;
        ResultSet rset = null;
        try {
            ps = conn.prepareStatement(sql);
            rset = ps.executeQuery();
            while (rset.next()) {
                Stage stage = new Stage(workflowId, rset.getString("stage_name"));
                stage.setStageId(rset.getString("stage_id"));
                stageList.add(stage);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rset != null) {
                try {
                    rset.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return stageList;
    }

    private void addSwimlane(Swimlane swimlane) throws SQLException {
        String sql = "Insert Into kanban.swimlane Values (?, ?, ?) On Duplicate Key Update swimlane_name= ?";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, swimlane.getSwimlaneId());
            ps.setString(2, swimlane.getWorkflowId());
            ps.setString(3, swimlane.getSwimlaneName());
            ps.setString(4, swimlane.getSwimlaneName());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private List<Swimlane> getSwimlanesByWorkflowId(String workflowId) {
        List<Swimlane> swimlaneList = new ArrayList<Swimlane>();
        String sql = "SELECT * FROM kanban.swimlane WHERE workflow_id = '" + workflowId + "'";
        PreparedStatement ps = null;
        ResultSet rset = null;
        try {
            ps = conn.prepareStatement(sql);
            rset = ps.executeQuery();
            while (rset.next()) {
                Swimlane swimlane = new Swimlane(workflowId, rset.getString("swimlane_name"));
                swimlane.setSwimlaneId(rset.getString("swimlane_id"));
                swimlaneList.add(swimlane);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rset != null) {
                try {
                    rset.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return swimlaneList;
    }
}
