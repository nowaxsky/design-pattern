package strategy.complete.behavior.impl;

import strategy.complete.behavior.FlyBehavior;

public class FlyNoWay implements FlyBehavior {

  public void fly() {
    System.out.println("I can't fly!");
  }

}
