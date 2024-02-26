import java.util.ArrayList;
import java.util.HashMap;

public class StorageFacility {
    private HashMap<String, ArrayList<String>> tracker;

    public StorageFacility() {
        tracker = new HashMap<>();
    }

    public void add(String unit, String item) {
        tracker.putIfAbsent(unit, new ArrayList<>());
        tracker.get(unit).add(item);
    }

    public ArrayList<String> contents(String storageUnit) {
        ArrayList<String> emptyList = new ArrayList<>();

        return tracker.getOrDefault(storageUnit, emptyList);
    }

    public void remove(String storageUnit, String item) {
        if (tracker.get(storageUnit).contains(item)) {
            tracker.get(storageUnit).remove(item);
        }

        if (tracker.get(storageUnit).size() == 0) {
            tracker.remove(storageUnit);
        }
    }

    public ArrayList<String> storageUnits() {
        ArrayList<String> unitNames = new ArrayList<>();
        for (String stgUnit : tracker.keySet()) {
            if (tracker.get(stgUnit).size() != 0) {
                unitNames.add(stgUnit);
            }
        }

        return unitNames;

    }
}
