package database;

public interface RecordFactory {
  public ActiveRecord build(Object... args);
}
