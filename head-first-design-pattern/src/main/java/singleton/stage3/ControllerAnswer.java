package singleton.stage3;

public class ControllerAnswer {

  public static void main(String[] args) {
    Thread threadA = new Thread(new ChocolateThreadAnswer(), "A");
    Thread threadB = new Thread(new ChocolateThreadAnswer(), "B");
    threadA.start();
    threadB.start();
  }
}
