package command.stage4;

public interface Command {

  void execute();

  // 復原
  void undo();
}
