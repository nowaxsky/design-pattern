package command.stage3;

public class GarageDoorDownCommand implements Command {

  private GarageDoor garage;
  
  public GarageDoorDownCommand(GarageDoor garage) {
    this.garage = garage;
  }
  
  @Override
  public void execute() {
    garage.down();
  }

}
