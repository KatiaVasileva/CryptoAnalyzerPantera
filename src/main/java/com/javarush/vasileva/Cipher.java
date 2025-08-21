package com.javarush.vasileva;

import java.util.Map;

public class Cipher {
    private final Alphabet alphabet;

    public Cipher(Alphabet alphabet) {
        this.alphabet = alphabet;
    }

    public void encrypt(String originalFile, String encryptedFile, int key) {
        FileManager fileManager = new FileManager();
        Map<Character, Integer> mapAlphabet = alphabet.getMapAlphabet(alphabet.getAlphabet());
        String content = fileManager.readFile(originalFile);
        if (content == null) {
            return;
        }
        StringBuilder encrypted = new StringBuilder();

        for (char c : content.toLowerCase().toCharArray()) {
            if (!mapAlphabet.containsKey(c)) {
                continue;
            }
            int index = mapAlphabet.get(c);
            int indexWithKey = (index + key) % mapAlphabet.size();
            encrypted.append(alphabet.getKeyByValue(mapAlphabet, indexWithKey));
        }

        fileManager.writeFile(encryptedFile, encrypted.toString());
    }

    public void decrypt(String encryptedFile, String originalFile, int key) {
        FileManager fileManager = new FileManager();
        Map<Character, Integer> mapAlphabet = alphabet.getMapAlphabet(alphabet.getAlphabet());
        String content = fileManager.readFile(encryptedFile);
        if (content == null) {
            return;
        }
        StringBuilder decrypted = new StringBuilder();

        for (char c : content.toLowerCase().toCharArray()) {
            if (!mapAlphabet.containsKey(c)) {
                continue;
            }
            int index = mapAlphabet.get(c);
            int indexWithKey = (index - key + mapAlphabet.size()) % mapAlphabet.size();
            decrypted.append(alphabet.getKeyByValue(mapAlphabet, indexWithKey));
        }

        fileManager.writeFile(originalFile, decrypted.toString());
    }
}
