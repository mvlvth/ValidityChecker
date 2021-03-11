
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.*;

import java.io.IOException;

import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.SimpleFormatter;

public class ValidityCheckerCar extends ValidityChecker {

    // static Handler fileHandler = null;
    // private static Logger LOGGER
    // =Logger.getLogger(ValidityCheckerCar.class.getName());
    private static final String REGNOPATTERN = "[A-Za-z]{3}[0-9]{2}[A-Za-z0-9]{1}";
    private static Pattern pattern;
    private static Matcher matcher;

    public static void main(String[] args) {
        // setup for the logfile
        setup("Car");
        // Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("***************************************************************");
            System.out.println("Enter a car registration number (ABC123), press CTRL+C to exit:");
            String line = scan.nextLine();
            if (!noInput(line)) {

                // Logging invalid SSN:s
                if (!validityCheckerCar(line)) {

                    // System.out.println("-----------------------------------------------------------------------");
                    // System.out.println();
                    // System.out.println("LOG:");
                    // LOGGER.log(Level.INFO, line);
                    // System.out.println();
                    printErrorLog(line);

                }
            } else {
                System.out.println("Empty field! Please enter a registration number");
            }
        }

    }

    /*
     * public static void setup() {
     * 
     * try { fileHandler = new FileHandler("./logfileCar.log");// file
     * SimpleFormatter simple = new SimpleFormatter();
     * fileHandler.setFormatter(simple);
     * 
     * LOGGER.addHandler(fileHandler);// adding Handler for file
     * 
     * } catch (IOException e) { System.out.println(e); }
     * 
     * }
     */

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