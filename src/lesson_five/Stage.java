package lesson_five;

import lombok.Getter;

@Getter
public abstract class Stage {
  protected int length;
  protected String description;
  protected final long longTimeMilli = 1000L;

  public abstract void go(Car c);
}
