package gates;

import util.UnsignedShort;

public class DuplicateGate extends Gate {

  Gate input;
  
  public DuplicateGate(Gate input) {
    this.input = input;
  }
  
  @Override
  public UnsignedShort output() {
    return input.output();
  }
  
}