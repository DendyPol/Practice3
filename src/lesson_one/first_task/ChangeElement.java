package lesson_one.first_task;

import java.util.Arrays;

public class ChangeElement {
  public static void main(String[] args) {
    var digits = new Integer[]{1, 2, 3, 4, 5};
    var words = new String[]{"A", "B", "C", "D", "E"};
    swap(digits, 1, 3);
    swap(words, 1, 3);
    System.out.printf("Циферки %s\n", Arrays.toString(digits));
    System.out.printf("Буковки %s\n", Arrays.toString(words));
  }

  public static <T> void swap(T[] array, int indexOne, int indexTwo) {
    T test = array[indexOne];
    array[indexOne] = array[indexTwo];
    array[indexTwo] = test;
  }
}
