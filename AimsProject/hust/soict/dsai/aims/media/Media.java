package AimsProject.hust.soict.dsai.media;
import java.lang.Object;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Comparator;
public abstract class Media {
    protected int id;
    protected String title;
    protected String category;
    protected float cost;
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
    public int getId() {return id;}

    public String getTitle() {return title;}

    public String getCategory() {return category;}

    public float getCost() {return cost;}
    public Media(int id, String title, String category, float cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public boolean isMatch(int id){
        if (this.getId() == id){
            return true;
        }
        return false;
    }

    public boolean isMatch(String title){
        if (this.getTitle().equalsIgnoreCase(title.trim())){
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(obj instanceof Media s){
            return Objects.equals(s.getTitle(), getTitle());
        }
        return false;
    }
    public String getDetail(){
        if (this instanceof DigitalVideoDisc) {
            return String.format("DVD - %s - %s - %s - %d minutes: %.2f $", this.getTitle(),this.getCategory(), ((Disc)this).getDirector(), ((Disc)this).getLength(), this.getCost());
        }

        else if (this instanceof CompactDisc) {
            return String.format("CD - %s - %s - %d minutes: %.2f $", this.getTitle(),this.getCategory(), ((Disc)this).getLength(), this.getCost());
        }

        else {
            return String.format("Book - %s - %s - %s: %.2f $", this.getTitle(), ((Book)this).getAuthors(), this.getCategory(), this.getCost());
        }
    }
}






