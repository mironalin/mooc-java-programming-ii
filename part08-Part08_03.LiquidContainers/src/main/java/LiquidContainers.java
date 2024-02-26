
import java.util.Scanner;

public class LiquidContainers {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int first = 0;
        int second = 0;

        while (true) {
            System.out.print("First: " + first + "/100\n");
            System.out.print("Second: " + second + "/100\n");

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
                if (amount > 0) {
                    if (first + amount > 100) {
                        first = 100;
                    } else {
                        first += amount;
                    }
                }
            }

            // Move command
            if (command.equals("move")) {
                if (amount > 0) {
                    if (amount > first) {
                        if (second + first > 100) {
                            second = 100;
                        } else {
                            second += first;
                        }
                        first = 0;
                    } else {
                        if (second + amount > 100) {
                            second = 100;
                        } else {
                            second += amount;
                        }
                        first -= amount;
                    }
                }
            }

            // Remove command
            if (command.equals("remove")) {
                if (amount > 0) {
                    if (amount > second) {
                        second = 0;
                    } else {
                        second -= amount;
                    } 
                }
            }


        }
    }

}
