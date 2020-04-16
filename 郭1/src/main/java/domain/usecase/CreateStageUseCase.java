package domain.usecase;

import domain.controller.CreateStageInputInterface;
import domain.controller.CreateStageOutputInterface;
import domain.entity.Stage;

public class CreateStageUseCase {
    private CreateStageInputInterface _createStageInputInterface;
    private CreateStageOutputInterface _createStageOutputInterface;

    public void execute( CreateStageInputInterface createStageInputInterface, CreateStageOutputInterface createStageOutputInterface ) {
        this._createStageInputInterface = createStageInputInterface ;
        this._createStageOutputInterface = createStageOutputInterface ;

        Stage newStage = new Stage() ;
        newStage.setName( this._createStageInputInterface.getStageName() );
        this._createStageOutputInterface.setStageId(newStage.getId()) ;
    }


}
