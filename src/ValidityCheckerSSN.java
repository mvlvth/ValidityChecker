
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;

public class ValidityCheckerSSN extends ValidityChecker {

    public static void main(String[] args) {
        // setup for the logfile
        setup("SSN");
        while (true) {
            System.out.println("***************************************************************************");
            System.out.println("Enter your social security number (YYYYMMDDXXXX) (or press CTRL+C to exit):");
            String line = scan.nextLine();
            if (!noInput(line)) {
                // Logging invalid SSN:s
                if (!validityCheckerPersNo(line)) {
                    printErrorLog(line);

                }
            } else {
                System.out.println("Empty field! Please enter a social security number");
            }
        }

    }

    public static boolean validityCheckerPersNo(String line) {

        try {
            if (isDate(line.substring(0, 8))) {
                char[] charArray = line.toCharArray();
                int[] persNo = new int[charArray.length];
                try {
                    for (int i = 0; i < charArray.length; i++) {
                        persNo[i] = Integer.parseInt(String.valueOf(charArray[i]));

                    }
                    if (line.length() == 12 && isValidPersNo(persNo)) {
                        System.out.println("Success! Valid social security number!");
                        return true;
                    } else {
                        System.out.println("NOT a valid social security number!");
                        return false;

                    }
                } catch (Exception e) {
                    System.out.println("NOT a valid social security number: " + e);
                    return false;

                }
            } else {
                // Not a valid date/valid format
                return false;
            }
        } catch (Exception e) {
            System.out.println("Wrong format: " + e);
            return false;
        }
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
            // if a number is > 9 its two digits are added with each other)
            if (charArr.length > 1) {
                for (int j = 0; j < charArr.length; j++) {
                    // Adding the two digits that make up the number (which is >9) after converting
                    // it to an integer
                    sumOfANumber += Integer.parseInt(String.valueOf(charArr[j]));
                }
                sumOfPersNo += sumOfANumber;

                // Reset
                sumOfANumber = 0;

            } else {
                sumOfPersNo += tempNo;
            }

        }

        checkSum = (10 - (sumOfPersNo % 10)) % 10;
        if (checkSum == checkDigit) {
            // valid SSN
            return true;
        } else {
            return false;
        }

    }

    public static boolean isDate(String DOB) {

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("uuuuMMdd");

        try {
            // Revolverstyle strict to handle varying month lengths of february, leap year
            LocalDate dobDateFormat = LocalDate.parse(DOB, dateFormat.withResolverStyle(ResolverStyle.STRICT));
            // assuming the oldest person alive was born 1900
            LocalDate startDate = LocalDate.parse("19000101", dateFormat);
            // assuming SSN:s are not created/assigned before people are born
            LocalDate endDate = LocalDate.now();

            // checking the set date range
            if (dobDateFormat.isBefore(startDate) || dobDateFormat.isAfter(endDate)) {
                return false;
            } else {
                return true;
            }
        } catch (Exception e) {
            System.out.println("Not a valid date: " + e);
            return false;
        }

    }

}
