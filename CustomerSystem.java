// Throughout this project, the use of data structures are not permitted such as methods like .split and .toCharArray

import java.util.Scanner;
// More packages may be imported in the space below

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

                enterCustomerInfo();
                String creditCardNum = reader.nextLine();
                validateCreditCard(creditCardNum);
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
        System.out.println("Enter your information \nPlease enter your: \nFirst name: ");
        String firstName = reader.nextLine();
        System.out.println("Last name: ");
        String lastName = reader.nextLine();
        System.out.println("City: ");
        String city = reader.nextLine();
        System.out.println("Postal Code (no spaces): ");
        String postalCode = reader.nextLine();
        System.out.println("Credit card number: ");
    }

    /*
     * This method may be edited to achieve the task however you like. The method
     * may not nesessarily be a void return type This method may also be broken down
     * further depending on your algorithm
     */
    public static void validatePostalCode() {
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
        //reverse the numbers of the credit cards
        String reverse = "";
        for (int i = len - 1; i >= 0; i--) {
            reverse = reverse + creditCardNum.charAt(i);
        }
        //add up all odd digits of reversed credit card
        int oddSum = 0;
        for (int i = 0; i < len; i += 2) {
            char sum = reverse.charAt(i);
            oddSum += Character.getNumericValue(sum);
        }
        //store the sum as an int
        int doubleSum = 0;
        
        for (int i = 1; i < len; i += 2) {
            //double the digits of the even numbers 
            int doubleDigits = Character.getNumericValue(reverse.charAt(i))* 2;
            //if any digit is greater than 9, add them up
            if (doubleDigits > 9) {
                doubleSum += (doubleDigits % 10) + 1;
                //add the doubled digits together and store as an int
            } else {
                doubleSum += doubleDigits;
            }
        }
        //add both sums together, and divide by 10, if there is no remainder than it is a valid credit card
        if((doubleSum+oddSum)%10 == 0){
            System.out.println("This is a valid credit card");
        //if there is a remainder than it is not a valid credit card
        }while((doubleSum+oddSum)%10 != 0){
            System.out.println("Credit Card information is incorrect, try again");
            doubleSum = 0;
            oddSum = 0;
            creditCardNum = reader.nextLine();
            len = creditCardNum.length();
        }

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