package gates;

import util.UnsignedShort;

public class NotGate extends Gate {

  Gate input;
  
  public NotGate(Gate input) {
    this.input = input;
  }
  
  @Override
  public UnsignedShort output() {
    return input.output().not();
  }
  
}
