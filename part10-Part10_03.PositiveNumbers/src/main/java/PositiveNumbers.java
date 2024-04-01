
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class PositiveNumbers {

    public static List<Integer> positive(List<Integer> numbers) {
        ArrayList<Integer> positiveIntegers = numbers.stream()
                .filter(number -> number >= 0)
                .collect(Collectors.toCollection(ArrayList::new));
        
        return positiveIntegers;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // test your method here

        List<Integer> numbers = new ArrayList<>();

        numbers.add(3);
        numbers.add(2);
        numbers.add(-17);
        numbers.add(-5);
        numbers.add(7);

        numbers = positive(numbers);

        for(int i = 0; i < numbers.size(); i++) {
            System.out.println(numbers.get(i));
        }
        

    }

}
