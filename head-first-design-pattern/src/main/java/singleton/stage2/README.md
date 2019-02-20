# Singleton Pattern 獨體模式 - 2

## 獨體模式

* 確保一個類別只有一個實體, 並給他一個存取的全域點(global point).
* 某些物件只需要一個, 如執行緒池(thread pool), 快取區(cache), 對話盒, 登錄(register)等物件, 如果這類物件製造出多個實體會導致問題.
* 獨體模式存取和全域變數一樣簡單, 但比全域變數多了一個優點: 獨體模式可以 __Lazy initialization(拖延實體化)__ .

## 巧克力工廠

* 有一個巧克力公司量產用的巧克力鍋爐, 請參考ChocolateBoiler.
* 鍋爐使用的方法請參考程式內註解.

## 問題

1. 請把ChocolateBoiler設計成singleton模式.
