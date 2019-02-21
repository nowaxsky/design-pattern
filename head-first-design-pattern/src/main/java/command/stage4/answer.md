# Command Pattern 命令模式 - 4

## 問題
1. Demo中的Test3和Test4有問題, 請問如何修復?
	* 因為undo()實作僅是反向, 沒有考慮到如果有人連按兩次OFF, 則上一步復原應該也要是OFF, 而非ON, 解決方法是必須記錄上一次的狀態, 請參考stage5.
