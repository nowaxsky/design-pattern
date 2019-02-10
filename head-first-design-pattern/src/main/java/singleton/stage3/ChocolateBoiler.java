package singleton.stage3;

public class ChocolateBoiler {

  private boolean empty;
  private boolean boiled;
  private static ChocolateBoiler uniqueInstance;

  // 一開始鍋爐是空的
  private ChocolateBoiler() {
    empty = true;
    boiled = false;
  }

  public static ChocolateBoiler getInstance() {
    if (uniqueInstance == null) {
      System.out.println("Creating unique instance of Chocolate Boiler");
      uniqueInstance = new ChocolateBoiler();
    }
    System.out.println("Returning instance of Chocolate Boiler");
    return uniqueInstance;
  }

  // 鍋爐內填入物質時, 鍋爐內必須是空的, 填入材料後empty和boild設為false
  public void fill() {
    if (isEmpty()) {
      empty = false;
      boiled = false;
      // fill the boiler with a milk/chocolate mixture
    }
  }

  // 鍋爐排出時必須是滿的且煮過(不可為空), 排出後empty設為true
  public void drain() {
    if (!isEmpty() && isBoiled()) {
      // drain the boiled milk and chocolate
      empty = true;
    }
  }

  // 煮混和物時鍋爐必須是填滿的, 並且尚未煮過, 一旦煮沸後boiled設為true
  public void boil() {
    if (!isEmpty() && !isBoiled()) {
      // bring the contents to a boil
      boiled = true;
    }
  }

  public boolean isEmpty() {
    return empty;
  }

  public boolean isBoiled() {
    return boiled;
  }
}
