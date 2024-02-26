import java.util.ArrayList;
import java.util.HashMap;

public class VehicleRegistry {
    private HashMap<LicensePlate, String> registry;

    public VehicleRegistry() {
        registry = new HashMap<>();
    }

    public boolean add(LicensePlate licensePlate, String owner) {
        if (registry.getOrDefault(licensePlate, null) == null) {
            registry.put(licensePlate, owner);
            return true;
        }
        
        return false;
    }

    public String get(LicensePlate licensePlate) {
        if (registry.getOrDefault(licensePlate, null) == null) {
            return null;
        }

        return registry.get(licensePlate);
    }

    public boolean remove(LicensePlate licensePlate) {
        for (LicensePlate license : registry.keySet()) {
            if (license.equals(licensePlate)) {
                registry.remove(licensePlate);
                return true;
            }
        }

        return false;
    }

    public void printLicensePlates() {
        for (LicensePlate license : registry.keySet()) {
            System.out.println(license);
        }
    }

    public void printOwners() {
        ArrayList<String> names = new ArrayList<>();

        for (LicensePlate licenses : registry.keySet()) {
            if (!names.contains(registry.get(licenses))) {
                names.add(registry.get(licenses));
                System.out.println(registry.get(licenses));
            }
        }
    }
}
