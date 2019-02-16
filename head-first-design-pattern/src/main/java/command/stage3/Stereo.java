package command.stage3;

public class Stereo {

  private String location;

  public Stereo(String location) {
    this.location = location;
  }

  public void on() {
    System.out.println(location + " stereo is on!");
  }

  public void off() {
    System.out.println(location + " stereo is off!");
  }

  public void setCD() {
    System.out.println(location + " stereo is set for CD input!");
  }

  public void setVolume(int volume) {
    // code to set the volume
    // valid range: 1-11 (after all 11 is better than 10, right?)
    System.out.println(location + " Stereo volume set to " + volume + "!");
  }
}
