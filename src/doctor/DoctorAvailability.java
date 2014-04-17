package doctor;

import database.ActiveRecordBase;
import database.Query;

public class DoctorAvailability extends ActiveRecordBase {
  private static final String INSERT_QUERY =
          "insert into DoctorAvailabilities values (?,?,?,?);";

  public static final String[] attributeNames = {
          "doctor_username",
          "start_time",
          "end_time",
          "day"
  };

  private static final String[] attributeTypes = {
          "string",
          "string",
          "string",
          "string"
  };

  public DoctorAvailability(String[] values) {
    super(attributeTypes, values);
  }

  @Override
  protected Query getBaseQuery() {
    return new Query(INSERT_QUERY);
  }
}
