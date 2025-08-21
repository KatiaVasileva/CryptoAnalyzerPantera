package com.javarush.vasileva;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public class Cipher {
    private final Alphabet alphabet;

    public Cipher(Alphabet alphabet) {
        this.alphabet = alphabet;
    }

    public void encrypt(String sourcePath, String targetPath, int key) {
        Map<Character, Integer> mapAlphabet = alphabet.getMapAlphabet(alphabet.getAlphabet());
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
                        writer.write(String.valueOf(alphabet.getKeyByValue(mapAlphabet, (index + key) % mapAlphabet.size())));
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File is not found");
        } catch (IOException e) {
            System.out.println("Error reading file");
        }
    }

    public void decrypt(String targetPath, String sourcePath, int key) {
        Map<Character, Integer> mapAlphabet = alphabet.getMapAlphabet(alphabet.getAlphabet());
        try (BufferedReader reader = Files.newBufferedReader(Path.of(targetPath));
             BufferedWriter writer = Files.newBufferedWriter(Path.of(sourcePath))) {
            while (reader.ready()) {
                String line = reader.readLine();
                for (char c : line.toLowerCase().toCharArray()) {
                    int index;
                    if (mapAlphabet.containsKey(c)) {
                        index = mapAlphabet.get(c);
                    } else {
                        continue;
                    }
                    int indexWithKey = index - key;
                    if (indexWithKey >= 0) {
                        writer.write(String.valueOf(alphabet.getKeyByValue(mapAlphabet, indexWithKey)));
                    } else {
                        writer.write(String.valueOf(alphabet.getKeyByValue(mapAlphabet, (indexWithKey + mapAlphabet.size()))));
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
