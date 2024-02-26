
import java.util.Scanner;

public class LiquidContainers2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Container first = new Container();
        Container second = new Container();

        while (true) {
            System.out.println("First: " + first);
            System.out.println("Second: " +second);

            String input = scan.nextLine();
            System.out.println("");
            if (input.equals("quit")) {
                break;
            }

            String[] parts = input.split(" ");
            String command = parts[0];
            int amount = Integer.valueOf(parts[1]);

            // Add command
            if (command.equals("add")) {
                first.add(amount);
            }

            // Move command
            if (command.equals("move")) {
                if (first.contains() < amount) {
                    amount = first.contains();
                }
                second.add(amount);
                first.remove(amount);
            }

            // Remove command
            if (command.equals("remove")) {
                second.remove(amount);
            }
        }
    }

}
