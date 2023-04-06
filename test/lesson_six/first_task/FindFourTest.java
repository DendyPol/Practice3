package lesson_six.first_task;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindFourTest {
  private static FindFour check;

  @BeforeClass
  public static void init() {
    System.out.println("Testing Find Four");
    check = new FindFour();
  }

  @Test
  public void singleFour() {
    Assert.assertEquals(List.of(5, 6), check.returnArray(List.of(1, 2, 3, 4, 5, 6)));
  }

  @Test
  public void twoFour() {
    Assert.assertEquals(List.of(7, 8), check.returnArray(List.of(1, 2, 3, 4, 3, 2, 4, 7, 8)));
  }

  @Test
  public void notEqualsElement() {
    Assert.assertNotEquals(List.of(6, 9), check.returnArray(List.of(3, 4, 5, 6, 7, 4, 6, 8)));
  }

  @Test
  public void negativeNumbers() {
    Assert.assertEquals(List.of(7), check.returnArray(List.of(-1, -2, -3, -4, 4, 7)));
  }

  @Test(expected = MyRuntimeException.class)
  public void withoutFourTestReturnArrayThrowsException() {
    var array = Arrays.asList(1, 2, 3, 5);
    check.returnArray(array);
  }

  @Test(expected = MyRuntimeException.class)
  public void emptyArray() {
    var empty = new ArrayList<Integer>(List.of());
    check.returnArray(empty);
  }
}
