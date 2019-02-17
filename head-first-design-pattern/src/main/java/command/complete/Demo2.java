package command.complete;

public class Demo2 {

  public static void main(String[] args) {

    // 調用者(遙控器)可傳入命令物件
    RemoteControlWithUndo remoteControl = new RemoteControlWithUndo();

    // 建立請求的接收者(各種終端電器)
    Stereo stereo = new Stereo("Living Room");
    
    // 建立命令物件(各種電器對應的控制器), 並傳入接收者(各種終端電器)到命令物件中
    StereoOnWithCdCommand stereoOnWithCd = new StereoOnWithCdCommand(stereo);
    StereoOffCommand stereoOff = new StereoOffCommand(stereo);

    // 命令物件傳入調用者(各種控制器插入遙控器的插槽)
    remoteControl.setCommand(0, stereoOnWithCd, stereoOff);

    // 印出現在遙控器上所有的插槽狀況
    System.out.println(remoteControl);

    System.out.println("\n---Testing 1---\n");
    remoteControl.offButtonWasPushed(0);
    remoteControl.onButtonWasPushed(0);
    remoteControl.undoButtonWasPushed();
    
    System.out.println("\n---Testing 2---\n");
    remoteControl.onButtonWasPushed(0);
    remoteControl.offButtonWasPushed(0);
    remoteControl.undoButtonWasPushed();
    remoteControl.undoButtonWasPushed();

  }


}
