package lesson_seven;

import lesson_seven.annotation.AfterSuite;
import lesson_seven.annotation.BeforeSuite;
import lesson_seven.annotation.Test;
import lombok.extern.java.Log;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.logging.Level;

@Log
public class RunTest {
  public static void start(Class<?> testClassName) throws RuntimeException {
    var beforeAnnotationCount = 0;
    var afterAnnotationCount = 0;
    var controlAnnotation = 0;
    var priorityCheck = new HashMap<Integer, Method>();
    var methods = testClassName.getDeclaredMethods();
    for (Method method : methods) {
      if (method.isAnnotationPresent(BeforeSuite.class)) {
        var priority = method.getAnnotation(BeforeSuite.class).priority();
        checkNullAndPriority(priority, BeforeSuite.class, Test.MIN_PRIORITY);
        priorityCheck.put(priority, method);
        beforeAnnotationCount++;
      }
      if (method.isAnnotationPresent(AfterSuite.class)) {
        var priority = method.getAnnotation(AfterSuite.class).priority();
        checkNullAndPriority(priority, AfterSuite.class, Test.MAX_PRIORITY);
        priorityCheck.put(priority, method);
        afterAnnotationCount++;
      }
      var testAnnotation = method.getAnnotation(Test.class);
      if (testAnnotation != null) {
        var priority = testAnnotation.priority();
        checkNullAndPriority(priority, Test.class, priority);
        priorityCheck.put(priority, method);
      }
    }
    if (beforeAnnotationCount == controlAnnotation || afterAnnotationCount == controlAnnotation) {
      throw new RuntimeException("Метод с аннотацией @BeforeSuite или @AfterSuite должен быть определен!");
    }
    priorityCheck.values().forEach(method -> {
      try {
        method.invoke(testClassName.getDeclaredConstructor().newInstance());
      } catch (IllegalAccessException e) {
        log.log(Level.WARNING, "Ошибка! Нет доступа к вызываемому методу!", e.getMessage());
      } catch (InvocationTargetException e) {
        log.log(Level.WARNING, "Ошибка при вызове метода и бросании внутреннего исключения!", e.getMessage());
      } catch (InstantiationException e) {
        log.log(Level.WARNING, "Ошибка! Класс не имеет конструктора без параметров!", e.getMessage());
      } catch (NoSuchMethodException e) {
        log.log(Level.WARNING, "Ошибка! Невозможно вызвать несущестсвующий метод!", e.getMessage());
      }
    });
  }

  private static void checkNullAndPriority(Integer priority, Class<?> annotationClass, int expectedPriority) {
    if (priority == null) {
      throw new RuntimeException(annotationClass.getSimpleName() + " должна быть определена в тестовом классе!");
    }
    if (priority != expectedPriority) {
      throw new RuntimeException(annotationClass.getSimpleName() + " должна иметь приоритет " + expectedPriority + "!");
    }
    if (annotationClass.equals(Test.class) && (priority < Test.MIN_PRIORITY || priority > Test.MAX_PRIORITY)) {
      throw new RuntimeException("Приоритет метода должен быть от " + Test.MIN_PRIORITY + " до " + Test.MAX_PRIORITY);
    }
  }

  public static void main(String[] args) {
    try {
      RunTest.start(TestClass.class);
    } catch (RuntimeException e) {
      log.log(Level.WARNING, "Ошибка при проверке тестов!", e.getMessage());
    }
  }
}
