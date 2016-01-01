package advent7;

import gates.AndGate;
import gates.DuplicateGate;
import gates.Gate;
import gates.InputGate;
import gates.LShiftGate;
import gates.NotGate;
import gates.OrGate;
import gates.RShiftGate;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import util.UnsignedShort;

public class CircuitParser {

  public static void parseCircuitFile(String fileName) {
    String line = null;

    try {
      FileReader fileReader = new FileReader(fileName);

      BufferedReader bufferedReader = new BufferedReader(fileReader);
      
      ArrayList<String> fileLines = new ArrayList<>();
      
      while((line = bufferedReader.readLine()) != null) {
        fileLines.add(line);
      }
      
      Map<String, Gate> gateList = new HashMap<>();
      
      for(String gateLine : fileLines) {
        String[] symbols = gateLine.split(" ");
        
        if(symbols.length == 4 && isUpperCase(symbols[0].charAt(0))) {
          //This means we have a 1 input gate such as 'NOT ab -> cd'
          switch(symbols[0]) {
            case "NOT":    gateList.put(symbols[3], new NotGate());
                           break;
            case "LSHIFT": gateList.put(symbols[3], new LShiftGate());
                           break;
            case "RSHIFT": gateList.put(symbols[3], new RShiftGate());
                           break;
          }
        } else if (symbols.length == 5 && isUpperCase(symbols[1].charAt(0))) {
          //This means we have a 2 input gate such as 'ab AND cd -> ef'
          switch(symbols[1]) {
            case "AND": gateList.put(symbols[4], new AndGate());
                        break;
            case "OR" : gateList.put(symbols[4], new OrGate());
                        break;
          }
        } else if (symbols.length == 3 && symbols[1].equals("->")) {
          //This means we are writing a value to a line such as '123 -> ab' or 'ab -> cd'
          if(isDigit(symbols[0].charAt(0))) {
            gateList.put(symbols[2], new InputGate(new UnsignedShort(Integer.parseInt(symbols[0]))));
          } else if (isLowerCase(symbols[0].charAt(0))) {
            gateList.put(symbols[2], new DuplicateGate());
          } else {
            throw new IOException();
          }
        } else {
          throw new IOException();
        }
      }

/* All gates should now be created.
   All that remains should be to go and backfill all inputs based on
      provided parameters.
   Lookup using gateList.
*/
      
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
