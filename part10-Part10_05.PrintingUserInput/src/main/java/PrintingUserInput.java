
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrintingUserInput {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> stringList = new ArrayList<>();

        while(true) {
            String inputString = scanner.nextLine();

            if (inputString.equals("")) {
                break;
            }

            stringList.add(inputString);
        }

        stringList.stream()
                .forEach(string -> System.out.println(string));
    }
}
