# Singleton Pattern 獨體模式

## 獨體模式
* 確保一個類別只有一個實體, 並給他一個存取的全域點(global point).
* 某些物件只需要一個, 如執行緒池(thread pool), 快取區(cache), 對話盒, 登錄(register)等物件, 如果這類物件製造出多個實體會導致問題.
* 獨體模式存取和全域變數一樣簡單, 但比全域變數多了一個優點: 獨體模式可以 __Lazy initialization(拖延實體化)__ .
* 使用同步化(synchronized)可以避免多執行緒時產生多個實體的問題.

## 巧克力工廠
* 有一個巧克力公司量產用的巧克力鍋爐, 請參考ChocolateBoiler.
* 鍋爐使用的方法請參考程式內註解.

## 多執行緒同步化問題
1. 使用同步化可以避免多執行緒時產生多個實體的問題, 但是會降低效率, 因為只有第一次執行方法(即uniqueInstance為空)時需要使用, 當存在之後則不需要同步化了, 是否有改善方法? 有三種作法可參考:
	1. 僅使用synchronized且不做其他事: 如果效能的負擔是可以接受的, 即getInstance()並不是很常呼叫, 則可以考慮什麼事都不做, 雖然如此但使用同步化效能還是會嚴重下降.
	1. 不用拖延實體化: 若應用程式一定會建立並使用實體, 則可以考慮在執行期就建立獨體, 放棄拖延實體化, 就不需要使用synchronized, 程式如下:
			```java
			public static Singleton uniqueInstance = new Singleton();
			
			private Singleton() {}
			
			public static Singleton getInstance() {
				return uniqueInstance;
			}
			```
	1. __Double-checked locking(雙重檢查上鎖)__ :見下一節.

## Double-checked locking(雙重檢查上鎖)
* 參考Singleton.
* 實踐只有第一次會進入同步區塊, 之後不會使用同步化的做法.
* 進入同步區塊後如果仍為uniqueInstance仍為null才建立實體.
* 為了避免多個執行緒間存在變數不同步的問題, uniqueInstance需要使用volatile關鍵字來讓所有執行緒資料一致.
* 若沒有使用volatile關鍵字則可能在第一個執行緒A產生完實體且跳出同步區塊後, 執行緒B進入同步區塊, 雖然此時有第二層if判斷, 但沒使用volatile關鍵字則可能執行緒B讀取的uniqueInstance仍為空, 還是會再產生一個實體, 所以雙重檢查上鎖必須使用volatile.
* __注意: Java < 1.4的版本無法使用此方法, 因為沒有支援volatile.__

## 問題
1. 建立一個類別把所有的方法和變數都定義為靜態, 直接把這個類別當作一個獨體, 為何還需要獨體模式?
1. 如果有2個Class loader(類別載入器), 會不會導致創造各自的獨體?
1. 能不能繼承獨體類別?
1. 為何全域變數比獨體模式差?
