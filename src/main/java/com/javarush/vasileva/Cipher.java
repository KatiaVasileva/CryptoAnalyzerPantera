package com.javarush.vasileva;

import com.javarush.vasileva.constant.Alphabet;

import java.util.Map;

public class Cipher {
    private final Alphabet alphabet;

    public Cipher(Alphabet alphabet) {
        this.alphabet = alphabet;
    }

    public void encrypt(String originalFile, String encryptedFile, int key) {
        prepareFiles(originalFile, encryptedFile, key, true);
    }

    public void decrypt(String encryptedFile, String originalFile, int key) {
        prepareFiles(encryptedFile, originalFile, key, false);
    }

    public void prepareFiles(String src, String dest, int key, boolean isEncrypt) {
        FileManager fileManager = new FileManager();
        Map<Character, Integer> mapAlphabet = alphabet.getMapAlphabet(alphabet.getAlphabet());
        String content = fileManager.readFile(src);
        if (content == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();

        for (char c : content.toLowerCase().toCharArray()) {
            if (!mapAlphabet.containsKey(c)) {
                continue;
            }
            int index = mapAlphabet.get(c);
            int indexWithKey = isEncrypt ? (index + key) % mapAlphabet.size() : (index - key + mapAlphabet.size()) % mapAlphabet.size();
            sb.append(alphabet.getKeyByValue(mapAlphabet, indexWithKey));
        }

        fileManager.writeFile(dest, sb.toString());
    }
}
