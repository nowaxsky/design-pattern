package command.stage5;

public class Demo {

  public static void main(String[] args) {

    // 調用者(遙控器)可傳入命令物件
    RemoteControlWithUndo remoteControl = new RemoteControlWithUndo();

    // 建立請求的接收者(各種終端電器)
    CeilingFan ceilingFan = new CeilingFan("Living Room");

    // 建立命令物件(各種電器對應的控制器), 並傳入接收者(各種終端電器)到命令物件中
    CeilingFanLowCommand ceilingFanLow = new CeilingFanLowCommand(ceilingFan);
    CeilingFanMediumCommand ceilingFanMedium = new CeilingFanMediumCommand(ceilingFan);
    CeilingFanHighCommand ceilingFanHigh = new CeilingFanHighCommand(ceilingFan);
    CeilingFanOffCommand ceilingFanOff = new CeilingFanOffCommand(ceilingFan);

    // 命令物件傳入調用者(各種控制器插入遙控器的插槽)
    remoteControl.setCommand(0, ceilingFanLow, ceilingFanOff);
    remoteControl.setCommand(1, ceilingFanMedium, ceilingFanOff);
    remoteControl.setCommand(2, ceilingFanHigh, ceilingFanOff);

    // 印出現在遙控器上所有的插槽狀況
    System.out.println(remoteControl);

    System.out.println("\n---Test1---\n");
    remoteControl.onButtonWasPushed(0);
    remoteControl.offButtonWasPushed(0);
    remoteControl.undoButtonWasPushed();
    
    System.out.println("\n---Test2---\n");
    remoteControl.onButtonWasPushed(1);
    remoteControl.offButtonWasPushed(2);
    remoteControl.undoButtonWasPushed();
    
    System.out.println("\n---Test3---\n");
    remoteControl.onButtonWasPushed(2);
    remoteControl.onButtonWasPushed(2);
    remoteControl.undoButtonWasPushed();
    
    System.out.println("\n---Test4---\n");
    remoteControl.offButtonWasPushed(1);
    remoteControl.offButtonWasPushed(2);
    remoteControl.undoButtonWasPushed();
    
    System.out.println("\n---Test5---\n");
    remoteControl.onButtonWasPushed(0);
    remoteControl.offButtonWasPushed(0);
    remoteControl.undoButtonWasPushed();
    remoteControl.undoButtonWasPushed();
    
    // 建立請求的接收者(各種終端電器)
    Light livingRoomLight = new Light("Living Room");
    Light kitchenRoomLight = new Light("Kitchen Room");

    // 建立命令物件(各種電器對應的控制器), 並傳入接收者(各種終端電器)到命令物件中
    LightOnCommand livingRoomLightOn = new LightOnCommand(livingRoomLight);
    LightOffCommand livingRoomLightOff = new LightOffCommand(livingRoomLight);
    LightOnCommand kitchenRoomLightOn = new LightOnCommand(kitchenRoomLight);
    LightOffCommand kitchenRoomLightOff = new LightOffCommand(kitchenRoomLight);

    // 命令物件傳入調用者(各種控制器插入遙控器的插槽)
    remoteControl.setCommand(3, livingRoomLightOn, livingRoomLightOff);
    remoteControl.setCommand(4, kitchenRoomLightOn, kitchenRoomLightOff);
    
    System.out.println("\n---Test for stage4---\n");
    remoteControl.onButtonWasPushed(3);
    remoteControl.onButtonWasPushed(4);
    remoteControl.offButtonWasPushed(4);
    remoteControl.undoButtonWasPushed();
    remoteControl.undoButtonWasPushed();

  }


}
