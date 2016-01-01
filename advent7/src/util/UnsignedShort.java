package util;

public class UnsignedShort {
  boolean[] number = new boolean[16];
  
  public UnsignedShort(int value) {
    int bitValue = 32768;
    for(int bitPosition = 0; bitPosition < 16; bitPosition++) {
      if(value >= bitValue) {
        number[bitPosition] = true;
        value -= bitValue;
      } else {
        number[bitPosition] = false;
      }
      bitValue /= 2;
    }
  }
  
  public UnsignedShort(String value) {
    for(int i = 0; i < 16; i++) {
      number[i] = (value.length() > i && value.charAt(i) == '1');
    }
  }
  
  public UnsignedShort(boolean[] value) {
    for(int i = 0; i < 16; i++) {
      number[i] = (value.length > i && value[i]);
    }
  }

  public UnsignedShort and(UnsignedShort operand) {
    boolean[] firstOp = number,
              secondOp = operand.getBits(),
              thirdOp = new boolean[16];

    for(int i = 0; i < 16; i++) {
      thirdOp[i] = firstOp[i] && secondOp[i];
    }
    return new UnsignedShort(thirdOp);
  }
  
  public UnsignedShort or(UnsignedShort operand) {
    boolean[] firstOp = number,
              secondOp = operand.getBits(),
              thirdOp = new boolean[16];

    for(int i = 0; i < 16; i++) {
      thirdOp[i] = firstOp[i] || secondOp[i];
    }
    return new UnsignedShort(thirdOp);
  }
  
  public UnsignedShort not() {
    boolean[] firstOp = number,
              secondOp = new boolean[16];
    for(int i = 0; i < 16; i++) {
      secondOp[i] = !firstOp[i];
    }
    return new UnsignedShort(secondOp);
  }
  
  public UnsignedShort lshift() {
    boolean[] firstOp = number,
              secondOp = new boolean[16];
    for(int i = 1; i < 16; i++) {
      secondOp[i-1] = firstOp[i];
    }
    secondOp[15] = false;
    return new UnsignedShort(secondOp);
  }
    
  public UnsignedShort rshift() {
    boolean[] firstOp = number,
              secondOp = new boolean[16];
    for(int i = 0; i < 15; i++) {
      secondOp[i+1] = firstOp[i];
    }
    secondOp[0] = false;
    return new UnsignedShort(secondOp);
  }
  
  
  @Override
  public String toString() {
    String retValue = "";
    for(int i = 0; i < 16; i++) {
      retValue += number[i] ? "1" : "0";
    }
    return retValue;
  }
  
  public boolean[] getBits() {
    return number;
  }
  
  public int get() {
    int total = 0;
    int bitValue = 32768;
    for(int bitPosition = 0; bitPosition < 16; bitPosition++) {
      if(number[bitPosition]) {
        total += bitValue;
      }
      bitValue /= 2;
    }
    return total;
  }
}
