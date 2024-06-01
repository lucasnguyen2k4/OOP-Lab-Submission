package AimsProject.hust.soict.dsai.screen;

import AimsProject.hust.soict.dsai.aims.cart.Cart.Cart;
import AimsProject.hust.soict.dsai.aims.store.Store;
import AimsProject.hust.soict.dsai.media.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class StoreScreen extends JFrame {
    private Store store;
    private static Cart cart = new Cart();

    private JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    private JMenuBar createMenuBar(){
        JMenu menu = new JMenu("Options");

        JMenu smUpdateStore = new JMenu("Update Store");
        JMenuItem smAddBook = new JMenuItem("Add Book");
        smAddBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddBookToStoreScreen(store);
            }
        });

        JMenuItem smAddCD = new JMenuItem("Add CD");
        smAddCD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddCompactDiscToStoreScreen(store);
            }
        });

        JMenuItem smAddDVD = new JMenuItem("Add DVD");
        smAddDVD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddDigitalVideoDiscToStoreScreen(store);
            }
        });

        smUpdateStore.add(smAddBook);
        smUpdateStore.add(smAddCD);
        smUpdateStore.add(smAddDVD);

        menu.add((smUpdateStore));
        JMenuItem viewStoreMenu = new JMenuItem("View store");
        JMenuItem viewCartMenu = new JMenuItem("View cart");
        menu.add(viewStoreMenu);
        menu.add(viewCartMenu);
        viewCartMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CartScreen(cart);
            }
        });

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }

    private JPanel createHeader(){
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(),Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        JButton cart_btn = new JButton("View cart");
        cart_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CartScreen(cart);
            }
        });

        cart_btn.setPreferredSize(new Dimension(100,50));
        cart_btn.setMaximumSize(new Dimension(100,50));

        header.add(Box.createRigidArea(new Dimension(10,10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(cart_btn);
        header.add(Box.createRigidArea(new Dimension(10,10)));

        return header;
    }

    private JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 2, 2));

        ArrayList<Media> mediaInStore = store.getItemsInStore();
        for (int i = 0; i < mediaInStore.size(); i++) {
            MediaStore cell = new MediaStore(mediaInStore.get(i),cart);
            center.add(cell);
        }
        return center;
    }

    public StoreScreen(Store store){
        this.store = store;
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(),BorderLayout.NORTH);
        cp.add(createCenter(),BorderLayout.CENTER);

        setVisible(true);
        setTitle("Store");
        setSize(1024,768);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        Store store = new Store();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", null, 0, 18.99f);
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);


        Book book = new Book("Big Book Of Everything", "Science", 20.00f);
        Book book1 = new Book("Treasure Island", "Adventure", 29.95f);
        Book book2 = new Book("Oliver Twist", "Novel", 120.00f);
        store.addMedia(book);
        store.addMedia(book1);
        store.addMedia(book2);


        CompactDisc cd1 = new CompactDisc("Avicii's Hit Songs", "Music","Avicii", 1500.98f);
        Track track1CD1 = new Track("Levels", 2*60 +35);
        Track track2CD1 = new Track("Hey Brother", 60 + 54);
        Track track3CD1 = new Track("The Nights", 76);
        cd1.addTrack(track1CD1);
        cd1.addTrack(track2CD1);
        cd1.addTrack(track3CD1);

        CompactDisc cd2 = new CompactDisc("Michael Jackson's Best Songs", "Music","Michael Jackson", 2000.22f);
        Track track1CD2 = new Track("Smooth Criminal", 4*60+49);
        Track track2CD2 = new Track("We are the champions", 5*60+52);
        Track track3CD2 = new Track("Billie Jean", 2*60+23);
        cd2.addTrack(track1CD2);
        cd2.addTrack(track2CD2);
        cd2.addTrack(track3CD2);

        CompactDisc cd3 = new CompactDisc("Modern Talking 80's", "Music", "Modern Talking",1000.98f);
        Track track1CD3 = new Track("Cheri Cheri Lady", 4*60+5);
        Track track2CD3 = new Track("Brother Louie", 3*60 +54);
        cd3.addTrack(track1CD3);
        cd3.addTrack(track2CD3);

        store.addMedia(cd1);
        store.addMedia(cd2);
        store.addMedia(cd3);
        new StoreScreen(store);
    }
}