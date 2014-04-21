package visit;

import database.ActiveRecordBase;
import database.Query;

public class VisitDiagnosis extends ActiveRecordBase {
  private static final String INSERT_QUERY =
          "insert into VisitDiagnoses values (?,?);";

  public static final String[] attributeNames = {
          "visit_id",
          "diagnosis"
  };

  private static final String[] attributeTypes = {
          "int",
          "string"
  };

  public VisitDiagnosis(String[] values) {
    super(attributeTypes, values);
  }

  @Override
  protected Query getBaseQuery() {
    return new Query(INSERT_QUERY);
  }
}
