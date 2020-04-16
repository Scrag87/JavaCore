package lesson1.homework.barrier;

import lesson1.homework.barrier.Tredmill;
import lesson1.homework.barrier.Wall;

public class Course {
  Tredmill tredmill;
  Wall wall;

  @Override
  public String toString() {
    return "Course{" +
        "tredmill=" + tredmill +
        ", wall=" + wall +
        '}';
  }

  public Course(Tredmill tredmill, Wall wall) {
    this.tredmill = tredmill;
    this.wall = wall;
  }
}
