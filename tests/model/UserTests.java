package model;

import database.ActiveRecord;
import database.RecordFactory;
import org.junit.Before;
import org.junit.Test;
import user.MaxLengthException;
import user.MinLengthException;
import user.UserFactory;

public class UserTests {
  private RecordFactory factory;

  @Before
  public void setUp() {
    factory = new UserFactory();
  }

  @Test (expected = MinLengthException.class)
  public void testUsernameTooShort() {
    userWithLengths(5, 8);
  }

  @Test (expected = MaxLengthException.class)
  public void testUsernameTooLong() {
    userWithLengths(31, 8);
  }

  @Test (expected = MinLengthException.class)
  public void testPasswordTooShort() {
    userWithLengths(6, 7);
  }

  @Test (expected = MaxLengthException.class)
  public void testPasswordTooLong() {
    userWithLengths(6, 42);
  }

  @Test
  public void testCorrectParameterLengths() {
    userWithLengths(6, 8);
  }

  private void userWithLengths(int i, int i1) {
    ActiveRecord user = factory.build(repeatA(i), repeatA(i1));
  }

  private String repeatA(int i) {
    return new String(new char[i]).replace("\0", "a");
  }
}
