package command.stage1;

public class Order {

  private Chef chef;

  // 指派廚師
  public Order(Chef chef) {
    this.chef = chef;
  }

  // 準備餐點
  public void orderUp() {
    
    // 製作漢堡
    chef.makeBurger();
  }

}
