package lesson_five;

import lombok.Getter;

@Getter
public abstract class Stage {
  protected int length;
  protected String description;

  public abstract void go(Car c);
}
