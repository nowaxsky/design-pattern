package observer.stage2;

public class SubjectA implements Subject {

  private String state;

  @Override
  public void notifyObserver() {
    // TODO Auto-generated method stub

  }

  @Override
  public void registerObserver(Observer o) {
    // TODO Auto-generated method stub

  }

  @Override
  public void removeObserver(Observer o) {
    // TODO Auto-generated method stub

  }

  // 主題可能有一些用來設定和取得狀態的方法
  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }


}
