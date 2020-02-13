package edu.wctc;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public Scanner keyboard = new Scanner(System.in);

    private final static FileInput indata = new FileInput("the_book.csv");
    private final static Map<String, Integer> map = new HashMap<>();


    public Main() {
        String line;
        String[] words;

        while ((line = indata.fileReadLine()) != null) {
            // Remove anything that's not a letter or space
            line = line.replaceAll("[^a-zA-Z ]", "")
                    .toLowerCase().trim();

            // Don't process lines with no characters
            if (line.isEmpty()) {
                continue;
            }

            // Split string over one or more spaces
            words = line.split(" +");

            // Look for each word in the map
            for (String word : words) {
                // This word isn't yet a key, init count to 1
                if (!map.containsKey(word)) {
                    map.put(word, 1);
                } else {
                    // Increment count using word as key
                    map.put(word, map.get(word) + 1);
                }

            }
        }
    }


    public static void printListOfOnes() {
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            //System.out.println(entry.getKey() + " " + entry.getValue());
            if (entry.getValue() == 1) {
                int result = entry.getValue();
                System.out.println(entry.getKey() + " " + entry.getValue());

            }
        }
    }

    public static void printMenu() {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Select Option");
        System.out.println("1. View Complete List");
        System.out.println("2. Words only mentioned one time");
        System.out.println("3. top 10 most mentioned words");

        String choice = keyboard.nextLine();

        if (choice.equals("1")) {
            all();
        } else if (choice.equals("2")) {
            printListOfOnes();
        } else if (choice.equals("3")) {
            topTen();
        } else {
            System.out.println("Invalid response");
            printMenu();
        }
    }


    public static void topTen() {

        ArrayList<Integer> list = new ArrayList<>();


        for (Map.Entry<String, Integer> entry : map.entrySet()) {

            Integer mostMentioned = 0;


            while (entry.getValue() > mostMentioned) {
                Integer mentioned = entry.getValue();
                list.add(mentioned);
            }
            for (int i = 0; i < 9; i++) {
                System.out.println(list);
            }

        }
    }


    public static void main(String[] args) {
        new Main();
        printMenu();

    }

    public static void all() {
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());

        }
    }

}