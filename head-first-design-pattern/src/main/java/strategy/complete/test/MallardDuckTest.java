package strategy.complete.test;

import strategy.complete.Duck;
import strategy.complete.MallardDuck;

public class MallardDuckTest {

  public static void main(String[] args) {
    Duck mallard = new MallardDuck();
    mallard.performQuack();
    mallard.performFly();
  }
}
