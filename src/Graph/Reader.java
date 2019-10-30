package Graph;

import java.util.Scanner;
import java.io.*;

public class Reader {
    Scanner reader;

    public Reader(String filename) {
        try {
            reader = new Scanner(new FileInputStream(filename));
            //reader.useDelimiter(Pattern.compile("[ :]"));
        } catch (IOException e) {
            System.out.println("Error opening file!" + e.getMessage());
            e.printStackTrace();
        }
    }

    public int readInt() {
        int num = -1;
        if (reader.hasNextInt()) {
            num = reader.nextInt();
        }
        return num;
    }

    public static void main(String[] args)
    {
        Reader r = new Reader(args[0]);
        System.out.println(r.readInt());
        System.out.println(r.readInt());
        System.out.println(r.readInt());
        System.out.println(r.readInt());
    }
}