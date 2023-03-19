package lesson_one.third_task;

import java.util.ArrayList;

public class Box<T extends Fruit> {
  private final ArrayList<T> fruits;
  private float weight;

  @Override
  public String toString() {
    return "Коробка фруктов{" +
            "\nКоличество фруктов=" + fruits +
            "\nОбщий вес фруктов в коробке=" + weight +
            '}';
  }

  public Box() {
    this.fruits = new ArrayList<>();
  }

  public void add(T fruit) {
    fruits.add(fruit);
    weight += fruit.totalWeight();
  }

  public void transfer(Box<T> box) {
    for (T fruit : fruits) {
      box.add(fruit);
    }
    weight = 0;
    fruits.clear();
  }
}
