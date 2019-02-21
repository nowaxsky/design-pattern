package strategy.complete;

public class Eat implements EatBehavior {

  @Override
  public void eat() {
    System.out.println("Fuck off! I'm eating!");
  }

}
