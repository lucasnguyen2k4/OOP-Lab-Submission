package AimsProject;

import java.util.ArrayList;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered;
    private ArrayList<DigitalVideoDisc> items;

    public int getQtyOrdered(){
        return qtyOrdered;
    }
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].equals(disc)) {
                System.out.println("The disc is already added!");
                return;
            }
        }
        itemsOrdered[qtyOrdered] = disc;
        qtyOrdered++;
        System.out.println("The disc has been added!");
        if (qtyOrdered == MAX_NUMBERS_ORDERED - 1) {
            System.out.println("The cart is almost full!");
        }
    }
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered == 0){
            System.out.println("The cart is empty!");
        }
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].equals(disc)) {
                System.arraycopy(itemsOrdered, i + 1, itemsOrdered, i, qtyOrdered - i - 1);
                qtyOrdered--;
                System.out.println("The disc has been successfully removed!");
                return;
            }
        }
        System.out.println("The disc not found!");
    }

    public float totalCost() {
        float total = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            total += itemsOrdered[i].getCost();
        }
        return total;
    }

    public void displayCartItems() {
        for (int i = 0; i < qtyOrdered; i++) {
            System.out.println((i + 1) + "  " + itemsOrdered[i].getTitle() + "  " + itemsOrdered[i].getCost());
        }
        System.out.println("Total cost: " + totalCost());
    }
    public Cart(){
        this.items = new ArrayList<>();
    }
    public void addItem(DigitalVideoDisc dvd){
        this.items.add(dvd);
    }
    public void printCart() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        double total = 0;
        for (int i = 0; i < items.size(); i++) {
            System.out.println((i+1) + ". " + items.get(i).toString());
            total += items.get(i).getCost();
        }
        System.out.println("Total cost: " + total);
        System.out.println("***************************************************");
    }
    public void searchbyID(int id){
        for (DigitalVideoDisc dvd: items){
            if (dvd.getId() == id){
                System.out.println("Found DVD: " + dvd.toString());
                return;
            }
        }
        System.out.println("No DVD found with given id: " + id);
    }
    public void searchbyTitle(String title){
        boolean found = false;
        for (DigitalVideoDisc dvd: items){
            if (dvd.isMatch(title)){
                System.out.println("Found DVD: " + dvd.toString());
                found = true;
            }
        }
        if (!found){
        System.out.println("No DVD found with given title: " + title);
        }
    }
}
