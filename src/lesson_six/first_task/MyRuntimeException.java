package lesson_six.first_task;

import lombok.extern.java.Log;

import java.util.logging.Level;

@Log
public class MyRuntimeException extends RuntimeException {
  public MyRuntimeException() {
    log.log(Level.SEVERE, "В массиве отсутствует 4!" + getMessage() + getStackTrace());
  }
}
