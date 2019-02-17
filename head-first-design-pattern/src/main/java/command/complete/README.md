# Command Pattern 命令模式

## 萬用遙控器
* 設計一個遙控器可以控制7種不同的家電, 如電燈, 風扇, 熱水器等.
* 每個家電的控制方法為在遙控器的插槽內安裝其控制器, 每個控制器不同.
* 這台遙控器上有14個按鈕, 分別為控制7種家電的開關ON和OFF.
* 遙控器設有一個全體共用的復原鈕(UNDO), 會復原最後一個按鈕的動作.

## 命令模式

![Alt text](../resource/command.png "Command Pattern Class Graph")

* 定義: __將請求封裝成物件, 以便使用不同的請求, 佇列, 或者日誌, 參數化其他物件. 命令模式也支援可復原的作業.__
* 命令模式將 __發出請求的物件__ 和 __執行請求的物件__ 鬆綁.
* 被鬆綁的請求物件和執行請求物件之間, 是 __藉由命令物件進行溝通__, 而命令物件封裝了接收者的動作(一個或一組).
* 調用者藉由呼叫命令物件的execute()來發出請求, 這使得接收者的動作被調用.
* 命令可以支援復原方法.
* 巨集命令是普通命令的集合, 允許一次調用多個方法, 且支援復原.
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

## 巨集
* 若需要一次呼叫多個命令, 可以使用一個巨集命令Micro Command(巨集命令)來包裝.
* 由於巨集命令也是一種命令, 所以只要在建立巨集時放入需要一次調用的命令, 再傳入調用者即可, 調用者不需要知道是什麼樣的命令也能完成. 

## Demo
* 建立MicroCommand可以傳入多個遙控器, 並可以一次呼叫所有的execute()和undo().
* 把巨集設定好要放入的遙控器後, 插入遙控器0號插槽.
* 執行Demo測試.

## 問題
1. Receiver(接收者)一定要存在嗎? 為什麼命令物件不直接實踐execute()細節?
	* 這樣做就無法讓調用者和接收者之間鬆綁, 也不能把接收者當作參數傳給命令(`new Order(chef)`).
1. 如何實踐多層次復原操作? 例如按下UNDO多次可以復原到更早之前的狀態.
	* 只要利用stack記錄過去的狀態即可. 請執行Demo2來觀察.

## 應用
* 佇列請求:
	1. 工作佇列中含有非常多的工作, 也就是實踐execute()的命令物件, 線程池是一個調用者, 執行緒是接收者.
	1. 從一端可以不斷地增加工作(加入新命令物件), 另一端執行緒從線程池中取一個命令來執行裡面的execute()方法完成工作.
	1. 對應關係如下:
	
|Command Pattern
--|--
Receiver|Receiver
ThreadPoolExecutor|Invoker
ConcreteRunnable(Some Class implements Runnable)|ConcreteCommand
BlockingQueue|many waiting Commands
execute()|execute()
	
* 日誌(log)請求:
	1. 某些應用會將所有的動作記錄再日誌中, 並在系統出現問題後重新調用這些動作回復到之前的狀態.
	1. 在Command介面中新增store(), load()方法就可以支援. 另外也能夠使用Serialization(序列化)來實踐這些方法, 但一般認為序列化最好還是只用在物件的persistence(存續).
	1. 系統正常時, 命令除了execute()外, 並調用store()方法儲存; 系統當機時, 再調用load()復原.
	