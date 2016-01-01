package gates;

import util.UnsignedShort;

public class AndGate extends Gate {

  Gate input1, input2;
  
  public AndGate(Gate input1, Gate input2) {
    this.input1 = input1;
    this.input2 = input2;
  }
  
  @Override
  public UnsignedShort output() {
    return input1.output().and(input2.output());
  }
  
}
