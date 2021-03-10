
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.*;

import java.io.IOException;

import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.SimpleFormatter;

public class ValidityCheckerCar {

    static Handler fileHandler = null;
    private static Logger LOGGER = Logger.getLogger(ValidityCheckerCar.class.getName());
    private static final String REGNOPATTERN = "[A-Za-z]{3}[0-9]{2}[A-Za-z0-9]{1}";
    private static Pattern pattern;
    private static Matcher matcher;

    public static void main(String[] args) {
        // setup for the logfile
        setup();
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("***************************************************************");
            System.out.println("Enter a car registration number (ABC123), press CTRL+C to exit:");
            String line = scan.nextLine();
            // Logging invalid SSN:s
            if (!validityCheckerCar(line)) {
                LOGGER.log(Level.INFO, line);
            }
        }

    }

    public static void setup() {

        try {
            fileHandler = new FileHandler("./logfileCar.log");// file
            SimpleFormatter simple = new SimpleFormatter();
            fileHandler.setFormatter(simple);

            LOGGER.addHandler(fileHandler);// adding Handler for file

        } catch (IOException e) {
            System.out.println(e);
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