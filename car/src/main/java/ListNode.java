import java.util.*;

/**
 * Created by mayz985 on 3/5/16.
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode() {

    }
    ListNode(int value, ListNode nextNode) {
        this.val = value;
        this.next = nextNode;
    }

    public void setValue(int value) {
        this.val = value;
    }
    public int getValue() {
        return val;
    }
    public void setNext(ListNode next) {
        this.next = next;
    }
    public ListNode getNext() {
        return next;
    }

    public static ListNode reverseList(ListNode head) {
        return reverseList(head, null);


    }

    public static ListNode reverseList(ListNode head, ListNode previous) {
        //while there is next;
        if (head != null) {
            ListNode thisone = head;
            ListNode next = head.getNext();

            thisone.next = previous;


            return reverseList(next, thisone);
        }else {
            return previous;
        }


    }



    public boolean hasCycle(ListNode head) {
        ListNode walker = head;
        ListNode jogger = head;

        while(jogger.next != null && jogger.next.next != null) {
            walker = walker.next;
            jogger = jogger.next.next;
            if (walker == jogger) return true;
        }

        return false;

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> existingNodeSet = new HashSet<>();
        if (headA == null || headB == null) return null;

        while(headA != null) {
            existingNodeSet.add(headA);
            headA = headA.next;
        }

        while(headB != null) {
            if (existingNodeSet.contains(headB) )return headB;
            headB = headB.next;
        }

        return null;


    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode previous = null;
        ListNode current = head;



        while(current != null) {
            if (current.val == val) {
                if (previous != null) {
                    previous.next = current.next;
                    current = current.next;
                }else {
                    current = current.next;
                    head = current;

                }
            } else {
                previous = current;
                current = current.next;
            }
        }

        return head;


    }


//Reverse every word in the string
    public static void main(String[] args) {
        ListNode node1 = new ListNode(-129, null);
        ListNode node2 = new ListNode(-129, node1);

        isPalindrome(node2);
        System.out.println();
       // System.out.println(reversed.getValue());


    }



    public static ListNode reverse(ListNode input, ListNode previousIn) {
        ListNode previous = previousIn;
        ListNode current = input;
        ListNode next = input.getNext();

        current.setNext(previous);
        if (next != null)
                current = reverse(next, current);

        return current;
    }

    public static boolean isPalindrome(ListNode head) {
        List<Integer> listValues = new ArrayList<>();
        while(head != null) {
            listValues.add(head.val);
            head = head.next;
        }

        for (int i = 0; i<listValues.size()/2; i++) {
            if (listValues.get(i).intValue() != listValues.get(listValues.size()-1 -i).intValue()) {
                return false;
            }
        }
        return true;
    }


}
