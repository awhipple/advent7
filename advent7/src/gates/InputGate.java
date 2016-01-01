package gates;

import util.UnsignedShort;

public class InputGate extends Gate {

  UnsignedShort input;
  
  public InputGate(UnsignedShort input) {
    this.input = input;
  }
  
  @Override
  public UnsignedShort output() {
    return input;
  }
  
}
