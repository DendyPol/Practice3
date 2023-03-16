package lesson_one.third_task;

import java.util.ArrayList;
import java.util.Arrays;

public class Box<T extends Fruit> {
  private ArrayList<T> fruits = new ArrayList<>();

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

  public String toString() {
    return "Сведения: \n" +
            "1.Вес коробки='" + getWeight() + '\'' +
            "\n2.Сравнение веса текущей коробки с другой='" + compare(new Box<>()) + '\'' +
            "\nПример: System.out.println(firstBoxApple.compare(firstBoxOrange))" +
            "\n3.Метод <transfer> переносит фрукты определенного типа из текущей коробки в другую коробку='" +
            "\nПример: firstBoxOrange.transfer(secondBoxOrange);";
  }
}
