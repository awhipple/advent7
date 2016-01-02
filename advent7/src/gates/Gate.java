package gates;

import util.UnsignedShort;

public abstract class Gate {
  
  Gate input1, input2;
  UnsignedShort output;
  String gateLine;

  public Gate() {
    output = null;
  }
  
  public UnsignedShort output() {
    return output;
  }
  public void setFirstInput(Gate input) {
    this.input1 = input;
  }
  public void setSecondInput(Gate input) {
    this.input2 = input;
  };
  public void setDebugInfo(String gateLine) {
    this.gateLine = gateLine;
  }
  public void setOutput(UnsignedShort output) {
    this.output = output;
  }
}
