package singleton.stage3;

public class Controller {

  public static void main(String[] args) {
    Thread threadA = new Thread(new ChocolateThread(), "A");
    Thread threadB = new Thread(new ChocolateThread(), "B");
    threadA.start();
    threadB.start();
  }
}
