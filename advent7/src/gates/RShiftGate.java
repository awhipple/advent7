package gates;

import util.UnsignedShort;

public class RShiftGate extends Gate {

  Gate input;
  
  public RShiftGate(Gate input) {
    this.input = input;
  }
  
  @Override
  public UnsignedShort output() {
    return input.output().rshift();
  }
  
}
