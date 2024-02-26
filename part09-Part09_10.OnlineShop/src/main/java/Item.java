public class Item {
    private String product;
    private int productQuantity;
    private int unitPrice;

    public Item(String product, int qty, int unitPrice) {
        this.product = product;
        this.productQuantity = qty;
        this.unitPrice = unitPrice;
    }

    public int price() {
        return this.productQuantity * this.unitPrice;
    }

    public void increaseQuantity() {
        this.productQuantity++;
    }

    public String toString() {
        return this.product + ": " + this.productQuantity;
    }
}
