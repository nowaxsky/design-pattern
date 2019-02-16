package command.stage1;

public class Demo {

  public static void main(String[] args) {
    
    // 服務生可以收單
    Waiter waiter = new Waiter();
    
    // 廚師可以做料理
    Chef chef = new Chef();
    
    // 建立訂單並讓廚師做料理
    Order order = new Order(chef);
    
    
    // 服務生收單
    waiter.takeOrder(order);
    
    // 服務生拿單到廚房
    waiter.deliver();
  }
  
  
}
