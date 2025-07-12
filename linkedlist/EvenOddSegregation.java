package linkedlist;

public class EvenOddSegregation {

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode h1 = new ListNode(4);
        ListNode h2 = new ListNode(5);
        ListNode h3 = new ListNode(6);
        ListNode h4 = new ListNode(7);

        head.next = h1;
        h1.next = h2;
        h2.next = h3;
        h3.next = h4;

        EvenOddSegregation s = new EvenOddSegregation();
        ListNode listNode = s.oddEvenList(head);
        listNode.printLL(listNode);
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenHead;

        return head;

    }
}
