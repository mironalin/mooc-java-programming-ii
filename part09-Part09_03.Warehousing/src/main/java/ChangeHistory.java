import java.util.ArrayList;

public class ChangeHistory {
    private ArrayList<Double> history;

    public ChangeHistory() {
        history = new ArrayList<>();
    }

    public void add(double status) {
        history.add(status);
    }

    public void clear() {
        history.clear();
    }

    public String toString() {
        return history.toString();
    }

    public double maxValue() {
        if (history.isEmpty()) {
            return 0;
        }

        double largest = history.get(0);

        for (int i = 1; i < history.size(); i++) {
            if (largest < history.get(i)) {
                largest = history.get(i);
            }
        }

        return largest;
    }

    public double minValue() {
        if (history.isEmpty()) {
            return 0;
        }

        double smallest = history.get(0);

        for (int i = 1; i < history.size(); i++) {
            if (smallest > history.get(i)) {
                smallest = history.get(i);
            }
        }

        return smallest;
    }

    public double average() {
        if (history.isEmpty()) {
            return 0;
        }

        double sum = 0.0;

        for (int i = 0; i < history.size(); i++) {
            sum = sum + history.get(i);
        }

        return sum / history.size();
    }
}
