package strategy.test;

import strategy.Duck;
import strategy.MallardDuck;

public class MallardDuckTest {

  public static void main(String[] args) {
    Duck mallard = new MallardDuck();
    mallard.performQuack();
    mallard.performFly();
  }
}
