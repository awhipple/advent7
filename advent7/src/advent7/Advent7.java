package advent7;

import gates.Gate;
import java.util.Map;
import util.UnsignedShort;

public class Advent7 {

  public static void main(String[] args) {
    Map<String, Gate> gateList = CircuitParser.parseCircuitFile("data/input.txt");
    
    UnsignedShort output = gateList.get("a").output();
    System.out.println(output.toString());
    System.out.println(output.get());
  }
}
