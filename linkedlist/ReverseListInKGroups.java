package linkedlist;

public class ReverseListInKGroups {

    public static void main(String[] args) {
        // Example usage
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ReverseListInKGroups reverseListInKGroups = new ReverseListInKGroups();
        ListNode result = reverseListInKGroups.reverseKGroup(head, 2);

        // Print the reversed list
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {

        if (head == null || head.next == null) return head;

        ListNode lastNode = head;
        int count = 0;
        ListNode temp = null;
        while (temp != null) {
            while (count < k) {
                temp = temp.next;
                count++;
            }
            lastNode = temp;

        }

        ListNode newHead = head;

        while (head != lastNode) {
            ListNode curr = head;
            ListNode back = null;

            int t = 0;
            while (t < k) {
                head = curr.next;
                curr.next = back;
                back = curr;
                curr = head;
                t++;
            }

            head = back;
        }

        return newHead;


    }
}
