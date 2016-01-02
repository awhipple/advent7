package gates;

import util.UnsignedShort;

public class RShiftGate extends Gate {
    
  @Override
  public UnsignedShort output() {
    if(super.output() == null) {
      super.setOutput(input1.output().rshift(input2.output().get()));
    }
    return super.output();
  }
  
}
