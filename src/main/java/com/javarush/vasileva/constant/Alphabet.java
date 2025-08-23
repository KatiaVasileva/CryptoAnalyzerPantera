package com.javarush.vasileva.constant;

import java.util.HashMap;
import java.util.Map;

public class Alphabet {
    private final Character[] alphabet = {'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о',
            'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я', '.', ',', '«', '»', '"',
            '\'', ':', '!', '?', ' '};
    private final Map<Character, Integer> mapAlphabet = new HashMap<>();

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
