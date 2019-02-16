# Command Pattern 命令模式 - 5

## 萬用遙控器
* 設計一個遙控器可以控制7種不同的家電, 如電燈, 風扇, 熱水器等.
* 每個家電的控制方法為在遙控器的插槽內安裝其控制器, 每個控制器不同.
* 這台遙控器上有14個按鈕, 分別為控制7種家電的開關ON和OFF.
* 遙控器設有一個全體共用的復原鈕(UNDO), 會復原最後一個按鈕的動作.

## 命令模式

![Alt text](../resource/command.png "Command Pattern Class Graph")

* 定義: __將請求封裝成物件, 以便使用不同的請求, 佇列, 或者日誌, 參數化其他物件. 命令模式也支援可復原的作業.__
* 命令物件 __封裝一個請求__ ,命令物件中記錄某個接收者的一組動作, 只露出一個execute()方法, 當此方法被呼叫時接收者會進行動作.
* 從外面來看, 其他物件不知道究竟誰是接收者, 進行了什麼動作, 只知道呼叫execute()就能達成目的. 如: 遙控器根本不用知道電器是誰, 只要控制器實踐Command介面即可; 客人不用知道廚師是誰, 只要填菜單請服務員過來收就好.
* 餐廳, 遙控器, 命令模式對照關係表如下:

Restaurant|RemoteControl|Command Pattern
--|--|--
Client|You|Client
Chef|Light, Garage, ...|Receiver
Waiter|RemoteControl|Invoker
Order|Command(LightOnCommand, LightOffCommand, ...)|ConcreteCommand
new Order()|new Command()|new Command()
OrderUp()|execute()|execute()
takeOrder()|setCommand()|setCommand()
deliver()|buttonWasPushed()|triggerMethod()

## 介面方法
* 可以新增介面方法(復原), 並讓所有的命令(控制器)實作後以供調用者(遙控器)呼叫.
* 該方法將會橫跨各種命令, 若方法(復原)需要記錄狀態, 可以先將是何種命令記錄在調用者中, 再由調用者去呼叫命令中的方法(復原).
* 命令需要透過execute或是其他方法記錄狀態, 使用記錄的狀態實作方法(復原).

## Demo
* 在遙控器中前一個記錄狀態, 方便復原, 按下UNDO的時候呼叫前一個指令的復原方法.
* 在每個指令中也記錄前一個狀態, 就能依據前一個狀態實作復原.
* 執行Demo, 觀察按鈕後的變化.
