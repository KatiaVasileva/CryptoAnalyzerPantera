package com.javarush.vasileva;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class ConsoleRunner {
    private static final Character[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о',
            'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я', '.', ',', '«', '»', '"',
            '\'', ':', '!', '?', ' '};

    public static void main(String[] args) {
        Alphabet alphabet = new Alphabet(ALPHABET);
        Map<Character, Integer> mapAlphabet = alphabet.getMapAlphabet(alphabet.getAlphabet());

        Scanner scanner = new Scanner(System.in);
        int key = scanner.nextInt();

        String sourcePath = "/Users/katiavasileva/IdeaProjects/CryptoAnalyzerPantera/text/testText.txt";
        String targetPath = "/Users/katiavasileva/IdeaProjects/CryptoAnalyzerPantera/text/testEncrypted.txt";

        try (BufferedReader reader = Files.newBufferedReader(Path.of(sourcePath));
             BufferedWriter writer = Files.newBufferedWriter(Path.of(targetPath))) {
            while (reader.ready()) {
                String line = reader.readLine();
                for(char c : line.toLowerCase().toCharArray()) {
                    int index;
                    if (mapAlphabet.containsKey(c)) {
                        index = mapAlphabet.get(c);
                    } else {
                        continue;
                    }
                    int indexWithKey = index + key;
                    if (indexWithKey < mapAlphabet.size()) {
                        writer.write(String.valueOf(alphabet.getKeyByValue(mapAlphabet, indexWithKey)));
                    } else {
                        writer.write(String.valueOf(alphabet.getKeyByValue(mapAlphabet, (index + key) % ALPHABET.length)));
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File is not found");
        } catch (IOException e) {
            System.out.println("Error reading file");
        }
    }
}
