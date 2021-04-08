// Throughout this project, the use of data structures are not permitted such as methods like .split and .toCharArray

import java.util.Scanner;
// More packages may be imported in the space below

import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

import java.io.BufferedReader;

class CustomerSystem {
    public static void main(String[] args) {
        // Please do not edit any of these variables
        Scanner reader = new Scanner(System.in);
        String userInput, enterCustomerOption, generateCustomerOption, exitCondition;
        enterCustomerOption = "1";
        generateCustomerOption = "2";
        exitCondition = "9";

        // More variables for the main may be declared in the space below

        do {
            printMenu(); // Printing out the main menu
            userInput = reader.nextLine(); // User selection from the menu

            if (userInput.equals(enterCustomerOption)) {
                // Only the line below may be editted based on the parameter list and how you
                // design the method return
                // Any necessary variables may be added to this if section, but nowhere else in
                // the code

                String fName = " ";
                String lName = " ";
                String pCode = " ";
                String cCardNum = " ";
                String city = " ";

                enterCustomerInfo(fName,lName,city,pCode,cCardNum);
                
                

                validatePostalCode(pCode);

                
                validateCreditCard(cCardNum);

            } else if (userInput.equals(generateCustomerOption)) {
                // Only the line below may be editted based on the parameter list and how you
                // design the method return
                generateCustomerDataFile();
            } else {
                System.out.println("Please type in a valid option (A number from 1-9)");
            }

        } while (!userInput.equals(exitCondition)); // Exits once the user types

        reader.close();
        System.out.println("Program Terminated");
    }

    public static void printMenu() {
        System.out.println("Customer and Sales System\n".concat("1. Enter Customer Information\n")
                .concat("2. Generate Customer data file\n").concat("3. Report on total Sales (Not done in this part)\n")
                .concat("4. Check for fraud in sales data (Not done in this part)\n").concat("9. Quit\n")
                .concat("Enter menu option (1-9)\n"));
    }

    /*
     * This method may be edited to achieve the task however you like. The method
     * may not nesessarily be a void return type This method may also be broken down
     * further depending on your algorithm
     */
    public static void enterCustomerInfo() {
        Scanner reader = new Scanner(System.in);

        // input first and last name, city, and postal code
        System.out.print("Enter your information \nPlease enter your: \nFirst name: ");
        String firstName = reader.nextLine();
        System.out.print("Last name: ");
        String lastName = reader.nextLine();
        System.out.print("City: ");
        String city = reader.nextLine();
        System.out.print("Postal Code (no spaces): ");
        String postalCode = reader.nextLine();
        System.out.print("Credit card number: ");
        String creditCardNum = reader.nextLine();

        return (firstName,lastName, city, postalCode, creditCardNum);
        reader.close();
    }

    /*
     * This method may be edited to achieve the task however you like. The method
     * may not nesessarily be a void return type This method may also be broken down
     * further depending on your algorithm
     */
    public static void validatePostalCode(String postalCode) {
        
        Scanner reader1 = new Scanner(System.in);
        // count the digits in postal code
        int postNum = postalCode.length();

        // if the postal code num is more then 3 or less then 3 digits

        while (postNum < 3) {
            System.out.print("This is not a valid postal code. Please enter your 3 digit postal code: ");
            postalCode = reader1.nextLine();
            postNum = postalCode.length();

        }
        
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("postal_codes.csv"));
            String line = reader.readLine();
            while(!(postalCode.equals(line))){
                System.out.println("This is not a valid postal code. Please enter your 3 digit postal code: ")
                postalCode = reader1.nextLine();
                postNum = postalCode.length();
            }
            

            reader.close();  
        }

        catch(IOException e) {
            e.printStackTrace();

        }

        

        
    }

    /*
     * This method may be edited to achieve the task however you like. The method
     * may not nesessarily be a void return type This method may also be broken down
     * further depending on your algorithm
     */
    public static void validateCreditCard(String creditCardNum) {
        Scanner reader = new Scanner(System.in);
        // count the numbers in the credit card
        int len = creditCardNum.length();
        // if the credit card numbers are less than 9 digits, tell them to try again
        while (len < 9) {
            System.out.println("This is not a valid credit card. Try again.");
            creditCardNum = reader.nextLine();
            len = creditCardNum.length();

        }
        String reverse = "";
        for (int i = len - 1; i >= 0; i--) {
            reverse = reverse + creditCardNum.charAt(i);
        }
        int oddSum = 0;
        for (int i = 0; i < len; i += 2) {
            char sum = reverse.charAt(i);
            oddSum += Character.getNumericValue(sum);
        }
        int doubleSum = 0;

        for (int i = 1; i < len; i += 2) {
            int doubleDigits = Character.getNumericValue(reverse.charAt(i)) * 2;
            if (doubleDigits > 9) {
                doubleSum += (doubleDigits % 10) + 1;
            } else {
                doubleSum += doubleDigits;
            }
        }
        System.out.println(doubleSum + oddSum);
        if ((doubleSum + oddSum) % 10 == 0) {
            System.out.println("This is a valid credit card");
        }
        while ((doubleSum + oddSum) % 10 != 0) {
            System.out.println("Credit Card information is incorrect, try again");
            creditCardNum = reader.nextLine();
            len = creditCardNum.length();
        }
        reader.close();

    }

    /*
     * This method may be edited to achieve the task however you like. The method
     * may not nesessarily be a void return type This method may also be broken down
     * further depending on your algorithm
     */
    public static void generateCustomerDataFile() {
    }
    /*******************************************************************
     * ADDITIONAL METHODS MAY BE ADDED BELOW IF NECESSARY *
     *******************************************************************/
}