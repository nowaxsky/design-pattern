package adapter.complete;

public class Demo2 {

  public static void main(String[] args) {
    OldInterface oldImpl = new OldImpl();
    NewInterface newImpl = new NewImpl();
    
    Adapter fakeOld = new Adapter(newImpl);
    testOld(fakeOld);
    
    Adapter fakeNew = new Adapter(oldImpl);
    testNew(fakeNew);
  }
  
  private static void testOld(OldInterface oldImpl) {
    oldImpl.oldMethod1();
    oldImpl.oldMethod2();
  }
  
  private static void testNew(NewInterface newImpl) {
    newImpl.newMethod1();
    newImpl.newMethod1();
  }
}
