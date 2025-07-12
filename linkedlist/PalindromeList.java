package linkedlist;

public class PalindromeList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode h1 = new ListNode(2);
        ListNode h2 = new ListNode(1);
        ListNode h3 = new ListNode(1);
        head.next = h1;
        h1.next = h2;
        h2.next = h3;
        PalindromeList s = new PalindromeList();
        boolean isPalin = s.isPalindrome(head);
        System.out.println(isPalin);
    }

    public boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null) return true;

        ListNode mid = middleOfLinkedList(head);

        ListNode reverseHead = reverseList(mid);

        ListNode first = head;
        ListNode second = reverseHead;

        while (second != null) {
            if (first.val != second.val) {
                reverseList(reverseHead);
                return false;
            }
            first = first.next;
            second = second.next;
        }

        reverseList(reverseHead);

        return true;
    }

    public ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) return head;

        ListNode curr = head;
        ListNode back = null;

        while (curr != null) {
            head = curr.next;
            curr.next = back;
            back = curr;
            curr = head;
        }

        head = back;
        return head;


    }

    public ListNode middleOfLinkedList(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next == null ? fast.next : fast.next.next;
        }

        return slow;
    }
}
