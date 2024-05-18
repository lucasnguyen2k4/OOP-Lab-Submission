package AimsProject.hust.soict.dsai.media;

public class Disc extends Media{
    public String director;
    public int length;
    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }

    public Disc(int id, String title, String category, float cost, int length, String director) {
        super(id, title, category, cost);
        this.director = director;
        this.length = length;
    }
    @Override
    public String toString() {
        String var10000 = this.title;
        return "DVD - " + var10000 + " - " + this.category + " - " + this.director + " - " + this.length + ": " + this.cost + " $";
    }
}

