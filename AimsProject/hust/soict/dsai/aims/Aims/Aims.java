package AimsProject.hust.soict.dsai.aims.Aims;

import AimsProject.Store;
import AimsProject.hust.soict.dsai.aims.cart.Cart.Cart;

public class Aims {
    public static void main(String[] args) {
        Cart anOrder = new Cart();
        Store.DigitalVideoDisc dvd1 = new Store.DigitalVideoDisc("The Lion King",
                "Animation", "Roger Allers", 87, 19.95f);
        anOrder.addDigitalVideoDisc(dvd1);

        Store.DigitalVideoDisc dvd2 = new Store.DigitalVideoDisc("Star Wars",
                "Science Fiction", "George Lucas", 87, 24.95f);
        anOrder.addDigitalVideoDisc(dvd2);

        Store.DigitalVideoDisc dvd3 = new Store.DigitalVideoDisc("Aladdin",
                "Animation", 18.99f);
        anOrder.addDigitalVideoDisc(dvd3);

        Store.DigitalVideoDisc dvd4 = new Store.DigitalVideoDisc("Kung Fu Panda 4",
                "Animation", 32.99f);
        anOrder.addDigitalVideoDisc(dvd4);

        anOrder.removeDigitalVideoDisc(dvd4);
        /*anOrder.addDigitalVideoDisc(dvd3);*/

        anOrder.displayCartItems();
        }
    }

