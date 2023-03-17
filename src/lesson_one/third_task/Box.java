package lesson_one.third_task;

import java.util.ArrayList;
import java.util.Arrays;

public class Box<T extends Fruit> {
  private final ArrayList<T> fruits;
  private final float weight;

  @Override
  public String toString() {
    return "Коробка фруктов{" +
            "\nКоличество фруктов=" + fruits + "\nВес одного фрукта=" + weight +
            '}';
  }

  public Box(float weight, T... fruit) {
    this.weight = weight;
    this.fruits = new ArrayList<T>(Arrays.asList(fruit));
  }

  public void add(T fruit) {
    fruits.add(fruit);
  }

  public float getWeight() {
    float totalWeight = this.weight;
    for (T fruit : fruits) {
      totalWeight += fruit.getWeight();
    }
    return totalWeight;
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
