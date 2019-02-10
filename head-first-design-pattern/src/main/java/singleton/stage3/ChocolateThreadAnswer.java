package singleton.stage3;

public class ChocolateThreadAnswer implements Runnable {

  @Override
  public void run() {
    System.out.println(Thread.currentThread().getName() + " Chocolate Thread started!");
    
    ChocolateBoilerAnswer boiler = ChocolateBoilerAnswer.getInstance();
    boiler.fill();
    boiler.boil();
    boiler.drain();
  }

}
