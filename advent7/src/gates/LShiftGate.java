package gates;

import util.UnsignedShort;

public class LShiftGate extends Gate {
    
  @Override
  public UnsignedShort output() {
    return input1.output().lshift();
  }
  
}
