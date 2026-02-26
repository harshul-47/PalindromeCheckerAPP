public class PalindromeCheckerApp {

    // Node class for singly linked list
    static class ListNode {
        char val;  // Using char for string characters
        ListNode next;
        ListNode(char val) {
            this.val = val;
            this.next = null;
        }
    }

    // Step 1: Convert string to linked list
    public static ListNode stringToList(String s) {
        if (s == null || s.isEmpty()) return null;

        ListNode head = new ListNode(s.charAt(0));
        ListNode current = head;
        for (int i = 1; i < s.length(); i++) {
            current.next = new ListNode(s.charAt(i));
            current = current.next;
        }
        return head;
    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHalf = reverseList(slow.next);

        return compareHalves(head, secondHalf);
    }

    private static ListNode reverseList(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;  // New head of reversed list
    }

    private static boolean compareHalves(ListNode firstHalf, ListNode secondHalf) {
        ListNode p1 = firstHalf, p2 = secondHalf;
        while (p2 != null) {
            if (p1.val != p2.val) return false;
            p1 = p1.next;
            p2 = p2.next;
        }
        return true;
    }

    public static void main(String[] args) {
        // Test cases
        String[] tests = {"racecar", "hello", "abba", "madam"};

        for (String test : tests) {
            ListNode head = stringToList(test);
            System.out.printf("%s -> %s%n",
                    test,
                    isPalindrome(head) ? "Palindrome ✓" : "Not Palindrome ✗"
            );
        }
    }
}
