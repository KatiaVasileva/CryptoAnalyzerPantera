package com.javarush.vasileva.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileManager {

    public String readFile(String path) {
        StringBuilder content = new StringBuilder();
        Path absolutePath = Path.of("text/" + path).toAbsolutePath();
        try (BufferedReader reader = Files.newBufferedReader(absolutePath)) {
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

    public void writeFile(String path, String content) {
        Path absolutePath = Path.of("text/" + path).toAbsolutePath();
        try (BufferedWriter writer = Files.newBufferedWriter(absolutePath)) {
            writer.write(content);
            System.out.println("\nResult is OK");
        } catch (IOException e) {
            System.out.println("Error writing file");
        }
    }
}
