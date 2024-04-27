package hust.soict.dsai.garbage;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class Observation {
    public static void main(String[] args) throws IOException {
        String filename = "test.exe";
        byte[] inputBytes = { 0 };
        long startTime, endTime;
        inputBytes = Files.readAllBytes (Paths.get(filename));
        StringBuilder outputString = new StringBuilder();
        startTime = System.currentTimeMillis();
        for (byte b : inputBytes) {
            outputString.append((char) b);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Time taken with StringBuilder: " + (endTime - startTime) + " ms");
    }
}

