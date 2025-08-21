package com.javarush.vasileva;

import java.util.*;

public class ConsoleRunner {
    private static final Character[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о',
            'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я', '.', ',', '«', '»', '"',
            '\'', ':', '!', '?', ' '};

    public static void main(String[] args) {
        Alphabet alphabet = new Alphabet(ALPHABET);
        Cipher cipher = new Cipher(alphabet);

        Scanner scanner = new Scanner(System.in);
        int key = scanner.nextInt();

        String sourcePath = "/Users/katiavasileva/IdeaProjects/CryptoAnalyzerPantera/text/testText.txt";
        String targetPath = "/Users/katiavasileva/IdeaProjects/CryptoAnalyzerPantera/text/testEncrypted.txt";

        cipher.encrypt(sourcePath, targetPath, key);
        cipher.decrypt(targetPath, sourcePath, key);
    }
}
