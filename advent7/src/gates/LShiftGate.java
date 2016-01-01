package gates;

import util.UnsignedShort;

public class LShiftGate extends Gate {

  Gate input;
  
  public LShiftGate(Gate input) {
    this.input = input;
  }
  
  @Override
  public UnsignedShort output() {
    return input.output().lshift();
  }
  
}
