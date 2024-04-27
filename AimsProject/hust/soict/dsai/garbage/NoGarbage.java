package hust.soict.dsai.garbage;

public class NoGarbage {
    private static final long MAX_RUNTIME = 1000000;
    private static long startTime = System.currentTimeMillis();

    public static void main(String[] args) {
        while (true) {
            String s = new String(new char[1000000]);
            if (System.currentTimeMillis() - startTime >= MAX_RUNTIME) {
                break;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

