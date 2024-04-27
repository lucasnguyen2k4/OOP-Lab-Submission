package hust.soict.dsai.garbage;

public class GarbageCreator {
    public static void createGarbage(){
        while (true){
            String s = new String(new char[1000000]);
        }
    }

    public static void main(String[] args) {
        createGarbage();
    }
}
