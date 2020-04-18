package lesson2.homework;

public class ArraySizeException extends Exception {

  public void arraySize(Object[][] objects) throws ArraySizeException {
    if (objects.length != 4 || objects[0].length != 4) {
      throw new ArraySizeException();
    }
  }
}