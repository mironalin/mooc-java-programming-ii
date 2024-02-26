import java.util.ArrayList;

public class Box implements Packable {
    private ArrayList<Packable> boxContent;
    private double maxWeight;

    public Box(double maxWeight) {
        boxContent = new ArrayList<>();
        this.maxWeight = maxWeight;
    }

    public double weight() {
        double weight = 0.0;
        for (int i = 0; i < boxContent.size(); i++) {
            weight += boxContent.get(i).weight();
        }

        return weight;
    } 

    public void add(Packable packageToBeAdded) {
      if (this.weight() + packageToBeAdded.weight() <= this.maxWeight) {
        boxContent.add(packageToBeAdded);
      }  
    }

    public String toString() {
        return "Box: " + boxContent.size() + " items, total weight " + this.weight() + " kg";  
    }


}
