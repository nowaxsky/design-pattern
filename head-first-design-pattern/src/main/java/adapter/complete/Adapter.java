package adapter.complete;

public class Adapter implements OldInterface, NewInterface {

  private OldInterface oldInterface;
  private NewInterface newInterface;

  public Adapter(OldInterface oldInterface) {
    super();
    this.oldInterface = oldInterface;
  }

  public Adapter(NewInterface newInterface) {
    super();
    this.newInterface = newInterface;
  }

  @Override
  public void newMethod1() {
    oldInterface.oldMethod1();
  }

  @Override
  public void newMethod2() {
    oldInterface.oldMethod2();
  }

  @Override
  public void oldMethod1() {
    newInterface.newMethod1();
  }

  @Override
  public void oldMethod2() {
    newInterface.newMethod2();
  }


}
