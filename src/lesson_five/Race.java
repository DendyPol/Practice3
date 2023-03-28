package lesson_five;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;

@AllArgsConstructor
@Getter
public class Race {
  private ArrayList<Stage> stages;
}
