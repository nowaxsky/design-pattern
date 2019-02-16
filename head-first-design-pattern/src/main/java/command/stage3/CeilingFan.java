package command.stage3;

public class CeilingFan {

  private String location = "";

  public CeilingFan(String location) {
    this.location = location;
  }

  public void on() {
    // turns the ceiling fan on
    System.out.println(location + " ceiling fan is on!");
  }

  public void off() {
    // turns the ceiling fan off
    System.out.println(location + " ceiling fan is off!");
  }

}
