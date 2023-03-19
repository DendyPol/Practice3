package lesson_one.third_task;

import lombok.ToString;

@ToString
public class Orange extends Fruit {
  private final String name = "Армянский Апельсин";

  public Orange() {
    super(4.3f);
  }
}
