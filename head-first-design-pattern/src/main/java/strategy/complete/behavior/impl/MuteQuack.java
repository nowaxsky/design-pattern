package strategy.complete.behavior.impl;

import strategy.complete.behavior.QuackBehavior;

public class MuteQuack implements QuackBehavior {

  public void quack() {
    System.out.println("<< Silence >>");    
  }

}
