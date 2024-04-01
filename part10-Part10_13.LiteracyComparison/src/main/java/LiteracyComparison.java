
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class LiteracyComparison {

    public static void main(String[] args) {
        List<String> literacyList = new ArrayList<>();
        try {
            Files.lines(Paths.get("literacy.csv"))
                    .map(line -> line.split(","))
                    .filter(parts -> parts.length >= 6)
                    .sorted((p1, p2) -> {
                        return p1[5].compareTo(p2[5]);
                    })
                    .forEach(part -> literacyList.add(part[3] + " (" + part[4] + "), "
                            + String.format(part[2].trim().split(" ")[0]) + ", " + part[5]));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        literacyList.stream()
                .forEach(line -> System.out.println(line));
    }
}
