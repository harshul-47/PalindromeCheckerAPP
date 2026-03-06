import java.util.*;

public class PalindromeCheckerApp {

    // Stack Method
    public static boolean stackPalindrome(String input) {

        input = input.replaceAll("\\s+", "").toLowerCase();

        Stack<Character> stack = new Stack<>();

        for (char c : input.toCharArray()) {
            stack.push(c);
        }

        for (char c : input.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }

        return true;
    }

    // Deque Method
    public static boolean dequePalindrome(String input) {

        input = input.replaceAll("\\s+", "").toLowerCase();

        Deque<Character> deque = new ArrayDeque<>();

        for (char c : input.toCharArray()) {
            deque.addLast(c);
        }

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }

        return true;
    }

    // Two Pointer Method
    public static boolean twoPointerPalindrome(String input) {

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

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Stack Performance
        long startStack = System.nanoTime();
        boolean stackResult = stackPalindrome(input);
        long endStack = System.nanoTime();

        // Deque Performance
        long startDeque = System.nanoTime();
        boolean dequeResult = dequePalindrome(input);
        long endDeque = System.nanoTime();

        // Two Pointer Performance
        long startPointer = System.nanoTime();
        boolean pointerResult = twoPointerPalindrome(input);
        long endPointer = System.nanoTime();

        System.out.println("\nResults:");
        System.out.println("Stack Method: " + stackResult +
                " | Time: " + (endStack - startStack) + " ns");

        System.out.println("Deque Method: " + dequeResult +
                " | Time: " + (endDeque - startDeque) + " ns");

        System.out.println("Two Pointer Method: " + pointerResult +
                " | Time: " + (endPointer - startPointer) + " ns");

        scanner.close();
    }
}