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
        if (priority != Test.MIN_PRIORITY) {
          throw new RuntimeException("Метод с аннотацией BeforeSuite, должен иметь приоритет 1!");
        }
        if (beforeAnnotationCount > controlAnnotation) {
          throw new RuntimeException("Метод с аннотацией @BeforeSuite, должен быть в единственном эксземпляре!");
        }
        priorityCheck.put(priority, method);
        beforeAnnotationCount++;
      }
      if (method.isAnnotationPresent(AfterSuite.class)) {
        var priority = method.getAnnotation(AfterSuite.class).priority();
        if (priority != Test.MAX_PRIORITY) {
          throw new RuntimeException("Метод с аннотацией AfterSuite должен иметь приоритет 10!");
        }
        if (afterAnnotationCount > controlAnnotation) {
          throw new RuntimeException("Метод с аннотацией @AfterSuite, должен быть в единственном экземпляре!");
        }
        priorityCheck.put(priority, method);
        afterAnnotationCount++;
      }
      Test testAnnotation = method.getAnnotation(Test.class);
      if (testAnnotation != null) {
        var priority = testAnnotation.priority();
        if (priority < Test.MIN_PRIORITY || priority > Test.MAX_PRIORITY) {
          throw new RuntimeException("Приоритет метода должен составлять от 1 до 10");
        }
        priorityCheck.put(priority, method);
      }
    }
    if (beforeAnnotationCount == controlAnnotation) {
      throw new RuntimeException("Метод с аннотацией @BeforeSuite, должен быть определен!");
    }
    if (afterAnnotationCount == controlAnnotation) {
      throw new RuntimeException("Метод с аннотацией @AfterSuite, должен быть определен!");
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
        e.printStackTrace();
      }
    });
  }

  public static void main(String[] args) {
    try {
      RunTest.start(TestClass.class);
    } catch (RuntimeException e) {
      e.printStackTrace();
    }
  }
}
