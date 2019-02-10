# 策略模式-3

## 鴨子繼承問題
* Duck為父類別, 定義了各種鴨子可能的行為, 主要有3種: quack, swim, display.
* 有3種鴨子: MallarDuck, ReadheadDuck, RubberDuck繼承Duck.

## 問題
1. 如果今天想要增加方法在Duck中, 如fly, 則影響層面過大, 因為有些鴨子並不會飛(RubberDuck), 必須要覆寫後才能用, 難以維護, 如何改善?
	* 使用介面, 把可能不同的行為抽出來(Quackable, Flyable), 讓各個鴨子自己去實作.
1. 使用介面可以避免忘記覆寫產生的錯誤, 但卻完全無法再利用程式碼, 全部都要再寫過一次, 如何改善?
	* 需要針對介面產生一個行為物件來實踐介面, 而非鴨子自行實踐介面.
1. 建構式中出現了一個Quack具象類別的實體(new Quack()這個動作仍然算是對實踐寫程式), 是否違反原則?
	* 暫時的, 後面章節會介紹更多方法來解決, 但現在的做法雖然把行為設定成具體的類別, 但還是可以在執行期輕易地改變, 有別於之前綁死的做法.
	* 目前只是初始化實體變數的做法還不夠彈性罷了.
1. 如何在執行期__輕易地__改變鴨子的行為?
	* 在Duck中增加setter, 可以透過變更介面的實作, 在執行期動態設定鴨子的行為.