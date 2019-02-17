package command.stage1;

public class Waiter {

  private Order order;

  public Waiter() {}

  // 收單
  public void takeOrder(Order order) {
    this.order = order;
  }

  // 拿單給廚房
  public void deliver() {
    order.orderUp();
  }
}
