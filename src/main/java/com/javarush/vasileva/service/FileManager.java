package com.javarush.vasileva.service;

import com.javarush.vasileva.exceptions.Validation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileManager {

    public String readFile(String path) throws IOException {
        Path absolutePath = Validation.isPathExists(path);
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = Files.newBufferedReader(absolutePath)) {
            while (reader.ready()) {
                content.append(reader.readLine());
            }
        }
        return content.toString();
    }

    public void writeFile(String path, String content) throws IOException {
        Path absolutePath = Validation.isPathExists(path);
        try (BufferedWriter writer = Files.newBufferedWriter(absolutePath)) {
            writer.write(content);
        }
    }
}
