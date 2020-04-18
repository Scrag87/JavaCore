package lesson2.homework;

public class ArrayUtils {

  public long arraySum(Object[][] array) throws ArraySizeException, ArrayDataException {

    ArraySizeException arraySizeException = new ArraySizeException();
    ArrayDataException arrayDataException = new ArrayDataException();

    arraySizeException.arraySize(array);
    return arrayDataException.dataException(array);
  }
}
