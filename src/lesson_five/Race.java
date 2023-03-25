package lesson_five;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;

@AllArgsConstructor
@Getter
public class Race {
  private ArrayList<Stage> stages;

  public Race(Stage... stages) {
    this.stages = new ArrayList<>(Arrays.asList(stages));
  }
}
