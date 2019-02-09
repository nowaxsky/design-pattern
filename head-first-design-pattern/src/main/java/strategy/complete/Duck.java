package strategy;

import strategy.behavior.FlyBehavior;
import strategy.behavior.QuackBehavior;

/**
 * 鴨子父類別, 所有鴨子均繼承
 * 
 * @author Mailu
 *
 */
public class Duck {

  /*
   * 放進行為介面的變數, 利用多型的方式在執行期取得正確的動作
   */
  protected QuackBehavior quackBehavior;
  protected FlyBehavior flyBehavior;
  
  /*
   * 所有鴨子都共有的行為
   */
  public void swim() {
    System.out.println("All ducks float, even decoys!");
  }
  
  public void display() {
    
  }
  
  /*
   * 以下為鴨子子類別可能變動的行為
   */
  public void performQuack() {
    quackBehavior.quack();
  }
  
  public void performFly() {
    flyBehavior.fly();
  }
  
  /*
   * 透過變更介面的實作, 可在執行期動態設定鴨子的行為
   */
  public void setQuackBehavior(QuackBehavior quackBehavior) {
    this.quackBehavior = quackBehavior;
  }
  
  public void setFlyBehavior(FlyBehavior flyBehavior) {
    this.flyBehavior = flyBehavior;
  }
  
}
