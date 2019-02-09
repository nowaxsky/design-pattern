package strategy.complete.test;

import strategy.complete.Duck;
import strategy.complete.ModelDuck;
import strategy.complete.behavior.impl.FlyRocketPowered;

public class ModelDuckTest {

  public static void main(String[] args) {

    Duck model = new ModelDuck();
    model.performQuack();
    model.performFly();
    model.setFlyBehavior(new FlyRocketPowered());
    model.performFly();
  }

}
