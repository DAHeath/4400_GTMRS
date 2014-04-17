package user;

import database.ActiveRecordBase;
import database.Query;

public class User extends ActiveRecordBase {
  private static final String INSERT_QUERY =
          "insert into Users values (?, ?);";
  public static final String[] attributeNames = {"username", "password"};
  private static final String[] attributeTypes = {"string", "string"};

  public User(String... values) {
    super(attributeTypes, values);
  }

  @Override
  protected Query getBaseQuery() {
    return new Query(INSERT_QUERY);
  }
}
