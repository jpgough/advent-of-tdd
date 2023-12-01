package org.advent.day01;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

public class ClasspathFileReader {

    public List<String> readAllLines(String filePath) {
        try {
            var classLoader = Thread.currentThread().getContextClassLoader();
            var path = Paths.get(Objects.requireNonNull(classLoader.getResource(filePath)).toURI());
            return Files.readAllLines(path);
        } catch (Exception ouch) {
            throw new RuntimeException(ouch);
        }
    }

}
