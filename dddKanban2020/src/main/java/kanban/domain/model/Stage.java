package kanban.domain.model;

public class Stage {
    private String id;
    private String name;

    public Stage(
            String id,
            String stageName) {

        this.id = id;
        name = stageName;
    }

    public String  getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}
