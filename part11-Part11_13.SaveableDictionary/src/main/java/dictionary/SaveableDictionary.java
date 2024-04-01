package dictionary;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.util.Iterator;

public class SaveableDictionary {
    private Map<String, String> dictionary;
    private String fileName;

    public SaveableDictionary() {
        this.dictionary = new HashMap<>();
    }

    public SaveableDictionary(String file) {
        this.dictionary = new HashMap<>();
        this.fileName = file;
    }

    public boolean load() {
        try {
            Scanner fileReader = new Scanner(new File(fileName));

            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                String[] parts = line.split(":");

                add(parts[0], parts[1]);
            }

            fileReader.close();

            return true;
        } catch (Exception e) {
            System.out.println("Error: " + e);

            return false;
        }
    }

    public boolean save() {
        try {
            PrintWriter writer = new PrintWriter(new File(fileName));

            for (Iterator<Map.Entry<String, String>> mapIterator = dictionary.entrySet().iterator(); mapIterator
                    .hasNext();) {
                Map.Entry<String, String> entry = mapIterator.next();
                writer.println(entry.getKey() + ":" + entry.getValue());
            }

            writer.close();
            return true;

        } catch (Exception e) {
            System.out.println("Error: " + e);
            return false;
        }
    }

    public void add(String words, String translation) {
        this.dictionary.putIfAbsent(words, translation);
    }

    public void delete(String word) {
        for (Iterator<Map.Entry<String, String>> mapIterator = dictionary.entrySet().iterator(); mapIterator
                .hasNext();) {
            Map.Entry<String, String> entry = mapIterator.next();
            if (entry.getKey().equals(word)) {
                mapIterator.remove();
            } else if (entry.getValue().equals(word)) {
                mapIterator.remove();
            }
        }
    }

    public String translate(String word) {
        for (Iterator<Map.Entry<String, String>> mapIterator = dictionary.entrySet().iterator(); mapIterator
                .hasNext();) {
            Map.Entry<String, String> entry = mapIterator.next();
            if (entry.getKey().equals(word)) {
                return entry.getValue();
            } else if (entry.getValue().equals(word)) {
                return entry.getKey();
            }
        }

        return null;
    }
}
