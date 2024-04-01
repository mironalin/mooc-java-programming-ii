
import java.util.Scanner;

public class MainProgram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.print("Input the name of the book, empty stops: ");
            String bookName = scanner.nextLine();
            
            System.out.print("Input the age recommendation: ");
            int ageRecom = Integer.valueOf(scanner.nextLine()); 
        }
    }

}
