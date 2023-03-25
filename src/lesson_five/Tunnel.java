package lesson_five;

import lombok.extern.java.Log;

import java.util.Arrays;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;

@Log
public class Tunnel extends Stage {
  Semaphore checkPoint = new Semaphore(2);

  public Tunnel() {
    this.length = 80;
    this.description = "Тоннель " + length + " метров";
  }

  @Override
  public void go(Car c) {
    try {
      try {
        System.out.printf("%s готовится к этапу(ждет): %s\n", c.getName(), description);
        checkPoint.acquire();
        System.out.printf("%s начал этап: %s\n", c.getName(), description);
        Thread.sleep(length / c.getSpeed() * 1000L);
      } catch (InterruptedException e) {
        log.log(Level.WARNING, "Ошибка чтения потока" + e.getMessage() + Arrays.toString(e.getStackTrace()));
      } finally {
        System.out.printf("%s закончил этап: %s\n", c.getName(), description);
        checkPoint.release();
      }
    } catch (Exception e) {
      log.log(Level.WARNING, "Ошибка чтения потока" + e.getMessage() + Arrays.toString(e.getStackTrace()));
    }
  }
}
