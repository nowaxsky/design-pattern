package observer.stage2;

public class ObserverA implements Observer {

  // 觀察者A需要向主題A註冊, 以便被更新
  public ObserverA(SubjectA subjectA) {
    subjectA.registerObserver(this);
  }

  @Override
  public void update() {
    // TODO Auto-generated method stub

  }

}
