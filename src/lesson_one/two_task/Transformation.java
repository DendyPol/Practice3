package lesson_one.two_task;

import java.util.Arrays;

public class Transformation {
  public static void main(String[] args) {
    var digits = new Integer[]{1, 2, 3, 4, 5};
    var words = new String[]{"A", "B", "C", "D", "E"};
    var testDigits = Arrays.asList(digits);
    var testWords = Arrays.asList(words);
    System.out.printf("Циферки: %s\n", testDigits);
    System.out.printf("Буковки: %s\n", testWords);
  }
}
