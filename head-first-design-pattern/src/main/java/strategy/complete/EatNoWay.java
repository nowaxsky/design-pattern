package strategy.complete;

public class EatNoWay implements EatBehavior {

  @Override
  public void eat() {
    System.out.println("Huh? What is eating?");
  }

}
