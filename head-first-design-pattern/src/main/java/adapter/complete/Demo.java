package adapter.complete;

public class Demo {

  public static void main(String[] args) {
    MallardDuck duck = new MallardDuck();
    WildTurkey turkey = new WildTurkey();
    
    DuckAdapter duckAdapter = new DuckAdapter(duck);
    
    System.out.println("\n---Turkey test1---\n");
    testTurkey(turkey);
    
    System.out.println("\n---Turkey test2---\n");
    testTurkey(duckAdapter);
  }

  private static void testTurkey(Turkey turkey) {
    turkey.gobble();
    turkey.fly();
  }
}
