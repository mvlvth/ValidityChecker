
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;

public class ValidityChecker {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Write your personnr YYYYMMDDXXXX");
        String line = scan.nextLine();
        if (isDate(line.substring(0, 8))) {
            char[] charArray = line.toCharArray();
            int[] persNo = new int[charArray.length];
            for (int i = 0; i < charArray.length; i++) {

                persNo[i] = Integer.parseInt(String.valueOf(charArray[i]));

            }
            if (line.length() == 12 && isValidPersNo(persNo)) {
                System.out.println("Valid personal number!");
            } else {
                System.out.println("NOT a valid personal number!");

            }
        } else {
            System.out.println("Not a valid date");
        }

        /*
         * String dob = "19911215"; if (isDate(dob)) { System.out.println("Date!");
         * System.out.println(dob);
         * 
         * } else { System.out.println("nope"); }
         */

    }

    public static boolean isValidPersNo(int[] persNo) {
        int checkDigit = persNo[persNo.length - 1];
        int sumOfPersNo = 0;
        int tempNo = 0;
        int sumOfANumber = 0;
        int checkSum = 0;

        for (int i = 2; i < persNo.length - 1; i++) {

            // Multiplying every other digit with 2 and 1
            tempNo = (i % 2 == 0) ? persNo[i] * 2 : persNo[i] * 1;

            char[] charArr = String.valueOf(tempNo).toCharArray();
            if (charArr.length > 1) {
                for (int j = 0; j < charArr.length; j++) {
                    // Adding the two digits that make up the number after converting it to an
                    // integer
                    sumOfANumber += Integer.parseInt(String.valueOf(charArr[j]));
                }
                sumOfPersNo += sumOfANumber;

                // Reset
                sumOfANumber = 0;

            } else {
                sumOfPersNo += tempNo;
            }
            // System.out.println("VARJE SIFFERSTEG: " + sumOfPersNo);

        }

        checkSum = (10 - (sumOfPersNo % 10)) % 10;
        // System.out.println("checkDigit: " + checkDigit);
        // System.out.println("checkSum: " + checkSum);
        if (checkSum == checkDigit) {
            return true;
        } else {
            return false;
        }

    }

    public static boolean isDate(String DOB) {

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("uuuuMMdd");

        try {
            // surround with try catch ifall ej giltigt datum
            // Revolverstyle strict to handle varying month lengths of february, leap year
            LocalDate dobDateFormat = LocalDate.parse(DOB, dateFormat.withResolverStyle(ResolverStyle.STRICT));
            LocalDate startDate = LocalDate.parse("19000101", dateFormat);
            LocalDate endDate = LocalDate.now();

            if (dobDateFormat.isBefore(startDate) || dobDateFormat.isAfter(endDate)) {
                return false;
            } else {
                return true;
            }
        } catch (Exception e) {
            return false;
        }

    }

    /*
     * // ha dessa i en parent class som ärvs nedåt i checkpersonnr och check
     * bilreg? // Göra tester? // Logga i separat fil och system out print public
     * static boolean isNull(String DOB) {
     * 
     * }
     * 
     * public static boolean isEmpty(String DOB) {
     * 
     * }
     * 
     * public static boolean isBlank(String DOB) {
     * 
     * }
     */
}
