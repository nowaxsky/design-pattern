# 觀察者模式-Java內建

## 氣象監測系統
* 氣象站有3個感測器, 分別監測溫度, 濕度和氣壓.
* WeatherData物件可以從氣象站使用getter方法取得資料.
* 取得新資料時, 要更新3個顯示布告板, 分別為CurrentConditionsDisplay, StatisticsDisplay, ForecastDisplay.

## 觀察者模式
* 定義物件之間的一對多關係, 當一個物件改變狀態, 其他相依者會收到通知並自動被更新.
* 觀察者模式可分為主題和觀察者, 主題是具有狀態的物件且能控制狀態; 觀察者可使用這些狀態但不能控制狀態, 故主題對觀察者為一對多關係.
* 主題是真正擁有資料的人, 觀察者依賴主題來更動, 如此不會讓所有人都去控制資料造成混亂.
* 每個布告板其實是有差異的, 但他們同時實踐同一介面, 有了統一方法update, 讓主題在需要通知觀察者時有一個統一的方法.
* 主要優點:
	1. 可以任意地加入新觀察者, 且主題的程式碼無須修改.
	1. 片面地修改主題或觀察者, 並不會影響另一者, 只要兩者之間的介面仍被遵守即可.

## Java內建觀察者模式
* Observable(可觀察者)即原來的主題, 唯一不同的是Observable是類別並非介面, 透過繼承可以使用API.
* Observable提供addObserver, deleteObserver, notifyObservers, 和setChanged四種API.
* Observer和之前我們自己定義的觀察者完全相同, 同樣提供update介面.
* 使用方法:
	* 如何成為觀察者? 實踐Observer, 呼叫Observable物件的addObserver方法註冊, 不想當觀察者時呼叫deleteObserver方法.
	* 可觀察者如何送出通知? 繼承Observable產生可觀察者類別(主題類別), 然後以下二步驟:
		1. 呼叫setChanged(), 標記狀態已經改變的事實.
		1. 呼叫notifyObservers()或notifyObservers(Object arg)任一個
	* 觀察者如何接收通知? 觀察者透過實踐內建Observe介面中的update(Observable o, Object arg), 第一個參數可以辨識從哪一個主題通知該觀察者.
	* notifyObservers(Object arg)中的arg可以傳送任何的資料物件, 此arg正式update(Observable o, Object arg)的arg傳入值. 若使用無參數的notifyObservers()則update傳入的arg為null.
	* 如果在notifyObservers()前沒有先呼叫setChanged(), 觀察者並不會被通知.
	* setChanged()是控制changed旗標的方法, 使用後設為changed = true才會通知觀察者. 這是一種保持彈性的作法, 應用的場合是有時候並不是資料一更新就要立刻通知觀察者, 就可以透過此方法來控制頻率.
	* 另外有clearChanged(), 設changed = false; hasChanged()取得changed旗標的狀態值.
* __內建觀察者模式的缺點:__
	1. Observable是類別而非介面, 所以無法多重繼承. 且Observable沒有實踐任何一個介面, 故也無法建立自己的實踐.
	1. Observable保護了關鍵的方法setChanged()(定義為protected), 也就是除非繼承Observable否則無法使用該方法, 也無法利用合成的方法(設計一個類別內含Observable實體變數)呼叫此API.
* 內建觀察者模式使用場合: 若能夠繼承Observable, 則Observable__可能__符合需求, 否則應該自己實踐整套觀察者模式.

## Test
* PushTest
	1. 實踐Java內建觀察者Push模式, 由可觀察者通知觀察者.
	1. 可觀察者透過傳遞物件TempAndHumidity通知觀察者.
	1. 主要缺點: 狀態增減時需要修改物件, 且並不是每個觀察者都需要所有的狀態(CurrentConditionsDisplayPush不需要pressure).
* PullTest
	1. 實踐Java內建觀察者Pull模式, 由可觀察者通知觀察者.
	1. 觀察者被通知更新後, 主動呼叫可觀察者的getter方法來取得狀態
	1. 如果狀態增減的話, 觀察者不需要修改, 但需要呼叫多次可觀察者的getter來取得資料.
* __注意: 不管使用Push或Pull, 印出的結果都和自製的觀察者模式不同, 原因在於Java內建Observable通知的順序不同.__

## 應用觀察者模式的Java
* JavaBeans
* Swing
* RMI
* ...