package strategy.stage3;

public class MallardDuck extends Duck {

  public MallardDuck() {
    quackBehavior = new Quack();
    flyBehavior = new FlyWithWings();
  }
  
  public void display() {
    System.out.println("I'm a Mallard Duck");
  }

  public void quack() {
    // TODO Auto-generated method stub
    
  }

  public void fly() {
    // TODO Auto-generated method stub
    
  }
}
