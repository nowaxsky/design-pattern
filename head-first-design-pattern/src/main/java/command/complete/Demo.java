package command.complete;

public class Demo {

  public static void main(String[] args) {

    // 調用者(遙控器)可傳入命令物件
    RemoteControlWithUndo remoteControl = new RemoteControlWithUndo();

    // 建立請求的接收者(各種終端電器)
    Light livingRoomLight = new Light("Living Room");
    Light kitchenRoomLight = new Light("Kitchen Room");
    Stereo stereo = new Stereo("Living Room");
    CeilingFan ceilingFan = new CeilingFan("Living Room");
    
    // 建立命令物件(各種電器對應的控制器), 並傳入接收者(各種終端電器)到命令物件中
    LightOnCommand livingRoomLightOn = new LightOnCommand(livingRoomLight);
    LightOffCommand livingRoomLightOff = new LightOffCommand(livingRoomLight);
    LightOnCommand kitchenRoomLightOn = new LightOnCommand(kitchenRoomLight);
    LightOffCommand kitchenRoomLightOff = new LightOffCommand(kitchenRoomLight);
    StereoOnWithCdCommand stereoOnWithCd = new StereoOnWithCdCommand(stereo);
    StereoOffCommand stereoOff = new StereoOffCommand(stereo);
    CeilingFanLowCommand ceilingFanLow = new CeilingFanLowCommand(ceilingFan);
    CeilingFanHighCommand ceilingFanHigh = new CeilingFanHighCommand(ceilingFan);
    CeilingFanOffCommand ceilingFanOff = new CeilingFanOffCommand(ceilingFan);

    Command[] partyOn = {livingRoomLightOn, stereoOnWithCd, ceilingFanLow};
    Command[] partyOff = {livingRoomLightOff, stereoOff, ceilingFanOff};
    
    MacroCommand partyOnMacro = new MacroCommand(partyOn);
    MacroCommand partyOffMacro = new MacroCommand(partyOff);
    
    // 命令物件傳入調用者(各種控制器插入遙控器的插槽)
    remoteControl.setCommand(0, partyOnMacro, partyOffMacro);
    remoteControl.setCommand(1, livingRoomLightOn, livingRoomLightOff);
    remoteControl.setCommand(2, kitchenRoomLightOn, kitchenRoomLightOff);
    remoteControl.setCommand(3, stereoOnWithCd, stereoOff);
    remoteControl.setCommand(4, ceilingFanLow, ceilingFanOff);
    remoteControl.setCommand(5, ceilingFanHigh, ceilingFanOff);

    // 印出現在遙控器上所有的插槽狀況
    System.out.println(remoteControl);

    System.out.println("\n---Pushing Macro On---\n");
    remoteControl.onButtonWasPushed(0);
    System.out.println("\n---Pushing Macro Off---\n");
    remoteControl.offButtonWasPushed(0);
    System.out.println("\n---Pushing Macro Undo---\n");
    remoteControl.undoButtonWasPushed();
    
    System.out.println("\n---Testing UNDO---\n");
    remoteControl.onButtonWasPushed(2);
    remoteControl.onButtonWasPushed(2);
    remoteControl.undoButtonWasPushed();
    remoteControl.undoButtonWasPushed();

  }


}
