package command.stage3;

public class GarageDoorUpCommand implements Command {

  private GarageDoor garage;

  public GarageDoorUpCommand(GarageDoor garage) {
    this.garage = garage;
  }

  @Override
  public void execute() {
    garage.up();
  }

}
