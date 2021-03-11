import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("******************************************************");
            System.out.println("Welcome to Validity Checker!");
            System.out.println("Choose one of the following (or press CTRL+C to exit):");
            System.out.println("1. Social Security Number Validity Checker (press 1 + enter)");
            System.out.println("2. Car Reg. Number Validity Checker (press 2 + enter)");

            String line = scan.nextLine();
            switch (line) {
                case "1":
                    ValidityCheckerSSN.main(null);
                    break;
                case "2":
                    ValidityCheckerCar.main(null);
                    break;
            }

        }
    }

}