package lesson_five;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;

@AllArgsConstructor
@Getter
public class Race {
  private ArrayList<Stage> stages;

  public Race(Stage... stages) {
    this.stages = new ArrayList<>();
    Collections.addAll(this.stages, stages);
  }
}
