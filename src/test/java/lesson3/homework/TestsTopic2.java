package lesson3.homework;

import lesson3.homework.topic2.Phonebook;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

public class TestsTopic2 {

  Phonebook phonebook;

  @Before
  public void init() {
    phonebook = new Phonebook();
    phonebook.add("user0", "9999-999-010");
    phonebook.add("user1", "9999-999-010");
    phonebook.add("user1", "9999-999-011");
    phonebook.add("user1", "9999-999-012");
    phonebook.add("user2", "9999-999-020");
    phonebook.add("user2", "9999-999-021");
    phonebook.add("user3", "9999-999-030");
  }

  @After
  public void after() {
    phonebook.clear();
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testNoUserSituation() {
    phonebook.getPhone("user4");
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void testEmptyUserSituation() {
    phonebook.getPhone("");
  }

  @org.junit.Test()
  public void testValidDataFromUser3() {
    phonebook.getPhone("user3");
    Assert.assertEquals("[9999-999-030]", phonebook.getPhone("user3"));
  }

}
