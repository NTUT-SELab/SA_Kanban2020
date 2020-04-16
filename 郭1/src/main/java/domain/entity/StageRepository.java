package domain.entity;

import java.util.HashMap;

public class StageRepository {
    private HashMap<String, Stage> _stageRepository ;
    private static StageRepository _instance;

    private StageRepository(){
        _stageRepository = new HashMap<String, Stage>() ;
    }

    public static StageRepository getInstance() {
        if ( _instance == null )
            _instance = new StageRepository() ;
        return _instance;
    }
    public void add( Stage newStage ){
        this._stageRepository.put(newStage.getId(), newStage) ;
    }

    public Stage get( String id ){
        return this._stageRepository.get(id) ;
    }
}
