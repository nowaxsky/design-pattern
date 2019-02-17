package command.stage5;

public class LightOnCommand implements Command {

  private Light light;
  private boolean prevStatus;

  public LightOnCommand(Light light) {
    this.light = light;
  }

  @Override
  public void execute() {
    prevStatus = light.getStatus();
    light.on();
  }

  @Override
  public void undo() {
    if (prevStatus)
      light.on();
    else
      light.off();
  }

}
