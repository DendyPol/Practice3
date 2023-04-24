package lesson_seven;

import lesson_seven.annotation.AfterSuite;
import lesson_seven.annotation.BeforeSuite;
import lesson_seven.annotation.Test;

public class TestClass {
  @BeforeSuite
  public void beforeMethod() {
    System.out.println("Testing before method");
  }

  @Test(priority = 2)
  public void testOne() {
    System.out.println("Testing priority 1");
  }

  @Test(priority = 4)
  public void testTwo() {
    System.out.println("Testing priority 4");
  }

  @Test(priority = 4)
  public void testThree() {
    System.out.println("Testing priority 4");
  }

  @Test(priority = 7)
  public void testFour() {
    System.out.println("Testing priority 7");
  }

  @AfterSuite
  public void afterMethod() {
    System.out.println("Testing after method");
  }
}
