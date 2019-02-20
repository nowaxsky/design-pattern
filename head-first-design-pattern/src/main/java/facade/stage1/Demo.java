package facade.stage1;

public class Demo {
  public static void main(String[] args) {
    Amplifier amp = new Amplifier("Top-O-Line Amplifier");
    DvdPlayer dvd = new DvdPlayer("Top-O-Line DVD Player", amp);
    Projector projector = new Projector("Top-O-Line Projector", dvd);
    TheaterLights lights = new TheaterLights("Theater Ceiling Lights");
    Screen screen = new Screen("Theater Screen");
    PopcornPopper popper = new PopcornPopper("Popcorn Popper");

    String movie = "Aquaman";

    popper.on();
    popper.pop();

    lights.dim(10);

    screen.down();

    projector.on();
    projector.wideScreenMode();

    amp.on();
    amp.setDvd(dvd);
    amp.setSurroundSound();
    amp.setVolume(5);

    dvd.on();
    dvd.play(movie);
  }

}
