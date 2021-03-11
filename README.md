# Validity Checker

A program for validation of data, primarily for:

1. Swedish social security numbers in the format YYYYMMDDXXXX (ValidityCheckerSSN.java)
2. Swedish car registration numbers in the format ABC123 (ValidityCheckerCar.java)

## Instructions

Compile and run Main.java in the terminal by entering:

1. **javac Main.java**
2. **java Main**

This opens up a menu from which it is possible to navigate to the different validity checker programs.

## Files

- ValidityChecker.java - The parent class which has the common methods of the extending classes, such as null check and setup of the logging.
- ValidityCheckerSSN.java - The class for validating Swedish social security numbers. The class extends ValidityChecker to invoke its methods.
- ValidityCheckerCar.java - The class for validating Swedish car registration numbers. The class extends ValidityChecker to invoke its methods.
- Main.java - A Main file to connect the two programs and enable navigation.

When either one of the programs run a log file is created in the src folder, where invalid user data is saved. The invalid data is also printed in the console.
