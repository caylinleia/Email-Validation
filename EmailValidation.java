import java.util.Scanner;

/**
 * Caylin Leia (Student ID: 261125917)
 */

public class EmailValidation {
    /**
     * This program will have an email address input
     * and will determine if the email address inputted
     * is valid, as well as indicating where the error occurred
     */

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); // Scanner used to obtain the input of an email address
        System.out.println("Enter Email: "); // Prints a prompt for the user to input an email address
        String email = scan.nextLine(); // String used for the user to input an email address
        System.out.println(isValidEmail(email)); // Prints a message to determine the validity of the inputted email
        scan.close(); // Closes and ends the scanner
    }

    // Method to check if a character is alphanumeric
    public static boolean isAlphanumeric(char a) {
        boolean isAlpha = Character.isLetterOrDigit(a); // Verifying to determine if a character is a valid letter or digit within an inputted email
        return isAlpha; // Returns value if the character within an inputted email is alphanumeric
    }

    // Method to check if a character is a valid prefix character
    public static boolean isValidPrefixChar(char vpc) {
        boolean isValid = isAlphanumeric(vpc) || vpc == '_' || vpc == '.' || vpc == '-'; // Verifying to determine if a prefix within an inputted email is alphanumeric or has acceptable characters (as per instructions)
        return isValid; // Returns value if the characters within the prefix of an inputted email are valid
    }

    // Method to check if a character is a valid domain character
    public static boolean isValidDomainChar(char vdc) {
        boolean isValidDomain = isAlphanumeric(vdc) || vdc == '.' || vdc == '-'; // Verifying to determine if a domain within an inputted email contains alphanumeric and/or acceptable characters (as per instructions)
        return isValidDomain; // Returns value if the characters within the domain of an inputted email are valid
    }

    // Method to check if a String contains exactly one "@" character
    public static boolean exactlyOneAt(String e) {
        int count = 0; // Integer used to determine the occurrence of "@" character within an inputted email
        for (int i = 0; i < e.length(); i++) { // Loop used to go through every single character within the inputted email to check if there is an "@" character
            if (e.charAt(i) == '@') { // Count will be incremented by 1 each time the loop finds an "@" character at any index of the inputted email
                count++; // Post increment for count once previous condition is met
            }
        }
        if (count != 1) { // Verifying to determine if an inputted email contains too many "@" characters
            System.out.println("Error! Quantity of '@' character: " + count); // Prints an error message if an inputted email contains an insufficient or invalid amount of "@" character(s)
            return false; // Returns false if an inputted email contains an insufficient amount of "@" character
        }
        return true; // Returns value if an inputted email contains the precise and correct amount of "@" character
    }

    // Method to obtain the prefix of a possible email address
    public static String getPrefix(String gp) {
        if (exactlyOneAt(gp)) { // Verifying if the prefix and domain of an inputted email contains the "@" character to separate the prefix and domain
            return (gp.substring(0, gp.indexOf('@'))); // Returns the prefix from index 0 and index of "@" if previous condition returns true
        } else {
            return ("Error! Missing Character: '@'"); // Prints an error message if the inputted email is missing an "@" character or is unable to separate the prefix and domain
        }
    }

    // Method to obtain the domain of a possible email address
    public static String getDomain(String gd) {
        int gLength = gd.length(); // Integer used to determine the value for the length of the domain
        int indexAt = gd.indexOf('@') + 1; // Integer used to determine the beginning of the domain
        return (gd.substring(indexAt, gLength)); // Returns the substring of the domain to determine the beginning and end of the domain of an inputted email
    }

    // Method to check if the prefix of a possible email address is valid
    public static boolean isValidPrefix(String prefix) {
        for (int i = 0; i < prefix.length(); i++) { // Loop used to go through every character within the prefix of the inputted email
            if ((isValidPrefixChar(prefix.charAt(i))) == false) { // Verifying to determine if a character in the prefix of the inputted email is invalid (as per instructions)
                System.out.println("Error! Invalid prefix: " + "'" + prefix + "'"); // Prints an error message if the inputted email contains an invalid character within the prefix
                return false; // Returns false if the inputted email contains an invalid character within the prefix
            }
        }
        if ((prefix.contains("..")) || ((prefix.contains("--")) || (prefix.contains(".-")) || (prefix.contains("-.")))) { // Verifying to determine if the inputted email does not contain any double nor repeating invalid characters within the prefix
            System.out.println("Error! Invalid prefix: " + "'" + prefix + "'"); // Prints an error message if the inputted email contains any double or repeating invalid characters within the prefix
            return false; // Returns false if the inputted email contains any double or repeating invalid characters within the prefix
        }
        if (isAlphanumeric(prefix.charAt(0)) == false || isAlphanumeric(prefix.charAt(prefix.length() - 1)) == false) { // Verifying to determine if the inputted email contains alphanumeric characters within the prefix
            System.out.println("Error! Invalid prefix: " + "'" + prefix + "'"); // Prints an error message if the inputted email does not contain an alphanumeric character
            return false; // Returns false if the inputted email does not contain any alphanumeric characters within the prefix
        }
        return true; // Returns value if the inputted email contains valid alphanumeric characters within the prefix
    }

    // Method to check if the domain of a possible email address is valid
    public static boolean isValidDomain(String vd) {
        for (int i = 0; i < vd.length(); i++) { // Loop used to go through every character within the domain in the inputted email
            if (!isValidDomainChar(vd.charAt(i))) { // Verifying to determine if a character within the domain of an inputted email is invalid (as per instructions)
                System.out.println("Error! Invalid domain: " + "'" + vd + "'"); // Prints an error message if the inputted email contains an invalid character within the domain
                return false; // Returns false if the inputted email contains an invalid character within the domain
            }
        }
        int finalPeriod = 0; // Integer used to determine that there is no period at the end of the inputted email
        for (int i = 0; i < vd.length(); i++) { // Loop used to go through every character within the domain of an inputted email
            if (vd.charAt(i) == '.') { // Verifying to determine if there is a period at the end of the domain of an inputted email
                finalPeriod = i; // Integer used to determine the loop that is used to check if the domain does not end with an invalid period
            }
        }
        String startOfDomain = ""; // String used to determine the start of the domain of an inputted email
        for (int i = 0; i < finalPeriod; i++) { // Loop used to go through every character within the domain of an inputted email to check for an invalid period at the end of the domain
            startOfDomain = startOfDomain + vd.charAt(i); // String used to determine that the start of the domain includes the loop that checks the validity of the domain
        }
        String endOfDomain =  ""; // String used to determine if the end of the domain of an inputted email is valid
        endOfDomain = vd.substring(finalPeriod + 1); // String used to determine if the domain of an inputted email does not contain a final period nor digit
        if (startOfDomain.length() < 1) { // Verifying to determine if the domain within an inputted email contains only valid characters
            System.out.println("Error! Invalid start of domain: " + "'" + startOfDomain + "'"); // Prints an error message if the start of the domain within an inputted email contains invalid characters
            return false; // Returns false if the inputted email contains an invalid domain
        }
        if (endOfDomain.length() < 2) { // Verifying to determine that the domain within an inputted email ends with a valid character
            System.out.println("Error! Invalid end of domain: " + "'" + endOfDomain + "'"); // Prints an error message if the remainder of the domain within an inputted email contains invalid characters
            return false; // Returns false if the inputted email contains an invalid domain ending
        }
        return true; // Returns value if the inputted email contains a valid domain
    }
    // Method to check if a string is valid in a possible email address
    public static boolean isValidEmail(String email) {
        if ((exactlyOneAt(email) == true) && (isValidPrefix(getPrefix(email)) == true) && (isValidDomain(getDomain(email)) == true)) { // Verifying to determine if the inputted email is alphanumeric and has a valid prefix and domain
            System.out.println("Valid Email: " + email); // Prints message that the email that was inputted is valid
            return true; // Returns value if the inputted email is valid
        }
        System.out.println("Invalid Email: " + email); // Prints message that the email that was inputted is invalid
        return false; // Returns false if the inputted email is invalid and exits method
    }
}