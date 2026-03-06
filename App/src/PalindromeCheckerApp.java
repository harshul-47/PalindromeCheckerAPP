import java.util.Scanner;

class PalindromeChecker {

    // Method to check palindrome
    public boolean checkPalindrome(String input) {

        // Normalize the string (remove spaces and ignore case)
        input = input.replaceAll("\\s+", "").toLowerCase();

        int left = 0;
        int right = input.length() - 1;

        while (left < right) {
            if (input.charAt(left) != input.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Create object of PalindromeChecker class
        PalindromeChecker checker = new PalindromeChecker();

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Call the method
        boolean result = checker.checkPalindrome(input);

        if (result) {
            System.out.println("The string is a Palindrome.");
        } else {
            System.out.println("The string is NOT a Palindrome.");
        }

        scanner.close();
    }
}