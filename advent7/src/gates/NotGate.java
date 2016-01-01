package gates;

import util.UnsignedShort;

public class NotGate extends Gate {
    
  @Override
  public UnsignedShort output() {
    return input1.output().not();
  }
  
}
