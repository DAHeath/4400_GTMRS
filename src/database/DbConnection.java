package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DbConnection {
  private static Connection instance;
  private static final String URL = "jdbc:mysql://localhost:3306/";
  //private static final String URL = "jdbc:mysql://academic-mysql.cc.gatech.edu/";
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
    Properties props = new Properties();
    props.put("user", "root");
    props.put("password", "password");
    props.put("useUnicode", "true");
    props.put("useServerPrepStmts", "false");
    props.put("characterEncoding", "UTF-8");
    try {
      Class.forName(DRIVER).newInstance();
      instance = DriverManager.getConnection(URL + DB_NAME, props);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private static final String QUERY_BASE = "./res/query/";

  public static void main(String[] args) {
    buildTables();
  }

  private static void buildTables() {
    Query.fromFile(QUERY_BASE + "payment/create_payment_information.sql").execute();
    Query.fromFile(QUERY_BASE + "user/create_user.sql").execute();
    Query.fromFile(QUERY_BASE + "patient/create_patient.sql").execute();
    Query.fromFile(QUERY_BASE + "patient/create_patient_allergy.sql").execute();
    Query.fromFile(QUERY_BASE + "doctor/create_doctor.sql").execute();
    Query.fromFile(QUERY_BASE + "doctor/create_doctor_availability.sql").execute();
    Query.fromFile(QUERY_BASE + "doctor/create_doctor_ratings.sql").execute();
    Query.fromFile(QUERY_BASE + "surgery/create_surgery.sql").execute();
    Query.fromFile(QUERY_BASE + "surgery/create_preoperative_medication.sql").execute();
    Query.fromFile(QUERY_BASE + "visit/create_visit.sql").execute();
    Query.fromFile(QUERY_BASE + "visit/create_visit_diagnosis.sql").execute();
  }
}
