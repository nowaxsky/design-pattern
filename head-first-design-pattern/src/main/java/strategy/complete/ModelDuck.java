package strategy.complete;

import strategy.complete.behavior.impl.FlyNoWay;
import strategy.complete.behavior.impl.Quack;

public class ModelDuck extends Duck {

  public ModelDuck() {
    quackBehavior = new Quack();
    flyBehavior = new FlyNoWay();
  }

  @Override
  public void display() {
    System.out.println("I'm a model duck!");
  }
}
