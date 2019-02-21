package strategy.complete;

public class Demo {

  public static void main(String[] args) {
    Duck mallard = new MallardDuck();
    mallard.performQuack();
    mallard.performFly();
    mallard.performEat();
  }
}
