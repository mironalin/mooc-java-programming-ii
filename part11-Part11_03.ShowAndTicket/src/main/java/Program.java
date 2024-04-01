import java.util.HashSet;
import java.awt.Point;

public class Program {

    public static int countDuplicateLocations(String movementString) {
        HashSet<Point> visitedLocations = new HashSet<>();
        Point currentLocation = new Point(0, 0); // Starting location

        for (char move : movementString.toCharArray()) {
            if (move == 'N') {
                currentLocation.setLocation(currentLocation.getX(), currentLocation.getY() + 1);
            } else if (move == 'S') {
                currentLocation.setLocation(currentLocation.getX(), currentLocation.getY() - 1);
            } else if (move == 'E') {
                currentLocation.setLocation(currentLocation.getX() + 1, currentLocation.getY());
            } else if (move == 'W') {
                currentLocation.setLocation(currentLocation.getX() - 1, currentLocation.getY());
            }

            if (visitedLocations.contains(currentLocation)) {
                visitedLocations.add(new Point((int) currentLocation.getX(), (int) currentLocation.getY()));
            } else {
                visitedLocations.add(new Point((int) currentLocation.getX(), (int) currentLocation.getY()));
            }
        }

        return visitedLocations.size();
    }

    public static void main(String[] args) {
        System.out.println(countDuplicateLocations("NS")); // Output: 1
        System.out.println(countDuplicateLocations("WEWNES")); // Output: 2
        System.out.println(countDuplicateLocations("SxWxNxN")); // Output: 0
    }
}
