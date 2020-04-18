package lesson2.homework;

import java.util.Arrays;

public class Main {
     /*
      * Практическое задание
      *
      Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4. При
      подаче массива другого размера необходимо бросить исключение MyArraySizeException.
      *
      Далее метод должен пройтись по всем элементам массива, преобразовать в int и
      просуммировать. Если в каком-то элементе массива преобразование не удалось (например, в
      ячейке лежит символ или текст вместо числа), должно быть брошено исключение
      MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.
      *
      В методе main() вызвать полученный метод, обработать возможные исключения
      MySizeArrayException и MyArrayDataException и вывести результат расчета.
      * */

  public static void main(String[] args) {

    Object[][] objects3 = new Object[3][50];
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 50; j++) {
        objects3[i][j] = 10;
      }
    }

    Object[][] objects = new Object[4][4];
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 4; j++) {
        objects[i][j] = 10;
      }
    }

    System.out.println("objects" + Arrays.deepToString(objects));

    Object[][] objects2 = new Object[4][4];
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 4; j++) {
        objects2[i][j] = 10;
      }
    }
    objects2[3][3] = "String";

    System.out.println("objects2" + Arrays.deepToString(objects2));
    System.out.println("objects+" + Arrays.deepToString(objects));

    // протестируйте arraySum здесь

    ArrayDataException arrayDataException = new ArrayDataException();

    try {
      arrayDataException.dataException(objects);
    } catch (ArrayDataException e) {
      e.printStackTrace();
    }


  }
}
