package gates;

import util.UnsignedShort;

public class DuplicateGate extends Gate {
    
  @Override
  public UnsignedShort output() {
    return input1.output();
  }
  
}