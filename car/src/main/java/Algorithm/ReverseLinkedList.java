package Algorithm;

import java.util.Stack;

/**
 * Created by mayz985 on 9/13/16.
 */
public class ReverseLinkedList {
    int value;
    ReverseLinkedList next;

    public ReverseLinkedList(int value, ReverseLinkedList next) {
        this.value = value;
        this.next = next;
    }

    public static ReverseLinkedList reverse(ReverseLinkedList input) {
       ReverseLinkedList current = input;
       ReverseLinkedList previous = null;
       ReverseLinkedList nextNode;
       while(current != null) {
           nextNode = current.next;
           current.next = previous;
           previous = current;
           current = nextNode;
       }

        System.out.println(previous);
        return previous;
    }

    public static void main(String[] args) {
        ReverseLinkedList l3 = new ReverseLinkedList(3, null);
        ReverseLinkedList l2 = new ReverseLinkedList(2, l3);
        ReverseLinkedList l1 = new ReverseLinkedList(1, l2);

        ReverseLinkedList.reverse(l1);
        System.out.println(l1);
    }

}
