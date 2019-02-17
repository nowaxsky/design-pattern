package command.stage4;

public class Demo {

  public static void main(String[] args) {

    // 調用者(遙控器)可傳入命令物件
    RemoteControlWithUndo remoteControl = new RemoteControlWithUndo();

    // 建立請求的接收者(各種終端電器)
    Light livingRoomLight = new Light("Living Room");
    Light kitchenRoomLight = new Light("Kitchen Room");

    // 建立命令物件(各種電器對應的控制器), 並傳入接收者(各種終端電器)到命令物件中
    LightOnCommand livingRoomLightOn = new LightOnCommand(livingRoomLight);
    LightOffCommand livingRoomLightOff = new LightOffCommand(livingRoomLight);
    LightOnCommand kitchenRoomLightOn = new LightOnCommand(kitchenRoomLight);
    LightOffCommand kitchenRoomLightOff = new LightOffCommand(kitchenRoomLight);

    // 命令物件傳入調用者(各種控制器插入遙控器的插槽)
    remoteControl.setCommand(0, livingRoomLightOn, livingRoomLightOff);
    remoteControl.setCommand(1, kitchenRoomLightOn, kitchenRoomLightOff);

    // 印出現在遙控器上所有的插槽狀況
    System.out.println(remoteControl);

    System.out.println("\n---Test1---\n");
    remoteControl.onButtonWasPushed(0);
    remoteControl.offButtonWasPushed(0);
    remoteControl.undoButtonWasPushed();
    
    System.out.println("\n---Test2---\n");
    remoteControl.offButtonWasPushed(0);
    remoteControl.onButtonWasPushed(1);
    remoteControl.undoButtonWasPushed();
    
    System.out.println("\n---Test3---\n");
    remoteControl.offButtonWasPushed(0);
    remoteControl.offButtonWasPushed(0);
    remoteControl.undoButtonWasPushed();
    
    System.out.println("\n---Test4---\n");
    remoteControl.onButtonWasPushed(1);
    remoteControl.onButtonWasPushed(1);
    remoteControl.undoButtonWasPushed();
    remoteControl.undoButtonWasPushed();

  }


}
