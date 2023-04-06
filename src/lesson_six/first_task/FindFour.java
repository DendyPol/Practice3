package lesson_six.first_task;

import java.util.ArrayList;
import java.util.List;

public class FindFour {

  public List<Integer> returnArray(List<Integer> array) throws MyRuntimeException {
    var result = new ArrayList<Integer>();
    if (!array.contains(4)) {
      throw new MyRuntimeException();
    } else {
      for (Integer number : array) {
        if (number == 4) {
          result.clear();
          continue;
        }
        result.add(number);
      }
    }
    return result;
  }
}
