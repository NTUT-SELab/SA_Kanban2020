package domain.usecase;

import domain.controller.CreateStageInputInterface;
import domain.controller.CreateStageOutputInterface;
import domain.entity.CardRepository;
import domain.entity.Stage;
import domain.entity.StageRepository;

public class CreateStageUseCase {
    private CreateStageInputInterface _createStageInput;
    private CreateStageOutputInterface _createStageOutput;

    public void execute( CreateStageInputInterface createStageInputInterface, CreateStageOutputInterface createStageOutputInterface ) {
        this._createStageInput = createStageInputInterface ;
        this._createStageOutput = createStageOutputInterface ;

        Stage newStage = new Stage() ;
        newStage.setName( this._createStageInput.getStageName() );

        StageRepository stageRepository = StageRepository.getInstance() ;
        stageRepository.add(newStage) ;

        this._createStageOutput.setStageId(newStage.getId()) ;
    }


}
