package command.stage5;

public class RemoteControlWithUndo {

  private Command[] onCommands;
  private Command[] offCommands;

  // 用來記錄前一個指令
  private Command undoCommand;

  public RemoteControlWithUndo() {
    onCommands = new Command[7];
    offCommands = new Command[7];

    Command noCommand = new NoCommand();
    for (int i = 0; i < 7; i++) {
      onCommands[i] = noCommand;
      offCommands[i] = noCommand;
    }

    // 開始前無所謂前一個指令, 所以將之設定為NoCommand
    undoCommand = noCommand;
  }

  public void setCommand(int slot, Command onCommand, Command offCommand) {
    onCommands[slot] = onCommand;
    offCommands[slot] = offCommand;
  }

  public void onButtonWasPushed(int slot) {
    onCommands[slot].execute();

    // 記錄插槽對應的指令
    undoCommand = onCommands[slot];
  }

  public void offButtonWasPushed(int slot) {
    offCommands[slot].execute();

    // 記錄插槽對應的指令
    undoCommand = offCommands[slot];
  }

  // 按下UNDO鍵
  public void undoButtonWasPushed() {

    // 呼叫各個控制器所提供的UNDO方法來還原
    undoCommand.undo();
  }

  @Override
  public String toString() {
    StringBuffer stringBuff = new StringBuffer();
    stringBuff.append("\n------ Remote Control -------\n");
    for (int i = 0; i < onCommands.length; i++) {
      stringBuff.append("[slot " + i + "] " + onCommands[i].getClass().getName() + "    "
          + offCommands[i].getClass().getName() + "\n");
    }
    return stringBuff.toString();
  }
}
