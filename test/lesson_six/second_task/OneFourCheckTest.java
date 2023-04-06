package lesson_six.second_task;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

public class OneFourCheckTest {
  private static OneFourCheck check;

  @BeforeClass
  public static void init() {
    System.out.println("Testing One Four Check");
    check = new OneFourCheck();
  }

  @Test
  public void checkOneFour() {
    Assert.assertTrue(check.returnCheck(List.of(1, 2, 3, 4, 5)));
  }

  @Test
  public void onlyOne() {
    Assert.assertTrue(check.returnCheck(List.of(1, 2, 3, 5, 6)));
  }

  @Test
  public void onlyFour() {
    Assert.assertTrue(check.returnCheck(List.of(2, 3, 4, 5, 6, 7)));
  }

  @Test
  public void negativeNumbers() {
    Assert.assertFalse(check.returnCheck((List.of(-1, -2, -3, -4))));
  }

  @Test
  public void emptyArray() {
    Assert.assertFalse(check.returnCheck((List.of())));
  }
}
