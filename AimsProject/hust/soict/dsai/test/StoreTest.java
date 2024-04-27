package AimsProject;

public class StoreTest {
    public static void main(String[] args) {
        Store store = new Store();
        Store.DigitalVideoDisc dvd1 = new Store.DigitalVideoDisc("Movie 1", "Animation", "John Brooks", 38.2f);
        Store.DigitalVideoDisc dvd2 = new Store.DigitalVideoDisc("Movie 2", "Comedy", 39.5f);
        Store.DigitalVideoDisc dvd3 = new Store.DigitalVideoDisc("The Lion King",
                "Animation", "Roger Allers", 87, 19.95f);

        store.addDVD(dvd1);
        store.addDVD(dvd2);
        store.addDVD(dvd3);

        store.removeDVD(dvd1);
        System.out.println("DVD left: " + store);
    }
}
