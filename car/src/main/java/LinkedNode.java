/**
 * Created by mayz985 on 3/5/16.
 */
public class LinkedNode {
    int value;
    LinkedNode nextNode;

    LinkedNode(int value, LinkedNode nextNode) {
        this.value = value;
        this.nextNode = nextNode;
    }

    public void setValue(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
    public void setNextNode(LinkedNode nextNode) {
        this.nextNode = nextNode;
    }
    public LinkedNode getNextNode() {
        return nextNode;
    }

//Reverse every word in the string
    public static void main(String[] args) {
        LinkedNode node1 = new LinkedNode(1, null);
        LinkedNode node2 = new LinkedNode(2, node1);
        LinkedNode node3 = new LinkedNode(3, node2);
        LinkedNode reversed = reverse(node3, null);
        System.out.println(reversed.getValue());


    }

    public static LinkedNode reverse(LinkedNode input, LinkedNode previousIn) {
        LinkedNode previous = previousIn;
        LinkedNode current = input;
        LinkedNode next = input.getNextNode();

        current.setNextNode(previous);
        if (next != null)
                current = reverse(next, current);

        return current;
    }

}
