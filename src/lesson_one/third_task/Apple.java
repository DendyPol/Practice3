package lesson_one.third_task;

import lombok.ToString;

@ToString
public class Apple extends Fruit {
  private final String name = "Красное яблоко";

  public Apple() {
    super(2.3f);
  }
}
