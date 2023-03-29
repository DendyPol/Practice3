package lesson_five;

import lombok.Getter;

@Getter
public abstract class Stage {
  protected int length;
  protected String description;
  protected static final int LONG_TIME_MILLI = 1000;

  public abstract void go(Car c);
}
