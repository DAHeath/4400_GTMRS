package user;

import database.ActiveRecordBase;
import database.DbConnection;
import database.Query;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class User extends ActiveRecordBase {
  private static final String INSERT_QUERY =
          "insert into Users values (?, ?);";
  public static final String[] attributeNames = {"username", "password"};
  private static final String[] attributeTypes = {"string", "string"};

  public User(String... values) {
    super(attributeTypes, values);
  }

  public static boolean login(String name, String password) {
    String actualPassword = getActualPassword(name);
    if (password.equals(actualPassword))
      return true;
    else
      return false;
  }

  private static String getActualPassword(String name) {
    String actualPassword = null;
    try {
      Statement statement = DbConnection.connection().createStatement();
      ResultSet rs = statement.executeQuery("select password from Users where username='" + name + "';");
      while (rs.next())
        actualPassword = rs.getString("password");
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return actualPassword;
  }

  @Override
  protected Query getBaseQuery() {
    return new Query(INSERT_QUERY);
  }
}
