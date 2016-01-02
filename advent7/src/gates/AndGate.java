package gates;

import util.UnsignedShort;

public class AndGate extends Gate {

  @Override
  public UnsignedShort output() {
    if(super.output() == null) {
      super.setOutput(input1.output().and(input2.output()));
    }
    return super.output();
  }

}
