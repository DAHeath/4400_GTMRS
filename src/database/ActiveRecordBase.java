package database;

import java.util.ArrayList;
import java.util.List;

public abstract class ActiveRecordBase implements ActiveRecord {
  private List<Attribute> attributes = new ArrayList<Attribute>();

  public ActiveRecordBase(String[] dataTypes, String[] values) {
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
    }
    return query;
  }

  private boolean dataTypeIs(int i, String string) {
    return attributes.get(i).dataType.equals(string);
  }

  protected abstract Query getBaseQuery();

  private class Attribute {
    private String dataType;
    private String value;

    public Attribute(String dataType, String value) {
      this.dataType = dataType;
      this.value = value;
    }
  }
}
