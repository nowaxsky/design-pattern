package strategy.test;

import strategy.Duck;
import strategy.ModelDuck;
import strategy.behavior.impl.FlyRocketPowered;

public class ModelDuckTest {

  public static void main(String[] args) {

    Duck model = new ModelDuck();
    model.performQuack();
    model.performFly();
    model.setFlyBehavior(new FlyRocketPowered());
    model.performFly();
  }

}
