package gates;

import util.UnsignedShort;

public class OrGate extends Gate {
    
  @Override
  public UnsignedShort output() {
    return input1.output().or(input2.output());
  }
  
}
