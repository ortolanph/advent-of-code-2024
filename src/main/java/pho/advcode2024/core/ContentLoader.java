package pho.advcode2024.core;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ContentLoader {

    public static List<String> load(String fileName) throws IOException {
        return Files.readAllLines(Path.of(fileName));
    }

}
