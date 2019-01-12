package strategy;

import strategy.behavior.impl.FlyNoWay;
import strategy.behavior.impl.Quack;

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
