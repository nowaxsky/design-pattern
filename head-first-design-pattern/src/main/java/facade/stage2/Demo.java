package facade.stage2;

public class Demo {
  public static void main(String[] args) {
    Amplifier amp = new Amplifier("Top-O-Line Amplifier");
    Tuner tuner = new Tuner("Top-O-Line AM/FM Tuner", amp);
    DvdPlayer dvd = new DvdPlayer("Top-O-Line DVD Player", amp);
    CdPlayer cd = new CdPlayer("Top-O-Line CD Player", amp);
    Projector projector = new Projector("Top-O-Line Projector", dvd);
    TheaterLights lights = new TheaterLights("Theater Ceiling Lights");
    Screen screen = new Screen("Theater Screen");
    PopcornPopper popper = new PopcornPopper("Popcorn Popper");

    String movie = "Aquaman";

    HomeTheaterFacade homeTheater =
        new HomeTheaterFacade(amp, tuner, dvd, cd, projector, screen, lights, popper);
    homeTheater.watchMovie(movie);
    try {
      for (int i = 0; i < 6; i++) {
        System.out.println("---watching---\n");
        Thread.sleep(500);
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    homeTheater.endMovie();
  }

}
