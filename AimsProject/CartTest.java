package AimsProject;

public class CartTest extends Cart {
    public static void main(String[] args) {
        Cart cart = new Cart();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
                "Animation", "Roger Allers", 87, 19.95f);
        cart.addItem(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
                "Science Fiction", "George Lucas", 87, 24.95f);
        cart.addItem(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin",
                "Animation", 18.99f);
        cart.addItem(dvd3);

        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Kung Fu Panda 4",
                "Animation", 32.99f);
        cart.addItem(dvd4);
        cart.printCart();
        cart.searchbyID(4);
        cart.searchbyTitle("Star Wars");
    }
}
