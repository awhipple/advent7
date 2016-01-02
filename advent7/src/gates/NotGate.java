package gates;

import util.UnsignedShort;

public class NotGate extends Gate {
    
  @Override
  public UnsignedShort output() {
    if(super.output() == null) {
      super.setOutput(input1.output().not());
    }
    return super.output();
  }
  
}
