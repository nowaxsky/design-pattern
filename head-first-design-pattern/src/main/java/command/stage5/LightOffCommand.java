package command.stage5;

public class LightOffCommand implements Command {

  private Light light;
  private boolean prevStatus;

  public LightOffCommand(Light light) {
    this.light = light;
  }

  @Override
  public void execute() {
    prevStatus = light.getStatus();
    light.off();
  }

  @Override
  public void undo() {
    if (prevStatus)
      light.on();
    else
      light.off();
  }

}
