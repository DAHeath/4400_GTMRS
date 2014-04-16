package utility;

import org.junit.Assert;
import org.junit.Test;

public class StringUtilsTests {

  @Test
  public void testReplaceUnderscores() {
    Assert.assertEquals(
            "Hello World",
            StringUtils.removeUnderscoresAndAddCaps("hello_world"));
  }
}
