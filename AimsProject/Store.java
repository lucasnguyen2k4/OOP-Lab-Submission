package AimsProject;

import java.util.ArrayList;
public class Store {
    ArrayList<DigitalVideoDisc> itemsInStore;
    public Store(){
        itemsInStore = new ArrayList<>();
    }
    public void addDVD(DigitalVideoDisc dvd){
        itemsInStore.add(dvd);
    }
    public void removeDVD(DigitalVideoDisc dvd){
        itemsInStore.remove(dvd);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Store {\n");
        sb.append("itemsInStore= \n");
        for (DigitalVideoDisc dvd : itemsInStore) {
            sb.append(dvd.toString());
            sb.append("\n");
        }
        sb.append('}');
        return sb.toString();
    }
}

