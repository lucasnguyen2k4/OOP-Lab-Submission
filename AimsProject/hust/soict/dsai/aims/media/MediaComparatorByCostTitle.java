package AimsProject.hust.soict.dsai.media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {
    public MediaComparatorByCostTitle() {
    }

    public int compare(Media m1, Media m2) {
        Comparator<Media> byCost = Comparator.comparing(Media::getCost);
        Comparator<Media> byTitle = Comparator.comparing(Media::getTitle);
        return byCost.thenComparing(byTitle).compare(m1, m2);
    }
}
