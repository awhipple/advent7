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

  public static Map<String, Gate> parseCircuitFile(String fileName) {
    String line = null;
    Map<String, Gate> gateList = new HashMap<>();
    
    try {
      FileReader fileReader = new FileReader(fileName);

      BufferedReader bufferedReader = new BufferedReader(fileReader);
      
      ArrayList<String> fileLines = new ArrayList<>();
      
      while((line = bufferedReader.readLine()) != null) {
        fileLines.add(line);
      }
      
      bufferedReader.close();
      fileReader.close();
      
      for(String gateLine : fileLines) {
        String[] symbols = gateLine.split(" ");
        
        if(symbols.length == 4 && isUpperCase(symbols[0].charAt(0))) {
          //This means we have a 1 input gate such as 'NOT ab -> cd'
          if(symbols[0].equals("NOT")) {
            gateList.put(symbols[3], new NotGate());
          }
          gateList.get(symbols[3]).setDebugInfo(gateLine);
        } else if (symbols.length == 5 && isUpperCase(symbols[1].charAt(0))) {
          //This means we have a 2 input gate such as 'ab AND cd -> ef'
          switch(symbols[1]) {
            case "AND"   : gateList.put(symbols[4], new AndGate());
                           break;
            case "OR"    : gateList.put(symbols[4], new OrGate());
                           break;
            case "LSHIFT": gateList.put(symbols[4], new LShiftGate());
                           break;
            case "RSHIFT": gateList.put(symbols[4], new RShiftGate());
                           break;
          }
          gateList.get(symbols[4]).setDebugInfo(gateLine);
        } else if (symbols.length == 3 && symbols[1].equals("->")) {
          //This means we are writing a value to a line such as '123 -> ab' or 'ab -> cd'
          if(isDigit(symbols[0].charAt(0))) {
            gateList.put(symbols[2], new InputGate(new UnsignedShort(Integer.parseInt(symbols[0]))));
          } else if (isLowerCase(symbols[0].charAt(0))) {
            gateList.put(symbols[2], new DuplicateGate());
          } else {
            throw new IOException();
          }
          gateList.get(symbols[2]).setDebugInfo(gateLine);
        } else {
          throw new IOException();
        }
      }
                  
      for(String gateLine : fileLines) {
        String[] symbols = gateLine.split(" ");
        
        if(symbols.length == 4 && isUpperCase(symbols[0].charAt(0))) {
          //This means we have a 1 input gate such as 'NOT ab -> cd'
          gateList.get(symbols[3]).setFirstInput(getGateReference(symbols[1], gateList));
        } else if (symbols.length == 5 && isUpperCase(symbols[1].charAt(0))) {
          //This means we have a 2 input gate such as 'ab AND cd -> ef'
          Gate thisGate = gateList.get(symbols[4]);
          thisGate.setFirstInput(getGateReference(symbols[0], gateList));
          thisGate.setSecondInput(getGateReference(symbols[2], gateList));
        } else if (symbols.length == 3 && symbols[1].equals("->") && isLowerCase(symbols[0].charAt(0))) {
          //This means we are duplicating another gate such as 'ab -> cd'
          //We don't want to handle the '123 -> ab' case here because it was already done above
          gateList.get(symbols[2]).setFirstInput(gateList.get(symbols[0]));
        }
      }
    } catch (FileNotFoundException ex) {
      System.out.println("Unable to open file '" + fileName + "'");
    } catch (IOException ex) {
      System.out.println("Error reading file '" + fileName + "'");
    }
   
    return gateList;
  }
  
  private static Gate getGateReference(String symbol, Map<String, Gate> gateList) {
    //Checks if the symbol is a number or a reference to a gate and then returns the proper gate
    if(isLowerCase(symbol.charAt(0))) {
      return gateList.get(symbol);
    } else {
      Gate newInputGate = new InputGate(new UnsignedShort(Integer.parseInt(symbol)));
      newInputGate.setDebugInfo(symbol);
      return newInputGate;
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
