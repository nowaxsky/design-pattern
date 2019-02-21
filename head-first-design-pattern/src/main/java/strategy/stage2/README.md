# Strategy Pattern 策略模式 - 2

## 鴨子繼承問題

* Duck為父類別, 定義了各種鴨子可能的行為, 主要有3種: quack, swim, display.
* 有3種鴨子: MallarDuck, ReadheadDuck, RubberDuck繼承Duck.

## 問題

1. 使用介面可以避免忘記覆寫產生的錯誤, 但卻完全無法再利用程式碼, 全部都要再寫過一次, 如何改善?