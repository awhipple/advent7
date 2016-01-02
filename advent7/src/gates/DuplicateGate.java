package gates;

import util.UnsignedShort;

public class DuplicateGate extends Gate {
    
  @Override
  public UnsignedShort output() {
    if(super.output() == null) {
      super.setOutput(input1.output());
    }
    return super.output();
  }
  
}