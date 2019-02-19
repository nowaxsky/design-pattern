# Strategy Pattern 策略模式 - 1

## 鴨子繼承問題
* Duck為父類別, 定義了各種鴨子可能的行為, 主要有3種: quack, swim, display.
* 有3種鴨子: MallarDuck, ReadheadDuck, RubberDuck繼承Duck.

## 問題
1. 如果今天想要增加方法在Duck中, 如fly, 則影響層面過大, 因為有些鴨子並不會飛(RubberDuck), 必須要覆寫後才能用, 難以維護, 如何改善?
	* 使用介面, 把可能不同的行為抽出來(Quackable, Flyable), 讓各個鴨子自己去實作, 請參考stage2.
