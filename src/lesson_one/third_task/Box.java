package lesson_one.third_task;

import java.util.ArrayList;
import java.util.Arrays;

public class Box<T extends Fruit> {
  private final ArrayList<T> fruits;

  @Override
  public String toString() {
    return "Коробка фруктов{" +
            "\nКоличество фруктов=" + fruits + "\nОбщий вес фруктов=" + getWeight() +
            '}';
  }

  public Box(T... fruit) {
    this.fruits = new ArrayList<T>(Arrays.asList(fruit));
  }

  public void add(T fruit) {
    fruits.add(fruit);
  }

  public float getWeight() {
    float weight = 0.0f;
    for (T fruit : fruits) {
      weight += fruit.getWeight();
    }
    return weight;
  }

  public boolean compare(Box<?> box) {
    return getWeight() == box.getWeight();
  }

  public void transfer(Box<T> box) {
    for (T fruit : fruits) {
      box.add(fruit);
    }
    fruits.clear();
  }
}
