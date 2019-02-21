package observer.stage3;

/**
 * 所有具象觀察者都要實踐此介面
 * 
 * @author Mailu
 *
 */
public interface Observer {

  // 當氣象數據發生改變時, 主題會把這些狀態當作方法參數傳給觀察者
  void update(float temp, float humidity, float pressure);
}
