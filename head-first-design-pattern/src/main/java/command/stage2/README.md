# Command Pattern 命令模式 - 2

## 萬用遙控器
* 設計一個遙控器可以控制7種不同的家電, 如電燈, 風扇, 熱水器等.
* 每個家電的控制方法為在遙控器的插槽內安裝其控制器, 每個控制器不同.
* 這台遙控器上有14個按鈕, 分別為控制7種家電的開關ON和OFF.
* 遙控器設有一個全體共用的復原鈕(UNDO), 會復原最後一個按鈕的動作.

## 命令模式

![Alt text](../resource/command.png "Command Pattern Class Diagram")

* 定義: __將請求封裝成物件, 以便使用不同的請求, 佇列, 或者日誌, 參數化其他物件. 命令模式也支援可復原的作業.__
* 命令物件 __封裝一個請求__ ,命令物件中記錄某個接收者的一組動作, 只露出一個execute()方法, 當此方法被呼叫時接收者會進行動作.
* 從外面來看, 其他物件不知道究竟誰是接收者, 進行了什麼動作, 只知道呼叫execute()就能達成目的. 如: 遙控器根本不用知道電器是誰, 只要控制器實踐Command介面即可; 客人不用知道廚師是誰, 只要填菜單請服務員過來收就好.
* 以餐廳對照類別圖:
    1. Client即客人.
    1. Receiver接收者即廚師, action()是製作料理.
    1. ConcreteCommand是菜單, 裡面有execute()即準備料理, undo()後續章節介紹.
    1. Command是所有菜單的原型, 若未來有飲料菜單, 或是限定菜單均要實作Command.
    1. Invoker調用者即服務生, setCommand()就是收單.

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

## Demo
* 執行Demo來觀察遙控器.

## 問題
* 請讓萬用遙控器可以打開倉庫門, 請參考GarageDoor類別, 實作GarageDoorUpCommand.
