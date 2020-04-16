package lesson1.homework;

import java.util.ArrayList;
import java.util.List;
import lesson1.homework.barrier.Tredmill;
import lesson1.homework.barrier.Wall;
import lesson1.homework.entities.Cat;
import lesson1.homework.entities.Human;
import lesson1.homework.entities.Robot;
import lesson1.homework.interfaces.iJumpOver;
import lesson1.homework.interfaces.iRunThough;

public class Team {
Cat cat;
Human human;
Robot robot;

  public Team(Cat cat, Human human, Robot robot) {
    this.cat = cat;
    this.human = human;
    this.robot = robot;
  }

  @Override
  public String toString() {
    return "Team{" +
        "cat=" + cat +
        ", human=" + human +
        ", robot=" + robot +
        '}';
  }

  public  void  doIt(Tredmill tredmill, Wall wall){
    List<iJumpOver> jumpOverList = new ArrayList<>();
    jumpOverList.add(this.cat);
    jumpOverList.add(this.human);
    jumpOverList.add(this.robot);

    for (iJumpOver jumpOver : jumpOverList) {
      jumpOver.jumpOverTheWall(wall);
    }

    if(human.isJumpTestPassed()){
      human.runThoughTredmill(tredmill);
    }
    if(cat.isJumpTestPassed()){
      cat.runThoughTredmill(tredmill);
    }
    if(robot.isJumpTestPassed()){
      robot.runThoughTredmill(tredmill);
    }
  }

  public void showResults() {
    System.out.println(human.getClass().getSimpleName()+": jump test: "+human.isJumpTestPassed()+
        ", run test: "+human.isRunTestPassed());

    System.out.println(robot.getClass().getSimpleName()+": jump test: "+robot.isJumpTestPassed()+
        ", run test: "+robot.isRunTestPassed());

    System.out.println(cat.getClass().getSimpleName()+": jump test: "+cat.isJumpTestPassed()+
        ", run test: "+cat.isRunTestPassed());
  }
}
