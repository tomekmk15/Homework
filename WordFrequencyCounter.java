package zadania.dom.dom;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class WordFrequencyCounter {

    public static void main(String[] args) {
        try {
            File file = new File("Pliki/" + "" + "pan_tadeusz.txt");
            Map<String, Integer> wordFrequencyMap = countWordOccurrences(file);


            System.out.println("alfabetycznie:");
            wordFrequencyMap.entrySet().stream()
                    .sorted(Map.Entry.comparingByKey())
                    .forEach(entry -> System.out.println(entry.getKey() + " -> " + entry.getValue()));


            System.out.println("\nWyniki  według  wystąpień:");
            wordFrequencyMap.entrySet().stream()
                    .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                    .forEach(entry -> System.out.println(entry.getKey() + " -> " + entry.getValue()));

        } catch (FileNotFoundException e) {
            System.err.println("Błąd : " + e.getMessage());
        }
    }

    private static Map<String, Integer> countWordOccurrences(File file) throws FileNotFoundException {
        Map<String, Integer> wordFrequencyMap = new HashMap<>();

        try (Scanner scanner = new Scanner(file)) {
            scanner.useDelimiter("[^\\p{L}]+");

            while (scanner.hasNext()) {
                String word = scanner.next().toLowerCase();
                wordFrequencyMap.put(word, wordFrequencyMap.getOrDefault(word, 0) + 1);
            }
        }

        return wordFrequencyMap;
    }
}
