package com.javarush.vasileva;

import java.util.Map;

import static com.javarush.vasileva.constant.Alphabet.*;

public class Cipher {

    public void encrypt(String originalFile, String encryptedFile, int key) {
        prepareFiles(originalFile, encryptedFile, key, true);
    }

    public void decrypt(String encryptedFile, String originalFile, int key) {
        prepareFiles(encryptedFile, originalFile, key, false);
    }

    public void prepareFiles(String src, String dest, int key, boolean isEncrypt) {
        FileManager fileManager = new FileManager();
        Map<Character, Integer> mapAlphabet = getMapAlphabet();
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
            int indexWithKey = isEncrypt ? (index + key) % mapAlphabet.size() : (index - key + Math.abs(key) * mapAlphabet.size()) % mapAlphabet.size();
            sb.append(getKeyByValue(mapAlphabet, indexWithKey));
        }

        fileManager.writeFile(dest, sb.toString());
    }
}
