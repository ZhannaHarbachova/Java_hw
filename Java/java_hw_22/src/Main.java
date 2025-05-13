import java.io.*;

public class Main {

    private static final String VOWELS = "аеёиоуыэюяАЕЁИОУЫЭЮЯ";
    private static final String CONSONANTS = "бвгджзйклмнопрстфхцчшщБВГДЖЗЙКЛМНОПРСТФХЦЧШЩ";


    public static void main(String[] args) throws IOException {
        String firstFile = "../data/text.txt";
        String secondFile = "../data/new_text.txt";

        int countVowels = 0;
        int countConsonants = 0;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(firstFile));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(secondFile))) {
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String resLine = replaceChar(line);
                bufferedWriter.write(resLine);
                bufferedWriter.newLine();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(secondFile))) {
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                for (char ch : line.toCharArray()) {
                    if (VOWELS.indexOf(ch) >= 0) {
                        countVowels++;
                    } else if (CONSONANTS.indexOf(ch) >= 0) {
                        countConsonants++;
                    }
                }
            }
        }

        System.out.println("Количество гласных в файле: " + countVowels);
        System.out.println("Количество согласных в файле: " + countConsonants);

    }
    private static String replaceChar(String line) {
        StringBuilder result = new StringBuilder();

        for (char ch : line.toCharArray()) {
            if (VOWELS.indexOf(ch) >= 0) {
                result.append('а');
            } else if (CONSONANTS.indexOf(ch) >= 0) {
                result.append('м');
            } else {
                result.append(ch);
            }
        }

        return result.toString();
    }

}