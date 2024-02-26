public class Container {
    private int liters;

    public Container() {
        liters = 0;
    }

    public int contains() {
        return liters;
    }

    public void add(int amount) {
        if (amount > 0) {
            liters += amount;

            if (liters > 100) {
                liters = 100;
            }
        }
    }

    public void remove(int amount) {
        if (amount > 0) {
            if (liters < amount) {
                amount = liters;
            }

            liters -= amount;
        }
    }

    public String toString() {
        return liters + "/100";
    }
}
