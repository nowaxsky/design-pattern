package strategy.stage3;

import strategy.stage3.behavior.FlyBehavior;
import strategy.stage3.behavior.QuackBehavior;

/**
 * 把quack和fly方法抽出來放到行為介面中
 * 
 * @author Mailu
 *
 */
public class Duck {

  /*
   * 放進行為介面的變數, 利用多型的方式在執行期取得正確的動作
   */
  QuackBehavior quackBehavior;
  FlyBehavior flyBehavior;
  
  public void swim() {

  }

  protected void display() {

  }
  
  public void performQuack() {
    quackBehavior.quack();
  }
  
  public void performFly() {
    flyBehavior.fly();
  }
}
