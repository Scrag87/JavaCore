package lesson1.homework;

import java.util.ArrayList;
import java.util.List;
import lesson1.homework.barrier.Tredmill;
import lesson1.homework.barrier.Wall;
import lesson1.homework.entities.Human;
import lesson1.homework.entities.Robot;
import lesson1.homework.interfaces.*;
import lesson1.homework.entities.Cat;

public class TestClass {
  public static void main(String[] args) {

    //
    //    Course c = new Course(...); // Создаем полосу препятствий
    //    Team team = new Team(...); // Создаем команду
    //    c.doIt(team); // Просим команду пройти полосу
    //    team.showResults(); // Показываем результаты

    Tredmill tredmill = new Tredmill(40);
    Wall wall = new Wall(310);

    Team team1 = new Team(new Cat(30, 500), new Human(299, 400), new Robot(2000, 200));

    team1.doIt(tredmill, wall);
    team1.showResults();
  }
}
