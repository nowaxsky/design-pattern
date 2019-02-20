package strategy.complete;

public class Demo2 {

  public static void main(String[] args) {

    Duck model = new ModelDuck();
    model.performQuack();
    model.performEat();
    model.performFly();
    model.setFlyBehavior(new FlyRocketPowered());
    model.performFly();
  }

}
