package command.stage3;

public class StereoOnWithCdCommand implements Command {

  private Stereo stereo;

  public StereoOnWithCdCommand(Stereo stereo) {
    this.stereo = stereo;
  }

  // 打開的時候希望可以同時播放CD和調整音量為11
  @Override
  public void execute() {
    stereo.on();
    stereo.setCD();
    stereo.setVolume(11);
  }

}
