package surgery;

import database.ActiveRecordBase;
import database.Query;

public class PreoperativeMedication extends ActiveRecordBase {
  private static final String INSERT_QUERY =
          "insert into PreoperativeMedications values (?,?);";

  public static final String[] attributeNames = {
          "cpt_code",
          "preoperative_medication"
  };

  private static final String[] attributeTypes = {
          "string",
          "string"
  };

  public PreoperativeMedication(String[] values) {
    super(attributeTypes, values);
  }

  @Override
  protected Query getBaseQuery() {
    return new Query(INSERT_QUERY);
  }
}
