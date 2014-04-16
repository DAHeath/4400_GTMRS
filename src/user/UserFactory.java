package user;

import database.ActiveRecord;
import database.RecordFactory;

public class UserFactory implements RecordFactory {
  private static final int MAX_USERNAME_LENGTH = 30;
  private static final int MIN_USERNAME_LENGTH = 6;
  private static final int MAX_PASSWORD_LENGTH = 41;
  private static final int MIN_PASSWORD_LENGTH = 8;

  private String username;

  public ActiveRecord build(Object... args) {
    username = (String)args[0];
    String password = (String)args[1];

    validateUsername(username);
    validatePassword(password);
    return new User(args);
  }

  private void validateUsername(String username) {
    if (username.length() > MAX_USERNAME_LENGTH)
      throw new MaxLengthException("Username");
    else if (username.length() < MIN_USERNAME_LENGTH)
      throw new MinLengthException("Username");
  }

  private void validatePassword(String password) {
    if (password.length() > MAX_PASSWORD_LENGTH)
      throw new MaxLengthException("Password");
    else if (password.length() < MIN_PASSWORD_LENGTH)
      throw new MinLengthException("Password");
  }
}

