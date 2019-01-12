package strategy.stage3;

import strategy.stage3.behavior.FlyWithWings;
import strategy.stage3.behavior.Quack;

public class MallardDuck extends Duck {

  public MallardDuck() {
    quackBehavior = new Quack();
    flyBehavior = new FlyWithWings();
  }
  
  public void display() {
    System.out.println("I'm a Mallard Duck");
  }

  public void quack() {
    // TODO Auto-generated method stub
    
  }

  public void fly() {
    // TODO Auto-generated method stub
    
  }
}
