package strategy.complete;

public class ModelDuck extends Duck {

  public ModelDuck() {
    quackBehavior = new Quack();
    flyBehavior = new FlyNoWay();
    eatBehavior = new EatNoWay();
  }

  @Override
  public void display() {
    System.out.println("I'm a model duck!");
  }
}
