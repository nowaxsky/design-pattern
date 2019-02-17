package command.complete;

public class Light {

  public static final boolean ON = true;
  public static final boolean OFF = false;
  private String location = "";
  private boolean status;

  public Light(String location) {
    this.location = location;
  }

  public void on() {
    status = true;
    System.out.println(location + " light is on");
  }

  public void off() {
    status = false;
    System.out.println(location + " light is off");
  }

  public boolean getStatus() {
    return status;
  }

}
