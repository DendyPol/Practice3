package lesson_one.third_task;

import lombok.ToString;

@ToString
public class Orange extends Fruit {
  private final String name = "Армянский Апельсин";

  public Orange(float weight) {
    super(weight);
  }
}
