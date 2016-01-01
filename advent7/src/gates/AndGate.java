package gates;

import util.UnsignedShort;

public class AndGate extends Gate {

  @Override
  public UnsignedShort output() {
    return input1.output().and(input2.output());
  }

}
