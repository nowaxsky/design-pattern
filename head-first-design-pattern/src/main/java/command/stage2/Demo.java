package command.stage2;

public class Demo {

  public static void main(String[] args) {
    
    // 調用者(遙控器)可傳入命令物件
    RemoteControl remote = new RemoteControl();
    
    // 建立一個請求的接收者(檯燈物件)
    Light light = new Light();
    
    // 建立命令物件(控制器), 並傳入接收者(檯燈)到命令物件中
    LightOnCommand lightOn = new LightOnCommand(light);
    
    
    // 命令物件傳入調用者(控制器插入遙控器的插槽)
    remote.setCommand(lightOn);
    
    // 按下ON按鈕
    remote.buttonWasPushed();
  }
  
  
}
