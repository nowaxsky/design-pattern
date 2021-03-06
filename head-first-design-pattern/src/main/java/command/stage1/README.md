# Command Pattern 命令模式 - 1

## 萬用遙控器

* 設計一個遙控器可以控制7種不同的家電, 如電燈, 風扇, 熱水器等.
* 每個家電的控制方法為在遙控器的插槽內安裝其控制器, 每個控制器不同.
* 這台遙控器上有14個按鈕, 分別為控制7種家電的開關ON和OFF.
* 遙控器設有一個全體共用的復原鈕(UNDO), 會復原最後一個按鈕的動作.

## 餐廳的運作

![Alt text](../resource/restaurant.png "Restaurant")

* 三個角色:
	1. 顧客
	1. 服務生
	1. 廚師
	
* 餐廳作業流程:
	1. 顧客寫菜單(餐點資訊和廚師資訊): `new Order(chef)`
	1. 服務生收菜單: `waiter.takeOrder(order)`
	1. 服務生拿單去廚房 `waiter.deliver()`
	1. 準備餐點: `order.orderUp()`
	1. 廚師製作漢堡: `chef.makeBurger()`
	1. 料理完成: 印出"Here is your burger!"

## Demo

* 執行Demo來觀察餐廳.

## 問題

1. 參考Light, 並設計掛載電燈控制器的萬能遙控器的物件: LightOnCommand, RemoteControl. 請用Demo來測試.
1. 請說明遙控器問題和餐廳運作的對應關係:

Restaurant|RemoteControl
--|--
Client|?
Chef|?
Waiter|?
Order|?
new Order()|?
OrderUp()|?
takeOrder()|?
deliver()|?