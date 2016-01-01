package advent7;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CircuitParser {

  public static void parseCircuitFile(String fileName) {
    String line = null;

    try {
      FileReader fileReader = new FileReader(fileName);

      BufferedReader bufferedReader = new BufferedReader(fileReader);

      while ((line = bufferedReader.readLine()) != null) {
        String[] symbols = line.split(" ");
        char firstChar = symbols[0].charAt(0);
        if(isLowerCase(firstChar)) {
          if(symbols[1].equals("->")) {
            //This means we have a line duplicating to another such as 'ab -> cd'
          } else {
            //This means we have a 3 expression gate such as 'ab AND cd -> ef'
          }
        } else if(isUpperCase(firstChar)) {
          //This means we have a 2 expression gate such as 'NOT ab -> cd'
        } else if(isDigit(firstChar)) {
          //This means we have an input such as '1234 -> ab'
        } else {
          throw new IOException();
        }
      }

      bufferedReader.close();
    } catch (FileNotFoundException ex) {
      System.out.println("Unable to open file '" + fileName + "'");
    } catch (IOException ex) {
      System.out.println("Error reading file '" + fileName + "'");
    }
  }
  
  private static boolean isLowerCase(char c) {
    return c >= 'a' && c <= 'z';
  }
  
  private static boolean isUpperCase(char c) {
    return c >= 'A' && c <= 'Z';
  }
  
  private static boolean isDigit(char c) {
    return c >= '0' && c <= '9';
  }
}
