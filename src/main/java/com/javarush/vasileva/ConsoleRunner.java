package com.javarush.vasileva;

import com.javarush.vasileva.constant.Alphabet;

import java.util.*;

public class ConsoleRunner {

    public static void main(String[] args) {
        Alphabet alphabet = new Alphabet();
        Cipher cipher = new Cipher(alphabet);

        Scanner scanner = new Scanner(System.in);
        int key = scanner.nextInt();

        String originalFile = "/Users/katiavasileva/IdeaProjects/CryptoAnalyzerPantera/text/text.txt";
        String encryptedFile = "/Users/katiavasileva/IdeaProjects/CryptoAnalyzerPantera/text/encrypted.txt";
        String decryptedFile = "/Users/katiavasileva/IdeaProjects/CryptoAnalyzerPantera/text/decrypted.txt";

        cipher.encrypt(originalFile, encryptedFile, key);
        cipher.decrypt(encryptedFile, decryptedFile, key);
    }
}
