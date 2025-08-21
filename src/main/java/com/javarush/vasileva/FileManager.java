package com.javarush.vasileva;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileManager {

    public String readFile(String originalFile) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = Files.newBufferedReader(Path.of(originalFile))) {
            while (reader.ready()) {
                content.append(reader.readLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File is not found");
            return null;
        } catch (IOException e) {
            System.out.println("Error reading file");
            return null;
        }
        return content.toString();
    }

    public void writeFile(String encryptedFile, String content) {
        try (BufferedWriter writer = Files.newBufferedWriter(Path.of(encryptedFile))) {
            writer.write(content);
        } catch (IOException e) {
            System.out.println("Error writing file");
        }
    }
}
