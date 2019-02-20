# Facade Pattern 表象模式

## 問題

1. 極少化原則告訴我們不要太多類別捆綁在一起, 請問下面這段程式碼有沒有違反極少化原則?
	```java
	public class House {
	  WeatherStation station;
	  
	  public float getTemp() {
	    return station.getThermometer().getTemperature();
	  }
	}
	```
	* 有違反原則, 不可以再呼叫getThermometer()回傳的物件所提供的方法getTemperature(). 可以透過包裝改成呼叫station.getTemperature();	
1. 採用極少化原則有什麼缺點?
	* 極少化原則雖然減少物件之間的依賴, 但這個做法也會導致產生大量的 __包裝__ 類別, 以處理和其他物件之間的溝通, 這些包裝類別一定程度地增加了系統的複雜度.
	* 極少化原則應該適度的使用, 達到高內聚低耦合.
