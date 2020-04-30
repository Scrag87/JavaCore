package lesson5.homework;

import java.util.ArrayList;
import java.util.Arrays;

public class MultiThread implements iMultiThread {

  public ArrayList<float[]> splitArray(float[] arr, int pieces) {
    ArrayList<float[]> list = new ArrayList<>();
    int capacity = arr.length / pieces;
    for (int i = 0; i < pieces; i++) {
      list.add(Arrays.copyOfRange(arr, (i) * (capacity), (i + 1) * (capacity)));
    }
    return list;
  }

  @Override
  public float[] calculateNewValue(float[] arr) {
    for (int i = 0; i < arr.length; i++) {
      arr[i] =
          (float) (arr[i] * Math.sin(0.2f + i / 5.0) * Math.cos(0.2f + i / 5.0) * Math
              .cos(0.4f + i / 2.0));
    }
    return arr;
  }

  @Override
  public float[] joinArray(ArrayList<float[]> floats) {
    int newLength = 0;
    int joinValue = 0;

    for (int i = 0; i < floats.size(); i++) {
      newLength += floats.get(i).length;
    }

    float[] joinedArray = new float[newLength];

    for (int i = 0; i < floats.size(); i++) {
      System.arraycopy(floats.get(i), 0, joinedArray, joinValue, floats.get(i).length);
      joinValue += floats.get(i).length;
    }
    return joinedArray;
  }
}