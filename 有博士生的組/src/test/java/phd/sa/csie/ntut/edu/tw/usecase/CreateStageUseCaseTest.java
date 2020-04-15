package phd.sa.csie.ntut.edu.tw.usecase;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.UUID;

import org.junit.Test;

public class CreateStageUseCaseTest {

  @Test
  public void createStage() {
    CreateStageUseCase createStageUseCase = new CreateStageUseCase();
    CreateStageUseCaseInput createStageUseCaseInput = new CreateStageUseCaseInput();
    CreateStageUseCaseOutput createStageUseCaseOutput = new CreateStageUseCaseOutput();
    createStageUseCaseInput.setTitle("develop");
    createStageUseCaseInput.setBoardId(UUID.fromString("board id"));
    createStageUseCase.execute(createStageUseCaseInput, createStageUseCaseOutput);
    assertEquals("develop", createStageUseCaseOutput.getTitle());
  }

}