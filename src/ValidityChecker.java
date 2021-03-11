import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.Handler;
import java.util.Scanner;

public class ValidityChecker {
    public static Handler fileHandler = null;
    public static Logger LOGGER = Logger.getLogger(ValidityChecker.class.getName());
    public static Scanner scan = new Scanner(System.in);

    public static boolean noInput(String input) {
        if (input.isBlank()) {
            return true;
        } else {
            return false;
        }
    }

    // Setting up the logging
    public static void setup(String name) {

        try {
            fileHandler = new FileHandler("./logfile" + name + ".log");// file
            SimpleFormatter simple = new SimpleFormatter();
            fileHandler.setFormatter(simple);

            LOGGER.addHandler(fileHandler);// adding Handler for file

        } catch (IOException e) {
            System.out.println(e);
        }

    }

    public static void printErrorLog(String line) {
        System.out.println("---------------------------------------------------------------");
        System.out.println();
        System.out.println("LOG (also logged to file):");
        LOGGER.log(Level.INFO, line);
        System.out.println();
        System.out.println("---------------------------------------------------------------");

    }

}