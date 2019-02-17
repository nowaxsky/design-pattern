package command.stage3;

public class GarageDoor {

  private String location;

  public GarageDoor(String location) {
    this.location = location;
  }

  public void up() {
    System.out.println(location + " garage door is UP!");
  }

  public void down() {
    System.out.println(location + " garage door is DOWN!");
  }

}
