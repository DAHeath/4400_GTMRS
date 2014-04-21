package patient;

import database.ActiveRecordBase;
import database.Query;

public class Patient extends ActiveRecordBase {
  private static final String INSERT_QUERY =
          "insert into Patients values (?,?,?,?,?,?,?,?,?,?,?,?,?);";
  public static final String[] attributeNames = {
          "username",
          "name",
          "date_of_birth",
          "gender",
          "address",
          "work_phone",
          "home_phone",
          "emergency_contact_name",
          "emergency_contact_phone",
          "weight",
          "height",
          "annual_income",
          "card_number"
  };

  private static final String[] attributeTypes = {
          "string",
          "string",
          "date",
          "string",
          "string",
          "string",
          "string",
          "string",
          "string",
          "float",
          "float",
          "int",
          "string"
  };

  public Patient(String... values) {
    super(attributeTypes, values);
  }

  @Override
  public Query getBaseQuery() {
    return new Query(INSERT_QUERY);
  }
}
