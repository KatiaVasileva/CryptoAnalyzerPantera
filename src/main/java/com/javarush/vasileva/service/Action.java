package com.javarush.vasileva.service;

import java.util.Map;

import static com.javarush.vasileva.constant.Alphabet.*;

public abstract class Action implements ActionInterface{

    public void prepareFiles(String src, String dest, int key) {
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
            int indexWithKey = (index + key + Math.abs(key) * mapAlphabet.size()) % mapAlphabet.size();
            sb.append(getKeyByValue(mapAlphabet, indexWithKey));
        }

        fileManager.writeFile(dest, sb.toString());
    }
}
