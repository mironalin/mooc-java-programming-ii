
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LimitedNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbersList = new ArrayList<>();

        while(true) {
            int inputNumber = Integer.valueOf(scanner.nextLine());

            if (inputNumber < 0) {
                break;
            }

            numbersList.add(inputNumber);
        }

        numbersList.stream()
                .filter(number -> number > 0 && number < 6)
                .forEach(number -> System.out.println(number));
    }
}
