
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AverageOfNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> inputArray = new ArrayList<>();

        System.out.println("Input numbers, type \"end\" to stop.");

        while (true) {
            String inputLine = scanner.nextLine();
            if (inputLine.equals("end")) {
                break;
            }

            inputArray.add(inputLine);
        }
        
        double listAverage = inputArray.stream()
                .mapToInt(number -> Integer.valueOf(number))
                .average()
                .getAsDouble();


        System.out.println("average of the numbers:" + listAverage);

    }
}
