import java.util.HashMap;

public class IOU {
    private HashMap<String, Double> hashMap;

    public IOU() {
        hashMap = new HashMap<>();
    }

    public void setSum(String toWhom, double amount) {
        hashMap.put(toWhom, amount);
    }

    public double howMuchDoIOweTo(String toWhom) {
        return hashMap.getOrDefault(toWhom, 0.0);
    }
}
