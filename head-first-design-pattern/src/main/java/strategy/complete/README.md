# Strategy Pattern 策略模式

## 鴨子繼承問題

* Duck為父類別, 定義了各種鴨子可能的行為, 主要有3種: quack, swim, display.
* 有3種鴨子: MallarDuck, ReadheadDuck, RubberDuck繼承Duck.

## 策略模式

1. 變動與不變
	* 顯然stage2的設計無法解決問題, 需要把可能會更動的地方和不變的地方獨立出來.
	* 會變動的是quack和fly, 所以一樣先使用介面定義行為, 如FlyBehavior中定義fly
1. __針對介面寫程式, 不要針對實踐寫程式__
	* 不同的是由專門的類別(如: FlyWithWings, FlyNoWay)來實作各種不同的行為, 而非由各種鴨子自行實作, 目的是要將變動的部分(quack和fly)完全隔離各種鴨子類別.
	* 把quack和fly方法從Duck中抽出來, 並用performQuack和performFly替代, 並在這兩個新方法中由介面物件(如quackBehavior)來呼叫方法, 這麼做就完全不用考慮介面的物件到底是什麼, 我們只要知道該物件會知道如何實作方法(如quack)就好.
	* 把行為介面的變數放進Duck, 利用多型的方式在執行期取得正確的動作.
	* 在每個鴨子類別(如MallardDuck)的建構式中, 使用正確的行為類別(Quack和FlyWithWings)來初始化鴨子即可.
1. __多用合成, 少用繼承__
	* 合成(has-a)是將兩個類別連結起來使用, 每個鴨子都有一個(has-a)QuackBehavior和FlyBehavior.
	* 行為不是繼承而來, 而是透過行為物件合成而來.
	* 會變動的部分可以使用合成, 不會變動的部分使用繼承.

## Demo

1. Demo: 在執行期決定鴨子的行為.
1. Demo2: 透過setter變更介面的實作, 有別於之前綁死實作的作法.

## Spring框架

* spring框架中正是使用策略模式, controller層和service都被設計成介面, 以service層為例: serviceImpl中實作各種service, controller要使用時不需要知道如何實作, 並且由@Autowired決定如何初始化物件, 不需要針對實踐寫程式.
* spring boot中如果servie介面有多個實作, 可以使用`@Primary`和`@Qualifier`來區別.
* `@Primary`: 掛在實作的類別上面, 有此註解的類別會被優先注入.
* `@Qualifier`: 掛在`@Autowired`注入的介面上, 使用`@Qualifier("ImplA")`來注入ImplA類別.
