package strategy.behavior.impl;

import strategy.behavior.FlyBehavior;

public class FlyNoWay implements FlyBehavior {

  public void fly() {
    System.out.println("I can't fly!");
  }

}
