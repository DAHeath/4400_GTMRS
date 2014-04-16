package doctor;

import database.ActiveRecordBase;
import database.Query;

public class Doctor extends ActiveRecordBase {
  private static final String INSERT_QUERY =
          "insert into Doctors values (?,?,?,?,?,?,?,?,?)";
  public static final String[] attributeNames = {
          "username",
          "license_number",
          "first_name",
          "last_name",
          "date_of_birth",
          "work_phone",
          "home_address",
          "specialty",
          "room_number"
  };

  public static final String[] attributeTypes = {
          "string",
          "string",
          "string",
          "string",
          "string",
          "string",
          "string",
          "string",
          "string"
  };

  public Doctor(String[] values) {
    super(attributeTypes, values);
  }

  @Override
  protected Query getBaseQuery() {
    return new Query(INSERT_QUERY);
  }
}
