package gates;

import util.UnsignedShort;

public abstract class Gate {
  
  Gate input1, input2;
  
  public abstract UnsignedShort output();
  public void setFirstInput(Gate input) {
    this.input1 = input;
  }
  public void setSecondInput(Gate input) {
    this.input2 = input;
  };
}
