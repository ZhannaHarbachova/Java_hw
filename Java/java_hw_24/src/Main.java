import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        String fileName = "../data/text";
        List<String> words = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] lineWords = line.toLowerCase().split("[^A-Za-zА-Яа-яЁё']");
                for (String word : lineWords) {
                    words.add(word);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        words.removeIf(s -> s.trim().isEmpty() || s.contains(" "));

        Collections.sort(words);

        System.out.println("____________________________________________\n" +
                "Отсортированный список слов:\n" +
                "____________________________________________");

        for (String word : words) {
            System.out.println(word);
        }

        Map<String, Integer> countWorlds = new HashMap<>();
        int totalCount = 0;
        for (String word : words) {
            if (countWorlds.containsKey(word)) {
                countWorlds.put(word, countWorlds.get(word) + 1);
            } else {
                countWorlds.put(word, 1);
            }
            totalCount++;
        }

        System.out.println("____________________________________________\n" +
                "Список слов с частотностью:\n" +
                "____________________________________________");

        for (Map.Entry<String, Integer> entry : countWorlds.entrySet()) {
            System.out.print(entry.getKey() + ": " + entry.getValue() + ", ");
            System.out.printf("%.2f%%\n", (entry.getValue() * 100.0 / totalCount));
        }

        int maxCount = 0;
        for (Map.Entry<String, Integer> entry : countWorlds.entrySet()) {
            if (entry.getValue() > maxCount) maxCount = entry.getValue();
        }

        HashSet<String> worldsMaxCount = new HashSet<>();
        for (Map.Entry<String, Integer> entry : countWorlds.entrySet()) {
            if (entry.getValue() == maxCount) worldsMaxCount.add(entry.getKey());
        }

        System.out.print("____________________________________________\n" +
                "Слова с частотностью: ");
        System.out.printf("%.2f%%\n", maxCount * 100.0 / totalCount);
        System.out.println("____________________________________________");

        for (String word : worldsMaxCount) {
            System.out.println(word);
        }
    }
}