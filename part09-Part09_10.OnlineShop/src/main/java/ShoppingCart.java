import java.util.Map;
import java.util.HashMap;

public class ShoppingCart {
    private Map<String, Item> cart;

    public ShoppingCart() {
        this.cart = new HashMap<>();
    }

    public void add(String product, int price) {
        if (this.cart.keySet().contains(product)) {
            this.cart.get(product).increaseQuantity();
        } else {
            this.cart.put(product, new Item(product, 1, price));
        }
    }

    public int price() {
        int totalPrice = 0;
        for (String key : cart.keySet()) {
            totalPrice += cart.get(key).price();
        }
        return totalPrice;
    }

    public void print() {
        for (String key : cart.keySet()) {
            System.out.println(cart.get(key).toString());
        }
    }
}
