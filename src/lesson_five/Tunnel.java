package lesson_five;

import lombok.extern.java.Log;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;

import static lesson_five.MainClass.MAX_ENTRY_TUNNEL;

@Log
public class Tunnel extends Stage {
  Semaphore checkPoint = new Semaphore(MAX_ENTRY_TUNNEL);

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
        Thread.sleep(timeStage(c));
      } catch (InterruptedException e) {
        log.log(Level.WARNING, "Ошибка чтения потока" + e.getMessage() + e.getStackTrace());
      } finally {
        System.out.printf("%s закончил этап: %s\n", c.getName(), description);
        checkPoint.release();
      }
    } catch (Exception e) {
      log.log(Level.WARNING, "Ошибка чтения потока" + e.getMessage() + e.getStackTrace());
    }
  }

  private long timeStage(Car c) {
    return (long) (length / c.getSpeed() * LONG_TIME_MILLI);
  }
}
