package command.stage3;

public class Demo {

  public static void main(String[] args) {

    // 調用者(遙控器)可傳入命令物件
    RemoteControl remoteControl = new RemoteControl();

    // 建立請求的接收者(各種終端電器)
    Light livingRoomLight = new Light("Living Room");
    Light kitchenRoomLight = new Light("Kitchen Room");
    GarageDoor garageDoor = new GarageDoor("Garage-A");
    Stereo stereo = new Stereo("Living Room");

    // 建立命令物件(各種電器對應的控制器), 並傳入接收者(各種終端電器)到命令物件中
    LightOnCommand livingRoomLightOn = new LightOnCommand(livingRoomLight);
    LightOffCommand livingRoomLightOff = new LightOffCommand(livingRoomLight);
    LightOnCommand kitchenRoomLightOn = new LightOnCommand(kitchenRoomLight);
    LightOffCommand kitchenRoomLightOff = new LightOffCommand(kitchenRoomLight);
    GarageDoorUpCommand garageDoorUp = new GarageDoorUpCommand(garageDoor);
    GarageDoorDownCommand garageDoorDown = new GarageDoorDownCommand(garageDoor);
    StereoOnWithCdCommand stereoOnWithCd = new StereoOnWithCdCommand(stereo);
    StereoOffCommand stereoOff = new StereoOffCommand(stereo);

    // 命令物件傳入調用者(各種控制器插入遙控器的插槽)
    remoteControl.setCommand(0, livingRoomLightOn, livingRoomLightOff);
    remoteControl.setCommand(1, kitchenRoomLightOn, kitchenRoomLightOff);
    remoteControl.setCommand(2, garageDoorUp, garageDoorDown);
    remoteControl.setCommand(3, stereoOnWithCd, stereoOff);

    // 印出現在遙控器上所有的插槽狀況
    System.out.println(remoteControl);

    // 嘗試按下0-4號ON按鍵
    remoteControl.onButtonWasPushed(0);
    remoteControl.onButtonWasPushed(1);
    remoteControl.onButtonWasPushed(2);
    remoteControl.onButtonWasPushed(3);
    remoteControl.onButtonWasPushed(4);

    // 嘗試按下0-4號OFF按鍵
    remoteControl.offButtonWasPushed(0);
    remoteControl.offButtonWasPushed(1);
    remoteControl.offButtonWasPushed(2);
    remoteControl.offButtonWasPushed(3);
    remoteControl.offButtonWasPushed(4);
  }


}
