package patient;

import database.ActiveRecordBase;
import database.Query;

public class PatientAllergy extends ActiveRecordBase {
  private static final String INSERT_QUERY =
          "insert into PatientAllergies values (?,?)";
  public static final String[] attributeNames = {
          "username",
          "allergy"
  };

  private static final String[] attributeTypes = {
          "string",
          "string"
  };

  public PatientAllergy(String[] values) {
    super(attributeTypes, values);
  }

  @Override
  protected Query getBaseQuery() {
    return new Query(INSERT_QUERY);
  }
}
