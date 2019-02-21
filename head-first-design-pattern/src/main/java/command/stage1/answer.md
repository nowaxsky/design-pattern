# Command Pattern 命令模式 - 1

## 問題
1. 參考Light, 並設計掛載電燈控制器的萬能遙控器的物件: LightOnCommand, RemoteControl. 請用Demo來測試.
	* 參考stage2.
1. 請說明遙控器問題和餐廳運作的對應關係:

Restaurant|RemoteControl
--|--
Client|You
Chef|Light, ...
Waiter|RemoteControl
Order|Command(LightOnCommand, LightOffCommand, ...)
new Order()|new Command()
OrderUp()|execute()
takeOrder()|setCommand()
deliver()|buttonWasPushed()