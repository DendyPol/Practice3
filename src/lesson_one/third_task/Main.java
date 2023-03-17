package lesson_one.third_task;

public class Main {
  public static void main(String[] args) {
    var firstBoxApple = new Box<>(new Apple(1.0f), new Apple(1.0f), new Apple(1.0f));
    var secondBoxApple = new Box<>(new Apple(1.0f), new Apple(1.0f));
    var firstBoxOrange = new Box<>(new Orange(1.5f), new Orange(1.5f));
    var secondBoxOrange = new Box<>(new Orange(1.5f), new Orange(1.5f), new Orange(1.5f));
    System.out.println(firstBoxApple);
    System.out.println(secondBoxOrange);
  }
}
