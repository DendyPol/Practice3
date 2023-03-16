package lesson_one.third_task;

public class Main {
  public static void main(String[] args) {
    var firstBoxApple = new Box<Apple>();
    var secondBoxApple = new Box<Apple>();
    var firstBoxOrange = new Box<Orange>();
    var secondBoxOrange = new Box<Orange>();
    firstBoxApple.add(new Apple(1.0f));
    secondBoxApple.add(new Apple(1.0f));
    firstBoxOrange.add(new Orange(1.5f));
    secondBoxOrange.add(new Orange(1.5f));
    System.out.println(firstBoxApple.compare(firstBoxOrange));
    System.out.println(firstBoxOrange.compare(secondBoxOrange));
    firstBoxOrange.transfer(secondBoxOrange);
    System.out.println(firstBoxOrange.getWeight());
    System.out.println(secondBoxOrange.getWeight());
  }
}
