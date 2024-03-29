import java.util.ArrayList;
import java.util.HashMap;

public class DictionaryOfManyTranslations {
    private HashMap<String, ArrayList<String>> dictionary;

    public DictionaryOfManyTranslations() {
        dictionary = new HashMap<>();
    }

    public void add(String word, String translation) {
        dictionary.putIfAbsent(word, new ArrayList<String>());

        dictionary.get(word).add(translation);
    }

    public ArrayList<String> translate(String word) {
        ArrayList<String> emptyList = new ArrayList<>();

        return dictionary.getOrDefault(word, emptyList);
    }

    public void remove(String word) {
        dictionary.remove(word);
    }
}
