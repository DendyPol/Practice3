package lesson_five;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class Race {
  private List<Stage> stages;
}
