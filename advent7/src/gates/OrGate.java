package gates;

import util.UnsignedShort;

public class OrGate extends Gate {
    
  @Override
  public UnsignedShort output() {
    if(super.output() == null) {
      super.setOutput(input1.output().or(input2.output()));
    }
    return super.output();
  }
  
}
