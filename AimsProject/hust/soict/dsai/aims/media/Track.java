package AimsProject.hust.soict.dsai.media;

public class Track implements Playable{
    private String title;
    private int length;

    public String getTitle() {
        return title;
    }
    public int getLength() {
        return length;
    }
    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    @Override
    public String playContent() {
        String title = this.getTitle();
        return "Playing Track: " + title + "\nTrack length: " + this.getLength();
    }

    public void play() {
        System.out.println(this.playContent());
    }
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (!(obj instanceof Track)) {
            return false;
        } else {
            Track track = (Track) obj;
            return this.title.equals(track.getTitle()) && this.length == track.getLength();
        }
    }
}




