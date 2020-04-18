package lesson2.homework;

public class ArrayDataException extends Exception {

  public long dataException(Object[][] objects) throws ArrayDataException {
    int summ = 0;
    for (int i = 0; i < objects.length; i++) {
      for (int j = 0; j < objects[i].length; j++) {
        try {
          summ += (int) objects[i][j];
        } catch (Exception e) {
          //System.err.println("Illegal type of data at array index ["+i+"]["+j +"].
          // Data is: "+ objects[i][j]);
          throw new ArrayDataException();
        }
      }
    }
    return summ;
  }
}

