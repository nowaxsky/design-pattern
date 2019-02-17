package observer.complete.callback;

/**
 * 即觀察者模式的實體主體(如WeatherData)
 * 
 * @author Mailu
 *
 */
public class ConcreteSubject {

  private Callback callback;

  // 註冊事件(註冊觀察者)
  public void register(Callback callback) {
    this.callback = callback;
  }

  public void call() {
    System.out.println("Before calling callback function.");
    callback.onCall();
  }

}
