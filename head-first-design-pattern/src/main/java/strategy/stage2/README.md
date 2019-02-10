# 策略模式-2

## 初始設定
* Duck為父類別, 定義了各種鴨子可能的行為, 主要有3種: quack, swim, display.
* 有3種鴨子: MallarDuck, ReadheadDuck, RubberDuck繼承Duck.

### 問題-1
* 如果今天想要增加方法在Duck中, 如fly, 則影響層面過大, 因為有些鴨子並不會飛(RubberDuck), 必須要覆寫後才能用, 難以維護.

### 解決-1
* 使用介面, 把可能不同的行為抽出來(Quackable, Flyable), 讓各個鴨子自己去實作

### 問題-2
* 這樣做可以避免忘記覆寫產生的錯誤, 但卻完全無法再利用程式碼, 全部都要再寫過一次