import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Warehouse {
    private Map<String, Integer> prices;
    private Map<String, Integer> stockMap;


    public Warehouse() {
        this.prices = new HashMap<>();
        this.stockMap = new HashMap<>();

    }
    public void addProduct(String product, int price, int stock) {
        this.prices.put(product, price);
        this.stockMap.put(product, stock);
    }

    public int price(String product) {
        return prices.getOrDefault(product, -99);
    }

    public int stock(String product) {
        return stockMap.getOrDefault(product, 0);
    }

    public boolean take(String product) {
        if (this.stock(product) > 0) {
            int valueToAdd = this.stock(product) - 1;
            this.stockMap.put(product, valueToAdd);
            return true;
        }

        return false;
    }

    public Set<String> products() {
        Set<String> productNames = new HashSet<>();

        for(String key : this.prices.keySet()) {
            productNames.add(key);
        }

        return productNames;
    }
}
