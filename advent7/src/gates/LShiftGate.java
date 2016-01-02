package gates;

import util.UnsignedShort;

public class LShiftGate extends Gate {
    
  @Override
  public UnsignedShort output() {
    if(super.output() == null) {
      super.setOutput(input1.output().lshift(input2.output().get()));
    }
    return super.output();
  }
  
}
