package singleton.stage3;

public class ChocolateThread implements Runnable {

  @Override
  public void run() {
    System.out.println(Thread.currentThread().getName() + " Chocolate Thread started!");
    
    ChocolateBoiler boiler = ChocolateBoiler.getInstance();
    boiler.fill();
    boiler.boil();
    boiler.drain();
  }

}
