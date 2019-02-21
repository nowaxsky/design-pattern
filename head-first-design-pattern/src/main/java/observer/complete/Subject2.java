package observer.complete;

/**
 * 所有具象主題都要實踐此介面
 * 
 * @author Mailu
 *
 */
public interface Subject2 {

  // 註冊觀察者
  void registerObserver(Observer2 o);

  // 移除觀察者
  void removeObserver(Observer2 o);

  // 主題變動時, 更新目前所有的觀察者
  void notifyObserver();
}
