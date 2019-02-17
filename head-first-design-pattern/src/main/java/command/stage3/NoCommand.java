package command.stage3;

public class NoCommand implements Command {

  @Override
  public void execute() {
    System.out.println("You're not setting command!");
  }

}
