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
        
        if(symbols.length == 4 && isUpperCase(symbols[0].charAt(0))) {
          //This means we have a 1 input gate such as 'NOT ab -> cd'
        } else if (symbols.length == 5 && isUpperCase(symbols[1].charAt(0))) {
          //This means we have a 2 input gate such as 'ab AND cd -> ef'
        } else if (symbols.length == 3 && symbols[1].equals("->")) {
          //This means we are writing a value to a line such as '123 -> ab' or 'ab -> cd'
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
