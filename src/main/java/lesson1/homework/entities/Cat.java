package lesson1.homework.entities;

import lesson1.homework.barrier.Tredmill;
import lesson1.homework.barrier.Wall;
import lesson1.homework.interfaces.*;

public class Cat implements iJumpOver, iRunThough {
  private int runDistance;
  private  int jumpHeight;
  private boolean runTestPassed;
  private boolean jumpTestPassed;


  public boolean isRunTestPassed() {
    return runTestPassed;
  }

  public boolean isJumpTestPassed() {
    return jumpTestPassed;
  }

  public Cat(int runDistance, int jumpHeight) {
    this.runDistance = runDistance;
    this.jumpHeight = jumpHeight;
  }

  @Override
  public String toString() {
    return "Cat{" +
        "runDistance=" + runDistance +
        ", jumpHeight=" + jumpHeight +
        '}';
  }

  @Override
  public void jumpOverTheWall(Wall wall) {
    jumpTestPassed= this.jumpHeight >= wall.getHeight();
  }

  @Override
  public void runThoughTredmill(Tredmill tredmill) {
    runTestPassed = this.runDistance >= tredmill.getDistance();
  }
}