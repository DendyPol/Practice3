package lesson_one.two_task;

import java.util.ArrayList;
import java.util.Collections;

public class Transformation {
  public static void main(String[] args) {
    var digits = new Integer[]{1, 2, 3, 4, 5};
    var words = new String[]{"A", "B", "C", "D", "E"};
    ArrayList<Integer> testValue = goToArray(digits);
    ArrayList<String> testWords = goToArray(words);
    System.out.printf("Циферки: %s\n", testValue);
    System.out.printf("Буковки: %s\n", testWords);
  }

  public static <T> ArrayList<T> goToArray(T[] array) {
    ArrayList<T> test = new ArrayList<>();
    Collections.addAll(test, array);
    return test;
  }
}
