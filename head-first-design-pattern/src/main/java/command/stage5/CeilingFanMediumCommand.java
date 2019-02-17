package command.stage5;

public class CeilingFanMediumCommand implements Command {

  private CeilingFan ceilingFan;
  private int prevSpeed;

  public CeilingFanMediumCommand(CeilingFan ceilingFan) {
    this.ceilingFan = ceilingFan;
  }

  @Override
  public void execute() {

    // 改變速度前, 需要先將之前的狀態記錄下來
    prevSpeed = ceilingFan.getSpeed();
    ceilingFan.medium();
  }

  @Override
  public void undo() {
    switch (prevSpeed) {
      case CeilingFan.HIGH:
        ceilingFan.high();
        break;
      case CeilingFan.MEDIUM:
        ceilingFan.medium();
        break;
      case CeilingFan.LOW:
        ceilingFan.low();
        break;
      default:
        ceilingFan.off();
        break;
    }
  }
}
