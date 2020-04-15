package phd.sa.csie.ntut.edu.tw.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ColumnTest {

  @Test
  public void createColumn() {
    Column column = new Column("develop");
    assertEquals("develop", column.getTitle());
  }

}