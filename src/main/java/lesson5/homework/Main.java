package lesson5.homework;

import java.util.ArrayList;

public class Main {

  static PerformanceTester performanceTester = new PerformanceTester();

  public static void main(String[] args) {
    MultiThread multiThread = new MultiThread();

    float[] testArray = new float[100_000_000];
    for (int i = 0; i < testArray.length; i++) {
      testArray[i] = i;
    }
    ArrayList<float[]> testArrays = multiThread.splitArray(testArray, 4);

    ArrayList<float[]> finalTestArrays = testArrays;

    Thread threadSingle = new Thread(() -> multiThread.calculateNewValue(testArray));
    Thread thread1 = new Thread(() -> multiThread.calculateNewValue(finalTestArrays.get(0)));
    Thread thread2 = new Thread(() -> multiThread.calculateNewValue(finalTestArrays.get(1)));
    Thread thread3 = new Thread(() -> multiThread.calculateNewValue(finalTestArrays.get(2)));
    Thread thread4 = new Thread(() -> multiThread.calculateNewValue(finalTestArrays.get(3)));

    performanceTester.measureStart();
    threadSingle.start();
    while (threadSingle.isAlive()) {
    }
    performanceTester.measureFinish("threadSingle");

    performanceTester.measureStart();
    thread1.start();
    thread2.start();
    thread3.start();
    thread4.start();
    while (thread1.isAlive() && thread2.isAlive() && thread3.isAlive() && thread4.isAlive()) {
    }
    multiThread.joinArray(finalTestArrays);
    performanceTester.measureFinish("multiThreads");

//    System.out.println("-------------------testArrays-------------------");
//    arrayToStringFirstN(testArrays.get(0), 10);
//    arrayToStringFirstN(testArrays.get(1), 10);
//    arrayToStringFirstN(testArrays.get(2), 10);
//    arrayToStringFirstN(testArrays.get(3), 10);
//    arrayToString(multiThread.joinArray(resultArrays));
  }

  private static void arrayToStringFirstN(float[] resultArray, int n) {
    System.out.print("_> ");
    for (int i = 0; i < n; i++) {
      System.out.print(resultArray[i] + " ");
    }
    System.out.println();
  }

}
