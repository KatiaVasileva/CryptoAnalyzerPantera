package com.javarush.vasileva.service;

import java.io.IOException;
import java.util.Map;

import static com.javarush.vasileva.constant.Alphabet.*;
import static com.javarush.vasileva.exceptions.Validation.*;

public abstract class Action implements ActionInterface{

    public void prepareFiles(String src, String dest, int key) throws IOException {
        FileManager fileManager = new FileManager();
        Map<Character, Integer> mapAlphabet = getMapAlphabet();
        String content = fileManager.readFile(src);
        isEmptyFile(content);

        StringBuilder sb = getDecryptedTextAsStringBuilder(key, content, mapAlphabet);

        fileManager.writeFile(dest, sb.toString());
    }

    public StringBuilder getDecryptedTextAsStringBuilder(int key, String content, Map<Character, Integer> mapAlphabet) {
        StringBuilder sb = new StringBuilder();

        for (char c : content.toLowerCase().toCharArray()) {
            if (!mapAlphabet.containsKey(c)) {
                continue;
            }
            int index = mapAlphabet.get(c);
            int indexWithKey = (index + key + Math.abs(key) * mapAlphabet.size()) % mapAlphabet.size();
            sb.append(getKeyByValue(mapAlphabet, indexWithKey));
        }
        return sb;
    }
}
