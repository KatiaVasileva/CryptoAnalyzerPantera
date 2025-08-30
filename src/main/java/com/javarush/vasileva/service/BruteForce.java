package com.javarush.vasileva.service;

import com.javarush.vasileva.entity.Request;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static com.javarush.vasileva.constant.Alphabet.getMapAlphabet;
import static com.javarush.vasileva.exceptions.Validation.*;

public class BruteForce extends Action{
    @Override
    public void execute(Request request) throws IOException {
        Map<Character, Integer> mapAlphabet = getMapAlphabet();

        for (int i = 1; i < mapAlphabet.size(); i++) {
            FileManager fileManager = new FileManager();

            String content = fileManager.readFile(request.getSourceFile());

            isEmptyFile(content);
            isSuitableForBruteForce(content);

            StringBuilder sb = getDecryptedTextAsStringBuilder(-1 * i, content, mapAlphabet);

            Map<Character, Integer> countCharactersMap = new HashMap<>();
            for (char c : sb.toString().toCharArray()) {
                countCharactersMap.put(c, countCharactersMap.getOrDefault(c, 0) + 1);
            }

            if (countCharactersMap.containsKey(' ') && countCharactersMap.get(' ').equals(Collections.max(countCharactersMap.values()))) {
                fileManager.writeFile(request.getTargetFile(), sb.toString());
                return;
            }
        }
    }
}
