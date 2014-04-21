package database;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public abstract class ActiveRecordBase implements ActiveRecord {
  private final List<Attribute> attributes = new ArrayList<Attribute>();

  protected ActiveRecordBase(String[] dataTypes, String[] values) {
    for (int i = 0; i < dataTypes.length; i++)
      addAttribute(dataTypes[i], values[i]);
  }

  private void addAttribute(String dataType, String value) {
    attributes.add(new Attribute(dataType, value));
  }

  @Override
  public Query buildQuery() {
    Query query = getBaseQuery();
    for (int i = 0; i < attributes.size(); i++) {
      if (dataTypeIs(i, "string"))
        query.substituteValue(i+1, attributes.get(i).value);
      else if (dataTypeIs(i, "float")) {
        query.substituteValue(i + 1, Float.parseFloat(attributes.get(i).value));      }
      else if (dataTypeIs(i, "int"))
        query.substituteValue(i+1, Integer.parseInt(attributes.get(i).value));
      else if (dataTypeIs(i, "date")) {
        parseDate(query, i);
      }
    }
    return query;
  }

  private void parseDate(Query query, int i) {
    SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
    java.util.Date d = null;
    try {
      System.out.println(attributes.get(i).value);
      d = format.parse(attributes.get(i).value);
    } catch (ParseException e) {
      e.printStackTrace();
    }
    query.substituteValue(i+1, new java.sql.Date(d.getTime()));
  }

  private boolean dataTypeIs(int i, String string) {
    return attributes.get(i).dataType.equals(string);
  }

  protected abstract Query getBaseQuery();

  private class Attribute {
    private final String dataType;
    private final String value;

    public Attribute(String dataType, String value) {
      this.dataType = dataType;
      this.value = value;
    }
  }
}
