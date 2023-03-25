package lesson_five;

import lombok.Getter;
import lombok.extern.java.Log;

import java.util.Arrays;
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
      Thread.sleep(500 + (int) (Math.random() * 800));
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
    } catch (InterruptedException | BrokenBarrierException e) {
      log.log(Level.WARNING, "Ошибка чтения потока" + e.getMessage() + Arrays.toString(e.getStackTrace()));
    }
  }
}
