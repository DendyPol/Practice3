package lesson_one.third_task;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class Fruit {
  private float weight;

  public float totalWeight() {
    return weight;
  }
}
