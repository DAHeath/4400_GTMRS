package doctor;

import database.ActiveRecordBase;
import database.Query;

public class DoctorRating extends ActiveRecordBase {
  private static final String INSERT_QUERY =
          "insert into DoctorRatings values (?,?,?);";

  public static final String[] attributeNames = {
          "doctor_username",
          "patient_username",
          "rating"
  };

  private static String[] attributeTypes = {
    "string",
    "string",
    "int"
  };

  public DoctorRating(String[] values) {
    super(attributeTypes, values);
  }

  @Override
  protected Query getBaseQuery() {
    return new Query(INSERT_QUERY);
  }
}
