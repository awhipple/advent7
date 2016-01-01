package gates;

import util.UnsignedShort;

public class OrGate extends Gate {

  Gate input1, input2;
  
  public OrGate(Gate input1, Gate input2) {
    this.input1 = input1;
    this.input2 = input2;
  }
  
  @Override
  public UnsignedShort output() {
    return input1.output().or(input2.output());
  }
  
}
