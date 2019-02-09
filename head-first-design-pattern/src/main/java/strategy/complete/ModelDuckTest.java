package strategy.complete;

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
