import View.CLI;
import View.Manager;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws IOException {

        String folderPath = args[0];

        Path folder = Paths.get(folderPath);
        List<List<String>> listOflevls = new LinkedList<>();

        if (Files.isDirectory(folder)) {
            try (DirectoryStream<Path> stream = Files.newDirectoryStream(folder)) {
                for (Path entry : stream) {

                    if (Files.isRegularFile(entry)) {
                        List<String> oneLevel = Files.readAllLines(entry);
                        listOflevls.add(oneLevel);
                    }
                }
                Manager m = new Manager(listOflevls);
                m.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}