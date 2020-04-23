package lesson3.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import lesson3.homework.topic1.DataFromCSV;
import lesson3.homework.topic2.Phonebook;

public class Main {

  public static void main(String[] args) {
    //topic1
    DataFromCSV dataFromCSV = new DataFromCSV();
    ArrayList<String> stringList = new ArrayList<>();

    List<List<String>> records = new ArrayList<>(dataFromCSV.addData("MOCK_DATA.csv"));

    for (List<String> record : records) {
      stringList.add(record.toString());
    }

    Set<String> setTest = new TreeSet<>();
    setTest.addAll(stringList);
    System.out.println(setTest.size());
    System.out.println(setTest);
    System.out.println();

    Map<String, Integer> map = new TreeMap<>();
    for (String string : stringList) {
      map.put(string, map.getOrDefault(string, 0) + 1);

//      if (!map.containsKey(string)) {
//        map.put(string, 1);
//      } else {
//        map.put(string, map.get(string) +1);
//      }
    }
    System.out.println(map);
    System.out.println(map.size());

    //topic2
    Phonebook phonebook = new Phonebook();
    phonebook.add("user1", "9999-999-010");
    phonebook.add("user1", "9999-999-011");
    phonebook.add("user1", "9999-999-012");
    phonebook.add("user2", "9999-999-020");
    phonebook.add("user2", "9999-999-021");
    phonebook.add("user3", "9999-999-030");

    System.out.println(phonebook.getPhone("user3"));
  }
}
/**
 * Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся). Найти и вывести
 * список уникальных слов, из которых состоит массив (дубликаты не считаем). Посчитать, сколько раз
 * встречается каждое слово.
 * <p>
 * Написать простой класс Телефонный Справочник, который хранит в себе список фамилий и телефонных
 * номеров. В этот телефонный справочник с помощью метода add() можно добавлять записи, а с помощью
 * метода get() искать номер телефона по фамилии. Следует учесть, что под одной фамилией может быть
 * несколько телефонов (в случае однофамильцев), тогда при запросе такой фамилии должны выводиться
 * все телефоны. Желательно не добавлять лишний функционал (дополнительные поля (имя, отчество,
 * адрес), взаимодействие с пользователем через консоль и т.д). Консоль использовать только для
 * вывода результатов проверки телефонного справочника.
 */

