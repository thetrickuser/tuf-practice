package linkedlist;

public class Loops {

    public static void main(String[] args) {
        // Example usage
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = head.next; // Creating a loop for testing

        Loops loops = new Loops();
        int length = loops.findLengthOfLoop(head);
        System.out.println("Length of loop: " + length); // Output: Length of loop: 3
    }

    public int findLengthOfLoop(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode meetingPoint = null;

        int l = 0, d = 0;

        while (fast != null) {
            if (fast.next == null) return 0;

            fast = fast.next.next;
            slow = slow.next;
            l++;

            if (fast == slow) {
                meetingPoint = fast;
                break;
            }
        }

        if (fast == null) return 0;

        slow = head;

        if (slow == meetingPoint) return l;

        while (slow != meetingPoint) {
            if (fast == meetingPoint) {
                d = 0;
            }
            slow = slow.next;
            fast = fast.next;
            d++;
        }

        return d;
    }
}
