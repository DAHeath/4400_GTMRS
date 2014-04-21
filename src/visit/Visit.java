package visit;

import database.ActiveRecordBase;
import database.Query;

public class Visit extends ActiveRecordBase {
  private static final String INSERT_QUERY =
          "insert into Visits values (?, ?, ?, ?, ?, ?, ?);";

  public static final String[] attributeNames = {
          "visit_id",
          "doctor_username",
          "patient_username",
          "date_of_visit",
          "diastolic_pressure",
          "systolic_pressure",
          "billing_amount"
  };

  private static final String[] attributeTypes = {
          "int",
          "string",
          "string",
          "string",
          "string",
          "string",
          "float"
  };

  public Visit(String[] values) {
    super(attributeTypes, values);
  }

  @Override
  protected Query getBaseQuery() {
    return new Query(INSERT_QUERY);
  }
}