# Command Pattern 命令模式 - 5

## 萬用遙控器
* 設計一個遙控器可以控制7種不同的家電, 如電燈, 風扇, 熱水器等.
* 每個家電的控制方法為在遙控器的插槽內安裝其控制器, 每個控制器不同.
* 這台遙控器上有14個按鈕, 分別為控制7種家電的開關ON和OFF.
* 遙控器設有一個全體共用的復原鈕(UNDO), 會復原最後一個按鈕的動作.

## 命令模式

![Alt text](../resource/command.png "Command Pattern Class Diagram")

* 定義: __將請求封裝成物件, 以便使用不同的請求, 佇列, 或者日誌, 參數化其他物件. 命令模式也支援可復原的作業.__
* 命令模式將 __發出請求的物件__ 和 __執行請求的物件__ 鬆綁.
* 被鬆綁的請求物件和執行請求物件之間, 是 __藉由命令物件進行溝通__, 而命令物件封裝了接收者的動作(一個或一組).
* 調用者藉由呼叫命令物件的execute()來發出請求, 這使得接收者的動作被調用.
* 命令可以支援復原方法.
* 餐廳, 遙控器, 命令模式對照關係表如下:

Restaurant|RemoteControl|Command Pattern
--|--|--
Client|You|Client
Chef|Light, GarageDoor, ...|Receiver
Waiter|RemoteControl|Invoker
Order|Command(LightOnCommand, LightOffCommand, ...)|ConcreteCommand
new Order()|new Command()|new Command()
OrderUp()|execute()|execute()
takeOrder()|setCommand()|setCommand()
deliver()|buttonWasPushed()|triggerMethod()

## 復原方法
* 可以新增復原方法, 並讓所有的命令實作後以供調用者呼叫.
* 復原方法可以橫跨各種命令, 若需要記錄狀態, 可以先將是何種命令記錄在調用者中, 再由調用者去呼叫命令中的復原方法.
* 命令需要透過execute或是其他方法記錄狀態, 使用記錄的狀態實作復原方法.

## Demo
* 在遙控器中前一個記錄狀態, 方便復原, 按下UNDO的時候呼叫前一個指令的復原方法.
* 在每個指令中也記錄前一個狀態, 就能依據前一個狀態實作復原.
* 執行Demo, 觀察按鈕後的變化.
