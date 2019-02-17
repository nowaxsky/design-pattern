package command.stage2;

public class RemoteControl {

  private Command slot;

  public RemoteControl() {}

  public void setCommand(Command command) {
    this.slot = command;
  }

  public void buttonWasPushed() {
    slot.execute();
  }
}
