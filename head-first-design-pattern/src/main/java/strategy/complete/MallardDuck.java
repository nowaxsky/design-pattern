package strategy.complete;

import strategy.complete.behavior.impl.FlyWithWings;
import strategy.complete.behavior.impl.Quack;

public class MallardDuck extends Duck {

  /*
   * 初始化時決定鴨子的行為
   */
  public MallardDuck() {
    quackBehavior = new Quack();
    flyBehavior = new FlyWithWings();
  }
  
  @Override
  public void display() {
    System.out.println("I'm a Mallard Duck");
  }

}
