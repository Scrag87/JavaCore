package lesson3.homework.topic1;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <dependency>
 * <groupId>com.opencsv</groupId>
 * <artifactId>opencsv</artifactId>
 * <version>5.1</version>
 * </dependency>
 */

public class DataFromCSV {

  public List<List<String>> addData(String filePath) {

    List<List<String>> data = new ArrayList<>();
    try (CSVReader csvReader = new CSVReader(new FileReader(filePath))) {
      String[] values = null;
      while (true) {
        try {
          if ((values = csvReader.readNext()) == null) {
            break;
          }
        } catch (IOException e) {
          e.printStackTrace();
        } catch (CsvValidationException e) {
          e.printStackTrace();
        }
        data.add(Arrays.asList(values));
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return data;
  }
}