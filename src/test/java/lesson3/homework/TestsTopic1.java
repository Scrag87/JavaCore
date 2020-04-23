package lesson3.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import lesson3.homework.topic1.DataFromCSV;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

public class TestsTopic1 {

  //topic1
  DataFromCSV dataFromCSV = new DataFromCSV();
  ArrayList<String> stringList = new ArrayList<>();
  List<List<String>> records = new ArrayList<>(dataFromCSV.addData("MOCK_DATA.csv"));
  Set<String> setTest = new TreeSet<>();
  Map<String, Integer> map = new TreeMap<>();

  @Before
  public void init() {
    for (List<String> record : records) {
      stringList.add(record.toString());
    }
  }

  @After
  public void after() {
    map.clear();
    setTest.clear();
  }

  @org.junit.Test
  public void testNoDuplicates() {
    setTest.addAll(stringList);
    Assert.assertEquals(162, setTest.size());
  }

  @org.junit.Test
  public void testNoMapDuplicates() {
    for (String string : stringList) {
      map.put(string, map.getOrDefault(string, 0) + 1);
    }
    Assert.assertEquals(162, map.size());
  }

  @org.junit.Test
  public void testCountDuplicates() {
    for (String string : stringList) {
      map.put(string, map.getOrDefault(string, 0) + 1);
    }
    System.out.println(stringList.get(12));
    int i = map.get(stringList.get(12));
    Assert.assertEquals(2, i);
  }
}
