package lesson_five;

import lombok.extern.java.Log;

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
      Thread.sleep(timeStage(c));
      System.out.printf("%s закончил этап: %s\n", c.getName(), description);
    } catch (InterruptedException e) {
      log.log(Level.WARNING, "Ошибка чтения потока" + e.getMessage() + e.getStackTrace());
    }
  }

  private long timeStage(Car c) {
    return (long) (length / c.getSpeed() * LONG_TIME_MILLI);
  }
}
