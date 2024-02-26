import java.util.ArrayList;
import java.util.List;

public class Herd implements Movable {
    private List<Movable> herdList;

    public Herd() {
        herdList = new ArrayList<>();
    }

    public void addToHerd(Movable movable) {
        this.herdList.add(movable);
    }

    public void move(int dx, int dy) {
        for (Movable element : this.herdList) {
            element.move(dx, dy);
        }
    }

    public String toString() {
        String print = "";
        for (Movable element : this.herdList) {
            print = print + element.toString() + "\n";
        }
        return print;
    }
}
