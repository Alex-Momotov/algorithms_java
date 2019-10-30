package Hashing;

import java.util.HashMap;

public class Date {
    private int day;
    private int month;
    private int year;

    public int hashCode() {
        int R = 31;
        int hash = ((day*R) + month)*R + year;
        return hash;
    }

    public static void main(String[] args) {
        String input = "google";
        HashMap<Character, Integer> times = new HashMap<>();
        for (int i = 0; i < input.length(); ++i) {
            Character ch = input.charAt(i);
            if (!times.containsKey(ch)) {
                System.out.print(ch);
                times.put(input.charAt(i), 1);
            }
        }
    }
}
