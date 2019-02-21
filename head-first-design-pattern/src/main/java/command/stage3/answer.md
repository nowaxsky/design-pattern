# Command Pattern 命令模式 - 3

## 問題
1. 為何要使用NoCommand?
	* 這是簡化程式的一種技巧, 如果沒有預先設置空插槽, 則每次按下ON或OFF前都要先檢查是否為null非常麻煩, 如下:
		```java
		public void onButtonWasPushed(int slot) {
		  if(onCommands[slot] != null) {
		    onCommands[slot].execute();
		  }
		}
		```
	* 其實NoCommand中的execute()行為可為空, 只是為了測試才印出字串, 最好的設計方式如下:
		```java
		public class NoCommand implements Command {
		  @Override
		  public void execute() {}
		}
		```
1. 請參考CeilingFan物件, 嘗試自行製作控制器並插入遙控器, 按下開關來測試.
	* 請參考stage4.