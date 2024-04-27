package AimsProject;

import AimsProject.hust.soict.dsai.aims.cart.Cart.Cart;

public class CartTest extends Cart {
    public static void main(String[] args) {
        Cart cart = new Cart();
        Store.DigitalVideoDisc dvd1 = new Store.DigitalVideoDisc("The Lion King",
                "Animation", "Roger Allers", 87, 19.95f);
        cart.addItem(dvd1);

        Store.DigitalVideoDisc dvd2 = new Store.DigitalVideoDisc("Star Wars",
                "Science Fiction", "George Lucas", 87, 24.95f);
        cart.addItem(dvd2);

        Store.DigitalVideoDisc dvd3 = new Store.DigitalVideoDisc("Aladdin",
                "Animation", 18.99f);
        cart.addItem(dvd3);

        Store.DigitalVideoDisc dvd4 = new Store.DigitalVideoDisc("Kung Fu Panda 4",
                "Animation", 32.99f);
        cart.addItem(dvd4);
        cart.printCart();
        cart.searchbyID(4);
        cart.searchbyTitle("Star Wars");
    }
}
