package adapter.complete;

/**
 * 綠頭鴨
 * 
 * @author Mailu
 *
 */
public class MallardDuck implements Duck {

  @Override
  public void quack() {
    System.out.println("Quack!");
  }

  @Override
  public void fly() {
    System.out.println("I'm flying!");
  }

}
