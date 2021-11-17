import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        String[] testPaths = new String[] { 
            "caso04.txt",
            "caso05.txt",
            "caso06.txt",
            "caso07.txt",
            "caso08.txt",
            "caso09.txt",
            "caso10.txt",
        };

        for (String testPath : testPaths) {
            TribeTree tribeTree = readTestCase(testPath);
            System.out.println(tribeTree.getFirstWarriorName());
        }
    }

    static TribeTree readTestCase(String testPath) {
        Path path = Paths.get("src/casos/" + testPath);

        try (BufferedReader reader = Files.newBufferedReader(path, Charset.defaultCharset())) {
            String aux[];
            String s = reader.readLine();

            Integer firstWarriorLands = 0;

            if (s != null)
                firstWarriorLands = Integer.parseInt(s);

            String line = null;

            TribeTree tribeTree = new TribeTree(firstWarriorLands);

            while ((line = reader.readLine()) != null) {
                aux = line.split(" ");
                
                String fatherName = aux[0];
                String childName = aux[1];
                Integer childLands = Integer.parseInt(aux[2]);

                if (tribeTree.getFirstWarriorName() == null) {
                    tribeTree.setFirstWarriorName(fatherName);
                }

                tribeTree.insert(fatherName, childName, childLands);
            }

            return tribeTree;
        } catch (IOException e) {
            System.err.format("An error ocurred reading the file: ", e);
        }

        return null;
    }
}