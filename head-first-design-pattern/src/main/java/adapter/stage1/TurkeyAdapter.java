package adapter.stage1;

public class TurkeyAdapter implements Duck {

  private Turkey turkey;

  public TurkeyAdapter(Turkey turkey) {
    super();
    this.turkey = turkey;
  }

  @Override
  public void quack() {
    turkey.gobble();
  }

  // 此處模擬鴨子飛行1次火雞要飛行5次
  @Override
  public void fly() {
    for (int i = 0; i < 5; i++) {
      turkey.fly();
    }
  }

}
