package AimsProject.hust.soict.dsai.media;
import java.util.ArrayList;
import java.util.List;
public class Book extends Media {
    private List<String> authors;
    private static int nbbook = 0;

    public Book(String title,String category,float cost,List<String> authors){
        super(nbbook++,title, category, cost);
        this.authors = authors;
    }

    public Book(int id, String title, String category, float cost) {
        super(id, title, category, cost);
        this.authors = new ArrayList<>();
    }



    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public void addAuthor(List<String> authorName) {
        if (authors.contains(authorName)) {
            System.out.println("Author" + authorName + "is already added");
        } else {
            authors.add(String.valueOf(authorName));
        }
    }

    public void removeAuthor(List<String> authorName) {
        if (authors.contains(authorName)) {
            authors.remove(String.valueOf(authorName));
        } else {
            System.out.println("Author" + authorName + "does not exist");
        }
    }

    public String toString() {
        String s = this.title;
        return "Book - " + s + " - " + this.category + ": " + this.cost + " $";
    }
}
