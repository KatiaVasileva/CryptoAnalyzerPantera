package com.javarush.vasileva.exceptions;

import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Validation {

    public static Path isPathExists(String path) throws FileNotFoundException {
        Path absolutePath = Path.of("text/" + path).toAbsolutePath();
        if (!Files.exists(absolutePath)) {
            throw new FileNotFoundException("File " + path + " not found");
        }
        return absolutePath;
    }

    public static void isEmptyFile(String content) {
        if (content.isEmpty()) {
            throw new EmptyFileException();
        }
    }

    public static void isValidKey(int key, Character[] alphabet) {
        if (key <= 0 || key % alphabet.length == 0) {
            throw new InvalidKeyException();
        }
    }

    public static void isSuitableForBruteForce (String content) {
        if (!content.contains(" ") || content.length() < 1000) {
            throw new TextTooShortException();
        }
    }
}
