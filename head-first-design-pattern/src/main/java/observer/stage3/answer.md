# Observer Pattern 觀察者模式

## 問題
1. 在Observer中是直接把數據當作參數給觀察者, 如果未來資料的種類和個數發生改變, 該如何因應呢?
	* 觀察者透過getter向主題索取資料可以解決, 見observer.complete.builtIn.
1. update()是最適合呼叫display()的地方嗎?
	* 這個簡單的例子中在update()中呼叫display()是很合理的, 但確實有更好的地方, 待MVC模式介紹.
1. 在布告板中的主題物件似乎註冊完就沒有作用了, 為何要用變數記錄下來?
	* 的確如此, 但如果之後需要取消註冊, 則記住主題會比較方便.
1. __主題和觀察者之間, 為什麼一定要是主題通知觀察者, 而非由觀察者向主題索取資料呢?__
	* 主題通知觀察者: 若由觀察者每次想要資料時都呼叫主題, 則可能需要呼叫多次才能取得所有資料, 但由主題主動通知則是資料異動時一次通知觀察者完整的資料. 可以節省呼叫的次數.
	* 觀察者透過getter向主題索取: 並不是每個觀察者都需要所有的資料, 若某些觀察者只需要部分資料, 使用次方法比較合理. 另外未來如果主題中的狀態有所變化, 則不需要修改Observer介面, 只需要提供更多的getter方法讓觀察者取得新的狀態即可.
	* 這兩種作法各有優劣, 故Java內建的Observer模式兩種作法都有支援.
1. 請新增一個MyDisplay, 當資料有異動時, 印出氣象站所提供的所有原始資料(temp, humidity, pressure).
	* 請參考complete.MyDisplay.
1. 請實作讓ForecastDisplay取消註冊.
	* 請參考complete.Demo, complete.ForecastDisplay, complete.WeatherData.
1. 請新增一個主題StockData, 並滿足下列條件:
	* 當資料有異動時通知CurrentConditionsDisplay和StatisticsDisplay.
	* CurrentConditionsDisplay接到通知時印出當下的成交價(price).
	* StatisticsDisplay收到通知時印出今日最低成交價, 平均成交價, 和最高成交價.
	* 請參考complete.