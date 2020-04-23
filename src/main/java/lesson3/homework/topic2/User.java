package lesson3.homework.topic2;

import java.util.ArrayList;
import java.util.List;

public class User {

  private String username;
  private List<String> phoneNumbers = new ArrayList<>();

  public User(String username, String phoneNumbers) {
    this.username = username;
    this.phoneNumbers.add(phoneNumbers);
  }

  public void addPhonenumber(String phonenumber) {
    this.phoneNumbers.add(phonenumber);
  }

  @Override
  public String toString() {
    return "User{" +
        "phoneNumbers=" + phoneNumbers +
        '}';
  }

  public List<String> getPhoneNumbers() {
    return phoneNumbers;
  }
}
