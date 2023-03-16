package lesson_one.first_task;

import java.util.Arrays;
import java.util.Collections;

public class ChangeElement {
  public static void main(String[] args) {
    var digits = Arrays.asList(1, 2, 3, 4, 5);
    var words = Arrays.asList("A", "B", "C", "D", "E");
    Collections.swap((words), 1, 3);
    Collections.swap((digits), 1, 3);
    System.out.printf("Циферки %s\n", digits);
    System.out.printf("Буковки %s\n", words);
  }
}
