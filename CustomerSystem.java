// Throughout this project, the use of data structures are not permitted such as methods like .split and .toCharArray

import java.util.Scanner;
// More packages may be imported in the space below

import java.io.FileNotFoundException;
import java.io.File;
import java.io.PrintWriter;

class CustomerSystemFinal {
    static String firstName, lastName, city, postalCode, creditCardNum, userCode;

    public static void main(String[] args) {
        // Please do not edit any of these variables
        Scanner reader = new Scanner(System.in);
        String userInput, enterCustomerOption, generateCustomerOption, exitCondition;
        enterCustomerOption = "1";
        generateCustomerOption = "2";
        exitCondition = "9";

        // Declare Customer ID
        int userCode = 0;
        
        do {
            printMenu(); // Printing out the main menu
            userInput = reader.nextLine(); // User selection from the menu

            if (userInput.equals(enterCustomerOption)) {
                enterCustomerInfo();
                userCode++;

                try{
                    validatePostalCode();

                }
                catch(Exception e){
                    System.out.println(e);
                }
              

        
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
     * may not necessarily be a void return type This method may also be broken down
     * further depending on your algorithm
     */

    public static void enterCustomerInfo() {
        Scanner reader = new Scanner(System.in);

        // input first and last name, city, and postal code
        System.out.print("Enter your information \nPlease enter your: \nFirst name: ");
        firstName = reader.nextLine();
        System.out.print("Last name: ");
        lastName = reader.nextLine();
        System.out.print("City: ");
        city = reader.nextLine();
        System.out.print("Postal Code (no spaces): ");
        postalCode = reader.nextLine();
        System.out.print("Credit card number: ");
        creditCardNum = reader.nextLine();
        reader.close();
    }

    /*
     * This method may be edited to achieve the task however you like. The method
     * may not necessarily be a void return type This method may also be broken down
     * further depending on your algorithm
     */
    public static void validatePostalCode() {

        // Length of code
        int length = postalCode.length();
        boolean validated = false;
        while (!validated){
            if (length >= 3) {
                //open file, file Name
                String file = "postal_codes.csv";
    
                //try, catch
                try {
    
                    //create file to reference
    
                    File sSheet = new File(file);
    
                    //read file
                    // initialize scanner
                    Scanner scanner = new Scanner(sSheet);
    
                    int count = 0;
    
                    while (scanner.hasNextLine()) {
    
                        // line exist
                        String line = scanner.nextLine();
                        // First three digit of postal code
                        String pCode3 = postalCode.substring(0, 3);
                        int index = line.indexOf(pCode3);
                        scanner.close();
    
                        //found code
                        if (index >= 0) {
                            count = count + 1;
                        }
                    }
                    // valid
                    if (count == 1) {
                        System.out.print("Valid Postal Code.");
                        validated = true;
                    }
    
                    //invalid
                    else {
                        System.out.print("Invalid Postal Code.");
                        validated = false;
                    }
                } catch (FileNotFoundException e) {
                    System.out.println(e);
    
                }
                // If length is less then three
                if (length < 3) {
                    System.out.println("Invalid postal code. Enter postal code of 3 characters or more:");
                    validated = false;

                }
            }
        }
        

    }

    /*
     * This method may be edited to achieve the task however you like. The method
     * may not necessarily be a void return type This method may also be broken down
     * further depending on your algorithm
     */

    public static void validateCreditCard() {
        Scanner reader = new Scanner(System.in);
        // count the numbers in the credit card
        int len = creditCardNum.length();
        // if the credit card numbers are less than 9 digits, tell them to try again

        int oddSum = 0;
        int doubleSum = 0;
        boolean validated = false;

        while (!validated) {
            oddSum = 0;
            doubleSum = 0;
            System.out.println("Credit Card information is incorrect, try again");
            creditCardNum = reader.nextLine();
            len = creditCardNum.length();

            String reverse = "";
            for (int i = len - 1; i >= 0; i--) {
                reverse = reverse + creditCardNum.charAt(i);
            }
            oddSum = 0;
            for (int i = 0; i < len; i += 2) {
                char sum = reverse.charAt(i);
                oddSum += Character.getNumericValue(sum);
            }
            doubleSum = 0;

            for (int i = 1; i < len; i += 2) {
                int doubleDigits = Character.getNumericValue(reverse.charAt(i)) * 2;
                if (doubleDigits > 9) {
                    doubleSum += (doubleDigits % 10) + 1;
                } else {
                    doubleSum += doubleDigits;
                }
            }
            if ((doubleSum + oddSum) % 10 == 0 && len > 9) {
                System.out.println("This is a valid credit card");
                validated = true;
            }
            reader.close();
        }
    }

    /*
     * This method may be edited to achieve the task however you like. The method
     * may not necessarily be a void return type This method may also be broken down
     * further depending on your algorithm
     */
    public static void generateCustomerDataFile() {
        Scanner reader = new Scanner(System.in);
        if (!creditCardNum.equals(false) && !postalCode.equals(false))){
            //Success input
            System.out.println("Your data file CSV will be generated.");
            System.out.println();

            //Prompt user for file name
            System.out.println("Name your file:");
            String fileName = reader.nextLine();
            File outFile = new File(fileName+".csv");
            PrintWriter out = new PrintWriter(outFile);

            if(outFile.exists()){
                System.out.println("File existing, overwrite?(y/n)");
                if (reader.nextLine().startsWith("y") || reader.nextLine().startsWith("Y")){
                    userCode = userCode + 1;

                    //print customer data
                    System.out.println("Customer Data file");
                    System.out.println("____________________");
                    System.out.println("User Id:" + userCode);
                    System.out.println("First Name:" + firstName);
                    System.out.println("Last Name:" + lastName);
                    System.out.println("City" + city);
                    System.out.println("Postal Code:" + postalCode);
                    System.out.println("Credit Card Number:" + creditCardNum);

                    System.out.println("");
                    System.out.println("Find your information at " + fileName + ".csv");

                }

            }
            out.close();
        }
    }
}
/*******************************************************************
 * ADDITIONAL METHODS MAY BE ADDED BELOW IF NECESSARY *
 *******************************************************************/
