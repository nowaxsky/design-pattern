package command.complete;

import java.util.Stack;

public class Stereo {

  private String location;
  public static final int OFF = 0;
  public static final int ON = 1;
  public static final int SET_CD = 2;
  public static final int SET_DVD = 3;
  public static final int SET_RADIO = 4;
  public static final int SET_VOLUME = 50;
  private Stack<Integer> statusStack;

  public Stereo(String location) {
    this.location = location;
    statusStack = new Stack<>();
  }

  public void on() {
    statusStack.push(ON);
    System.out.println(location + " stereo is on!");
  }

  public void off() {
    statusStack.push(OFF);
    System.out.println(location + " stereo is off!");
  }

  public void setCD() {
    statusStack.push(SET_CD);
    System.out.println(location + " stereo is set for CD input!");
  }

  public void setDVD() {
    statusStack.push(SET_DVD);
    System.out.println(location + " stereo is set for DVD input!");
  }

  public void setRadio() {
    statusStack.push(SET_RADIO);
    System.out.println(location + " stereo is set for Radio!");
  }

  public void setVolume(int volume) {
    statusStack.push(SET_VOLUME + volume);
    
    // code to set the volume
    // valid range: 1-11 (after all 11 is better than 10, right?)
    System.out.println(location + " Stereo volume set to " + volume + "!");
  }
  
  public int getStatus() {
    return statusStack.empty() ? OFF : statusStack.pop();
  }
}
