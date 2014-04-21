package payment;

import database.ActiveRecordBase;
import database.Query;

public class PaymentInformation extends ActiveRecordBase {
  private static final String INSERT_QUERY =
          "insert into PaymentInformation values (?,?,?,?,?)";

  public static final String[] attributeNames = {
          "card_number",
          "cardholder_name",
          "cvv",
          "date_of_expiry",
          "type"
  };

  private static final String[] attributeTypes = {
          "string",
          "string",
          "int",
          "string",
          "string"
  };

  public PaymentInformation(String[] values) {
    super(attributeTypes, values);
  }

  @Override
  protected Query getBaseQuery() {
    return new Query(INSERT_QUERY);
  }
}
