package command.stage4;

public class LightOnCommand implements Command {

  private Light light;

  public LightOnCommand(Light light) {
    this.light = light;
  }

  @Override
  public void execute() {
    light.on();
  }

  // 取消ON, 即按下OFF
  @Override
  public void undo() {
    light.off();
  }

}
