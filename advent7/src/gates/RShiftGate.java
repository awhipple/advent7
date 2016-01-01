package gates;

import util.UnsignedShort;

public class RShiftGate extends Gate {
    
  @Override
  public UnsignedShort output() {
    return input1.output().rshift();
  }
  
}
