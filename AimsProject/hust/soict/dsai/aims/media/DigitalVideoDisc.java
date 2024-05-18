package AimsProject.hust.soict.dsai.media;

public class DigitalVideoDisc extends Disc implements Playable {
    private static int nbDigitalVideoDiscs = 0;
    public DigitalVideoDisc() {
        this("N/A", "N/A", "N/A", 0, 0.0f);
    }
    public DigitalVideoDisc(String title) {
        this(title, "N/A", "N/A", 0, 0.0f);
    }
    public DigitalVideoDisc(String title, String category, float cost) {
        this(title, category, "N/A", 0, cost);
    }
    public DigitalVideoDisc(String title, String category, String director, float cost) {
        this(title, category, director, 0, cost);
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(nbDigitalVideoDiscs, title, category, cost, length, director);
        nbDigitalVideoDiscs++;
    }

    public boolean equals(DigitalVideoDisc that) {
        return this.title == that.title && this.category == that.category && this.director == that.director && this.length == that.length && this.cost == that.cost;
    }

    public boolean isMatch(String title) {
        return this.title.toLowerCase().equals(title.toLowerCase());
    }

    public String playContent() {
        String var4 = this.getTitle();
        return "Playing DVD: " + var4 + "\nDVD length: " + this.getLength();
    }
    public void play() {
        System.out.println(this.playContent());
    }
}

