public class PalindromeCheckerApp {

    public static boolean isPalindrome(String input) {

        char[] characters = input.toCharArray();

        int left = 0;
        int right = characters.length - 1;

        while (left < right) {
            if (characters[left] != characters[right]) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        String test = "madam";

        if (isPalindrome(test)) {
            System.out.println(test + " is a Palindrome.");
        } else {
            System.out.println(test + " is NOT a Palindrome.");
        }
    }
}
