package zadania.dom.dom;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordCounter {

    public static void main(String[] args) {

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Wybierz plik do analizy");
        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {

            File selectedFile = fileChooser.getSelectedFile();
            String searchWord = JOptionPane.showInputDialog("Podaj szukane słowo:");

            if (searchWord != null && !searchWord.isEmpty()) {
                try {
                    int wordCount = countWordOccurrences(selectedFile, searchWord);
                    JOptionPane.showMessageDialog(null, "Słowo \"" + searchWord + "\" występuje " + wordCount + " razy.");
                } catch (FileNotFoundException e) {
                    JOptionPane.showMessageDialog(null, "Błąd odczytu pliku: " + e.getMessage());
                }
            } else {
                JOptionPane.showMessageDialog(null, "Nie podano słowa.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nie wybrano pliku.");
        }
    }

    private static int countWordOccurrences(File file, String searchWord) throws FileNotFoundException {
        int count = 0;

        try (Scanner scanner = new Scanner(file)) {
            scanner.useDelimiter("[^\\p{L}]+");

            while (scanner.hasNext()) {
                String word = scanner.next().toLowerCase();
                if (word.equals(searchWord.toLowerCase())) {
                    count++;
                }
            }
        }

        return count;
    }
}
