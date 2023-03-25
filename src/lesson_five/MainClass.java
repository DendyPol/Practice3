package lesson_five;

import lombok.extern.java.Log;

import java.util.Arrays;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.logging.Level;

@Log
public class MainClass {
  public static final int CARS_COUNT = 4;

  public static void main(String[] args) {
    System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
    CyclicBarrier MyBarrier = new CyclicBarrier(CARS_COUNT + 1);
    var race = new Race(new Road(60), new Tunnel(), new Road(40));
    var cars = new Car[CARS_COUNT];
    for (int i = 0; i < cars.length; i++) {
      cars[i] = new Car(race, 20 + (int) (Math.random() * 10), MyBarrier);
    }
    for (Car car : cars) {
      new Thread(car).start();
    }
    try {
      MyBarrier.await();
      System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
      MyBarrier.await();
      MyBarrier.await();
      MyBarrier.await();
      MyBarrier.await();
    } catch (InterruptedException | BrokenBarrierException e) {
      log.log(Level.WARNING, "Ошибка чтения потока" + e.getMessage() + Arrays.toString(e.getStackTrace()));
    }
    System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
  }
}
