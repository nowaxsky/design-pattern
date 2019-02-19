package adapter.stage1;

public class Demo {

  public static void main(String[] args) {
    MallardDuck duck = new MallardDuck();
    WildTurkey turkey = new WildTurkey();
    
    TurkeyAdapter turkeyAdapter = new TurkeyAdapter(turkey);
    
    System.out.println("\n---Real turkey testing---\n");
    turkey.gobble();
    turkey.fly();
    
    System.out.println("\n---Duck test1---\n");
    testDuck(duck);
    
    System.out.println("\n---Duck test2---\n");
    testDuck(turkeyAdapter);
  }

  private static void testDuck(Duck duck) {
    duck.quack();
    duck.fly();
  }
}
