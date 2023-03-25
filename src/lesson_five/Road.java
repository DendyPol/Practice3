package lesson_five;

import lombok.extern.java.Log;

import java.util.Arrays;
import java.util.logging.Level;

@Log
public class Road extends Stage {
  public Road(int length) {
    this.length = length;
    this.description = "Дорога " + length + " метров";
  }

  @Override
  public void go(Car c) {
    try {
      System.out.printf("%s начал этап: %s\n", c.getName(), description);
      Thread.sleep(length / c.getSpeed() * 1000L);
      System.out.printf("%s закончил этап: %s\n", c.getName(), description);
    } catch (InterruptedException e) {
      log.log(Level.WARNING, "Ошибка чтения потока" + e.getMessage() + Arrays.toString(e.getStackTrace()));
    }
  }
}
