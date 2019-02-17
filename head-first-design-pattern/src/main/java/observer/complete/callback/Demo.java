package observer.complete.callback;

public class Test {

  public static void main(String[] args) {

    ConcreteSubject subject = new ConcreteSubject();

    /*
     * 創建一個實體回調函數, 如觀察者模式中的實體觀察者(如CurrentConditionsDisplay)
     */
    Callback callback = new Callback() {
      @Override
      public void onCall() {
        System.out.println("After calling callback function.");
      }
    };

    // 註冊事件(觀察者註冊)
    subject.register(callback);

    // 直接觸發更新
    subject.call();
  }

}
