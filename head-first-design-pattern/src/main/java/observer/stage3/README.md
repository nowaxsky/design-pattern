# Observer Pattern 觀察者模式 - 3

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

## Demo

* Demo: 實踐觀察者模式.
* Demo2: 加入新的觀察者HeatIndexDisplay, 無須修改任何程式碼.
	
## 問題

1. 在Observer中是直接把數據當作參數給觀察者, 如果未來資料的種類和個數發生改變, 該如何因應呢?
1. update()是最適合呼叫display()的地方嗎?
1. 在布告板中的主題物件似乎註冊完就沒有作用了, 為何要用變數記錄下來?
1. __主題和觀察者之間, 為什麼一定要是主題通知觀察者, 而非由觀察者向主題索取資料呢?__
1. 請新增一個MyDisplay, 當資料有異動時, 印出氣象站所提供的所有原始資料(temp, humidity, pressure). 
1. 請實作讓ForecastDisplay取消註冊.
1. 請新增一個主題StockData, 並滿足下列條件:
	* 當資料有異動時通知CurrentConditionsDisplay和StatisticsDisplay.
	* CurrentConditionsDisplay接到通知時印出當下的成交價(price).
	* StatisticsDisplay收到通知時印出今日最低成交價, 平均成交價, 和最高成交價.
