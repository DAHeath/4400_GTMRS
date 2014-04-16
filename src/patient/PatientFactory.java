package patient;

import database.ActiveRecord;
import database.RecordFactory;

public class PatientFactory implements RecordFactory {
  @Override
  public ActiveRecord build(Object... args) {
    return new Patient(
            (String)args[0],
            (String)args[1],
            (String)args[2],
            (String)args[3],
            (String)args[4],
            (String)args[5],
            (String)args[6],
            (String)args[7],
            (String)args[8],
            (Float)args[9],
            (Float)args[10],
            (Integer)args[11],
            (String)args[12]);
  }
}
