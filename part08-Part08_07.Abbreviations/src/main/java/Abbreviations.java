import java.util.HashMap;

public class Abbreviations {
    private HashMap<String, String> abvMap;

    public Abbreviations() {
        abvMap = new HashMap<>();
    }

    public void addAbbreviation(String abbreviation, String explanation) {
        abvMap.put(abbreviation, explanation);
    }

    public boolean hasAbbreviation(String abbreviation) {
        if (abvMap.containsKey(abbreviation)) {
            return true;
        }

        return false;
    }

    public String findExplanationFor(String abbreviation) {
        if (hasAbbreviation(abbreviation)) {
            return abvMap.get(abbreviation);
        } else {
            return null;
        }
    }

    
}

