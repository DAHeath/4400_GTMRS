package utility;

import org.junit.Test;
import user.User;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LoginTests {

  @Test
  public void testLoginSuccess() {
    assertTrue(User.login("David", "Heath"));
  }

  @Test
  public void testLoginFailure() {
    assertFalse(User.login("David", "WRONG"));
  }
}
