import java.util.ArrayList;

public class BoxWithMaxWeight extends Box{
    private int capacity;
    private ArrayList<Item> items;

    public BoxWithMaxWeight(int capacity) {
        this.capacity = capacity;
        this.items = new ArrayList<>();
    }

    public int currentWeight() {
        int totalWeight = 0;

        for (int i = 0; i < items.size(); i++) {
            totalWeight += items.get(i).getWeight();    
        }

        return totalWeight;
    }

    @Override
    public void add(Item item) {
        if (currentWeight() + item.getWeight() <= this.capacity) {
            items.add(item);
        }
    }

    @Override
    public boolean isInBox(Item item) {
        return items.contains(item);
    }


}
