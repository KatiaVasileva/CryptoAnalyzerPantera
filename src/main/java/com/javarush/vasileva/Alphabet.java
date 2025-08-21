package com.javarush.vasileva;

import java.util.HashMap;
import java.util.Map;

public class Alphabet {
    private final Character[] alphabet;
    private final Map<Character, Integer> mapAlphabet = new HashMap<>();

    public Alphabet(Character[] alphabet) {
        this.alphabet = alphabet;
    }

    public Character[] getAlphabet() {
        return alphabet;
    }

    public Map<Character, Integer> getMapAlphabet(Character[] alphabet) {
        for (int i = 0; i < alphabet.length; i++) {
            mapAlphabet.put(alphabet[i], i);
        }
        return mapAlphabet;
    }

    public Character getKeyByValue(Map<Character, Integer> map, Integer value) {
        Character key = null;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (value.equals(entry.getValue())) {
                key = entry.getKey();
            }
        }
        return key;
    }
}
