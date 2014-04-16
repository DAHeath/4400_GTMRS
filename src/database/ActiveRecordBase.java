package database;

import java.util.ArrayList;
import java.util.List;

public abstract class ActiveRecordBase implements ActiveRecord {
  private List<Attribute> attributes = new ArrayList<Attribute>();

  public ActiveRecordBase(String[] dataTypes, Object[] values) {
    for (int i = 0; i < dataTypes.length; i++)
      addAttribute(dataTypes[i], values[i]);
  }

  private void addAttribute(String dataType, Object value) {
    attributes.add(new Attribute(dataType, value));
  }

  @Override
  public Query buildQuery() {
    Query query = getBaseQuery();
    for (int i = 0; i < attributes.size(); i++) {
      if (dataTypeIs(i, "string"))
        query.substituteValue(i+1, (String)attributes.get(i).value);
      else if (dataTypeIs(i, "float"))
        query.substituteValue(i+1, (Float)attributes.get(i).value);
      else if (dataTypeIs(i, "int"))
        query.substituteValue(i+1, (Integer)attributes.get(i).value);
    }
    return query;
  }

  private boolean dataTypeIs(int i, String string) {
    return attributes.get(i).dataType.equals(string);
  }

  protected abstract Query getBaseQuery();

  private class Attribute {
    private String dataType;
    private Object value;

    public Attribute(String dataType, Object value) {
      this.dataType = dataType;
      this.value = value;
    }
  }
}
