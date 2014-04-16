package user;

import database.ActiveRecordBase;
import database.Query;

public class User extends ActiveRecordBase {
  private static final String INSERT_QUERY =
          "insert into Users values (?, ?);";
  public static final String[] attributeNames = {"username", "password"};
  public static final String[] attributeTypes = {"string", "string"};

  User(Object... values) {
    super(attributeTypes, values);
  }

  @Override
  protected Query getBaseQuery() {
    return new Query(INSERT_QUERY);
  }
}