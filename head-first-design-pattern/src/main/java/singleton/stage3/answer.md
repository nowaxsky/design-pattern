# Singleton Pattern 獨體模式 - 3

## 問題
1. 執行Controller, 可以發現雖然都是使用getInstance()方法來呼叫, 但還是產生超過一個實體, 為什麼?
	* Controller中有兩個執行緒A, B. 假設執行緒A檢查無實體後 `if (uniqueInstance == null)` , 在產生新物件 `uniqueInstance = new ChocolateBoiler();` 前, 執行緒B進入 `if (uniqueInstance == null)` 的時候仍無實體, 故B也會創建一個實體, 導致產生兩個實體.
1. ChocolateBoiler在多執行緒時產生超過一個實體, 要如何解決?
	* 使用synchronized(){}區塊, 請執行ControllerAnswer.
	* ChocolateBoilerAnswer使用靜態同步方法, 讓只有一個執行緒可以拜訪getInstance().