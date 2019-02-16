package command.stage4;

public class LightOffCommand implements Command {

  private Light light;

  public LightOffCommand(Light light) {
    this.light = light;
  }

  @Override
  public void execute() {
    light.off();
  }

  // 要取消OFF, 即按下ON
  @Override
  public void undo() {
    light.on();
  }

}
