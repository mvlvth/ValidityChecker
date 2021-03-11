
import java.util.regex.*;

public class ValidityCheckerCar extends ValidityChecker {

    private static final String REGNOPATTERN = "[A-Za-z]{3}[0-9]{2}[A-Za-z0-9]{1}";
    private static Pattern pattern;
    private static Matcher matcher;

    public static void main(String[] args) {
        // setup for the logfile
        setup("Car");
        while (true) {
            System.out.println("**************************************************************************");
            System.out.println("Enter a car registration number (ABC123) (or press CTRL+C to exit):");
            String line = scan.nextLine();
            if (!noInput(line)) {

                // Logging invalid SSN:s
                if (!validityCheckerCar(line)) {
                    printErrorLog(line);
                }
            } else {
                System.out.println("Empty field! Please enter a registration number");
            }
        }
    }

    public static boolean validityCheckerCar(String line) {
        pattern = Pattern.compile(REGNOPATTERN);
        matcher = pattern.matcher(line);
        if (matcher.matches()) {
            System.out.println("Success! Valid car registration number.");
            return true;
        } else {
            System.out.println("Failure! Invalid car registration number.");
            return false;
        }

    }

}