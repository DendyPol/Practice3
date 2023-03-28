package lesson_five;

import lombok.Getter;
import lombok.extern.java.Log;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.logging.Level;

@Getter
@Log
public class Car implements Runnable {
  private static int CARS_COUNT = 4;
  private final Race race;
  private final int speed;
  private final String name;
  private final CyclicBarrier barrier;

  public Car(Race race, int speed, CyclicBarrier barrier) {
    this.race = race;
    this.speed = speed;
    CARS_COUNT++;
    this.name = "Участник #" + CARS_COUNT;
    this.barrier = barrier;
  }

  @Override
  public void run() {
    try {
      System.out.printf("%s готовится\n", this.name);
      Thread.sleep(500 + randomSleep());
      System.out.printf("%s готов\n", this.name);
      barrier.await();
      barrier.await();
      for (int i = 0; i < race.getStages().size(); i++) {
        race.getStages().get(i).go(this);
      }
      barrier.await();
      int winner = barrier.await();
      if (winner == 0)
        System.out.printf("%s - Победитель!\n", this.name);
      barrier.await();
    } catch (InterruptedException e) {
      log.log(Level.WARNING, "Ошибка чтения потока" + e.getMessage() + e.getStackTrace());
    } catch (BrokenBarrierException e) {
      log.log(Level.SEVERE, "Ошибка барьера" + e.getMessage() + e.getStackTrace());
    }
  }

  private int randomSleep() {
    return (int) (Math.random() * 800);
  }
}
