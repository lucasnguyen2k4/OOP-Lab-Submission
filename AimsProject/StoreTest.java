package AimsProject;

public class StoreTest {
    public static void main(String[] args) {
        Store store = new Store();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Movie 1", "Animation", "John Brooks", 38.2f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Movie 2", "Comedy", 39.5f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("The Lion King",
                "Animation", "Roger Allers", 87, 19.95f);

        store.addDVD(dvd1);
        store.addDVD(dvd2);
        store.addDVD(dvd3);

        store.removeDVD(dvd1);
        System.out.println("DVD left: " + store);
    }
}
