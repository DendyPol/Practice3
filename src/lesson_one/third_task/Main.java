package lesson_one.third_task;

public class Main {
  public static void main(String[] args) {
    var BoxApple = new Box<Apple>();
    var BoxOrange = new Box<Orange>();
    for (int i = 0; i < 4; i++) {
      BoxApple.add(new Apple(2.4f));
    }
    for (int i = 0; i < 4; i++) {
      BoxOrange.add(new Orange(4.1f));
    }
    System.out.println(BoxApple);
    System.out.println(BoxOrange);
  }
}
