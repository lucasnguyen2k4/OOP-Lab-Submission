package AimsProject.hust.soict.dsai.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {
    public MediaComparatorByTitleCost() {
    }

    public int compare(Media m1, Media m2) {
        Comparator<Media> byCost = Comparator.comparing(Media::getCost);
        Comparator<Media> byTitle = Comparator.comparing(Media::getTitle);
        return byTitle.thenComparing(byCost).compare(m1, m2);
    }
}

