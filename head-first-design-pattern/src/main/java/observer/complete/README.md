# Observer Pattern 觀察者模式

## 氣象監測系統
* 氣象站有3個感測器, 分別監測溫度, 濕度和氣壓.
* WeatherData物件可以從氣象站使用getter方法取得資料.
* 取得新資料時, 要更新3個顯示布告板, 分別為CurrentConditionsDisplay, StatisticsDisplay, ForecastDisplay.

## 觀察者模式

![Alt text](../resource/observer.png "Observer Pattern Class Diagram")

* 定義: __物件之間的一對多關係, 當一個物件改變狀態, 其他相依者會收到通知並自動被更新.__
* 觀察者模式可分為主題和觀察者, 主題是具有狀態的物件且能控制狀態; 觀察者可使用這些狀態但不能控制狀態, 故主題對觀察者為一對多關係.
* 主題是真正擁有資料的人, 觀察者依賴主題來更動, 如此不會讓所有人都去控制資料造成混亂.
* 每個布告板其實是有差異的, 但他們同時實踐同一介面, 有了統一方法update, 讓主題在需要通知觀察者時有一個統一的方法.
* 主要優點:
	1. 可以任意地加入新觀察者, 且主題的程式碼無須修改.
	1. 片面地修改主題或觀察者, 並不會影響另一者, 只要兩者之間的介面仍被遵守即可.
	
## Publish/Subscribe Pattern(Pub/Sub) 發佈/訂閱模式

* 定義: __用於建立一些事件驅動(Event-driven)或訊息傳遞協議, 訊息導向中介軟體(MOM)(e.g., MQTT, XMPP, SNS, JMS)之訊息模式。__
* Pub/Sub會在發布者與訂閱者之間, 透過中間人(broker)來進行解耦.
* __時間解耦__ : 訊息傳遞, 可以是同步(synchronous)或非同步(asynchronous). 也就是發佈訊息時, 訂閱者不一定會在線上.
* 因此大部分Pub/Sub透過非同步的方式使訊息的傳遞不需等待回應, 不依賴對方為等待接收(blocking receive)的狀態, 透過先存再送 (store-and-forward)的機制, 確保訊息將可靠地送達.
* 有些人認為觀察者模式是一對多且sync, Pub/Sub是多對多且async, 這是錯誤的, 觀察者一樣能做到多對多且async, Pub/Sub也可以一對多. 
* __觀察者模式和Pub/Sub最大的差異在於Pub/Sub有一個中介者且多數為非同步.__
* https://notfalse.net/11/pub-sub-pattern.

## Demo

* Demo: 實踐觀察者模式, 且動態訂閱主題或取消註冊主題.
* Demo2: 多主題範例, 總共有2個主題StockData和WeatherData, 由於主題超過一個, 需要知道是從哪個主題出現的update以作對應處理, 故Observer.update()參數中需要帶入主題物件.
