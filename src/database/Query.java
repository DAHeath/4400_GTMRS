package database;

import utility.FileReader;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import static database.DbConnection.connection;

public class Query {
  private final String text;
  private final PreparedStatement statement;

  public static Query fromFile(String filename) {
    return new Query(FileReader.readFile(filename));
  }

  public Query(String text) {
    this.text = text;
    statement = getStatement();
  }

  private PreparedStatement getStatement() {
    PreparedStatement s = null;
    try {
      s = connection().prepareStatement(text);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return s;
  }

  public ResultSet getResults() {
    ResultSet res = null;
    try {
      statement.execute();
      res = statement.getResultSet();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return res;
  }

  public void execute() {
    try {
      statement.execute();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void substituteValue(int index, String value) {
    try {
      statement.setString(index, value);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void substituteValue(int index, Date date) {
    try {
      statement.setDate(index, (java.sql.Date) date);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void substituteValue(int index, float f) {
    try {
      statement.setFloat(index, f);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
