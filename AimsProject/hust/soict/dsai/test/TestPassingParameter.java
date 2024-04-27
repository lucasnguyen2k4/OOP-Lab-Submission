package AimsProject.hust.soict.dsai.test;

import AimsProject.Store;

public class TestPassingParameter {
    public static void main(String[] args) {
        Store.DigitalVideoDisc jungleDVD = new Store.DigitalVideoDisc("Jungle");
        Store.DigitalVideoDisc cinderellaDVD = new Store.DigitalVideoDisc("Cinderella");
        Wrap wo1 = new Wrap(jungleDVD);
        Wrap wo2 = new Wrap(cinderellaDVD);
        swap(wo1, wo2);
        System.out.println("jungle dvd title: " + wo1.d.getTitle());
        System.out.println("cinderella dvd title: " + wo2.d.getTitle());

        changeTitle(jungleDVD, cinderellaDVD.getTitle());
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
    }

    public static void swap(Wrap o1, Wrap o2) {
        Store.DigitalVideoDisc tmp = o1.d;
        o1.d = o2.d;
        o2.d = tmp;
    }

    public static void changeTitle(Store.DigitalVideoDisc dvd, String title){
        String oldTitle = dvd.getTitle();
        dvd.setTitle(title);
        dvd = new Store.DigitalVideoDisc(oldTitle);
    }
}
class Wrap {
    Store.DigitalVideoDisc d;

    Wrap(Store.DigitalVideoDisc d) {
        this.d = d;
    }
}

