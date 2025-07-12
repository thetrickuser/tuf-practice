package linkedlist;

public class ZeroOneTwo {

    public static void main(String[] args) {
        ListNode h2 = new ListNode(2);
        ListNode h4 = new ListNode(0);
//        ListNode h5 = new ListNode(2);
//        ListNode h8 = new ListNode(2);
//        ListNode h7 = new ListNode(1);

//        head.next = h1;
//        h1.next = h2;
        h2.next = h4;
//        h3.next = h4;
//        h4.next = h5;
//        h5.next = h6;
//        h6.next = h7;
//        h5.next = h8;
//        h8.next = h7;
        ZeroOneTwo s = new ZeroOneTwo();
        ListNode sortedList = s.sortList(h2);
        sortedList.printLL(sortedList);
    }

    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode zeroHead = null;
        ListNode oneHead = null;
        ListNode twoHead = null;
        ListNode one = null, zero = null, two = null;

        while (head != null) {
            switch (head.val) {
                case 0 -> {
                    if (zeroHead == null) {
                        zeroHead = head;
                        zero = zeroHead;
                    } else {
                        zero.next = head;
                        zero = zero.next;
                    }
                }
                case 1 -> {
                    if (oneHead == null) {
                        oneHead = head;
                        one = oneHead;
                    } else {
                        one.next = head;
                        one = one.next;
                    }
                }
                case 2 -> {
                    if (twoHead == null) {
                        twoHead = head;
                        two = twoHead;
                    } else {
                        two.next = head;
                        two = two.next;
                    }
                }
            }

            head = head.next;
        }

        if (zero != null) {
            zero.next = oneHead != null ? oneHead : twoHead;
        }
        if (one != null) {
            one.next = twoHead;
        }
        if (two != null) {
            two.next = null;
        }

        return (zeroHead != null) ? zeroHead : (oneHead != null) ? oneHead : twoHead;


    }
}
