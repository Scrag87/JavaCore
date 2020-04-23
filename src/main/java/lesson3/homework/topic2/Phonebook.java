package lesson3.homework.topic2;

import java.util.Map;
import java.util.TreeMap;

public class Phonebook {

  private Map<String, User> userTreeMap = new TreeMap<>();

  public void add(String username, String phonenumber) {
    if (userTreeMap.containsKey(username)) {
      userTreeMap.get(username).addPhonenumber(phonenumber);
    } else {
      userTreeMap.put(username, new User(username, phonenumber));
    }
  }

  public void clear() {
    userTreeMap.clear();
  }

  public String getPhone(String username) {

    if (userTreeMap.containsKey(username)) {
      return userTreeMap.get(username).getPhoneNumbers().toString();
    } else {
      throw new IllegalArgumentException("No such user in DB");
    }
  }
}

