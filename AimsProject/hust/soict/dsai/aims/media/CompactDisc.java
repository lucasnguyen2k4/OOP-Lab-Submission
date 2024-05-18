package AimsProject.hust.soict.dsai.media;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private List<Track> tracks = new ArrayList();
    private static int nbCDisc = 0;

    public CompactDisc(String title,String category,float cost,String artist, ArrayList<Track> tracks){
        super(nbCDisc++, title, category, cost, 0, null);
        this.artist = artist;
        this.tracks = tracks;
    }

    public String getArtist() {
        return this.artist;
    }

    public CompactDisc(int id, String title, String category, float cost, String director, String artist) {
        super(id, title, category, cost, 0, director);
        this.artist = artist;
    }

    public void addTrack(Track track) {
        if (!this.tracks.contains(track)) {
            this.tracks.add(track);
            System.out.println("Track added.\n");
        } else {
            System.out.println("Track is already in the list!\n");
        }

    }

    public void removeTrack(Track track) {
        if (this.tracks.remove(track)) {
            System.out.println("Track removed.\n");
        } else {
            System.out.println("Track is not in the list!\n");
        }

    }

    public int getLength() {
        int len = 0;

        Track track;
        for (Iterator var3 = this.tracks.iterator(); var3.hasNext(); len += track.getLength()) {
            track = (Track)var3.next();
        }
        return len;
    }
    public void play() {
        System.out.println("Playing CD: " + this.getTitle());
        System.out.println("CD length: " + this.getLength());
        System.out.println("------------------------------");
        Iterator var2 = this.tracks.iterator();

        while (var2.hasNext()) {
            Track track = (Track) var2.next();
            track.play();
        }
    }
    public String playContent() {
        String var10000 = this.getTitle();
        String content = "Playing CD: " + var10000 + "\nCD length: " + this.getLength();
        Track track;
        for(Iterator var3 = this.tracks.iterator(); var3.hasNext(); content = content + "\n" + track.playContent()) {
            track = (Track)var3.next();
        }

        return content;
    }
    public String toString() {
        String var1 = this.title;
        return "CD - " + var1 + " - " + this.category + " - " + this.director + " - " + this.length + " - " + this.artist + ": " + this.cost + " $";
    }
}





