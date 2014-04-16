package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
  private static Connection instance;
  private static final String URL = "jdbc:mysql://localhost:3306/";
  private static final String DB_NAME = "gtmrs";
  private static final String DRIVER = "com.mysql.jdbc.Driver";
  private static final String USERNAME = "root";
  private static final String PASSWORD = "password";

  public static Connection connection() {
    if (instance == null)
      createConnection();
    return instance;
  }

  private static void createConnection() {
    try {
      Class.forName(DRIVER).newInstance();
      instance = DriverManager.getConnection(URL + DB_NAME, USERNAME, PASSWORD);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private static final String QUERY_BASE = "./res/query/";

  public static void main(String[] args) {
    buildTables();
  }

  private static void buildTables() {
    Query.fromFile(QUERY_BASE + "user/create_user.sql").execute();
    Query.fromFile(QUERY_BASE + "patient/create_patient.sql").execute();
    Query.fromFile(QUERY_BASE + "patient/create_patient_allergy.sql").execute();
    Query.fromFile(QUERY_BASE + "doctor/create_doctor.sql").execute();
  }
}
