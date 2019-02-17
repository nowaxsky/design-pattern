package command.complete;

import java.util.Stack;

public class StereoOnWithCdCommand implements Command {

  private Stereo stereo;
  private Stack<Integer> statusStack;

  public StereoOnWithCdCommand(Stereo stereo) {
    this.stereo = stereo;
    statusStack = new Stack<>();
  }

  @Override
  public void execute() {
    statusStack.push(stereo.getStatus());
    stereo.on();
    stereo.setCD();
    stereo.setVolume(11);
  }

  @Override
  public void undo() {
    int status = statusStack.empty() ? 0 : statusStack.pop();
    if (status >= 50) {
      stereo.setVolume(status - 50);
      return;
    }
    switch (status) {
      case Stereo.ON:
        stereo.on();
        break;
      case Stereo.SET_CD:
        stereo.setCD();
        break;
      case Stereo.SET_DVD:
        stereo.setDVD();
        break;
      case Stereo.SET_RADIO:
        stereo.setRadio();
        break;
      default:
        stereo.off();
        break;
    }
    stereo.off();
  }

}
