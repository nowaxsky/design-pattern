package observer.stage2;

/**
 * 所有具象觀察者都要實踐此介面
 * 
 * @author Mailu
 *
 */
public interface Observer {

  // 當主題改變時會呼叫此方法
  void update();
}
