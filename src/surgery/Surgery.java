package surgery;

import database.ActiveRecordBase;
import database.Query;

public class Surgery extends ActiveRecordBase {
  private static final String INSERT_QUERY =
          "insert into Surgeries values (?,?,?);";

  public static final String[] attributeNames = {
          "cpt_code",
          "surgery_type",
          "cost_of_surgery"
  };

  private static final String[] attributeTypes = {
          "string",
          "string",
          "int"
  };

  public Surgery(String[] values) {
    super(attributeTypes, values);
  }

  @Override
  protected Query getBaseQuery() {
    return new Query(INSERT_QUERY);
  }

}
