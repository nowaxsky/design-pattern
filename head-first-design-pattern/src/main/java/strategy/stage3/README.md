# Strategy Pattern 策略模式 - 3

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

## Demo

1. 請執行Demo來測試.

## 問題

1. 建構式中出現了一個Quack具象類別的實體(new Quack()這個動作仍然算是對實踐寫程式), 是否違反原則?
1. 請利用策略模式, 新增一個鴨子吃的行為, 一般的鴨子都會吃, 但橡皮鴨不會吃.
1. 如何在執行期 __輕易地__ 改變鴨子的行為?
