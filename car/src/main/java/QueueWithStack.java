import java.util.Stack;

/**
 * Created by mayz985 on 3/9/16.
 */
public class QueueWithStack {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void enqueue(Integer input) {
        stack1.push(input);
    }

    public Integer dequeue() {
        //When it is time to dequeue, move from stack1 to stack2 if stack2 is empty, otherwise just pop
        if (stack2.empty()) {

           while (!stack1.empty() && stack1.peek() != null) {
               stack2.push(stack1.pop());
           }
        }

        return stack2.pop();
    }

    public static void main(String[] args) {
        QueueWithStack theQueue = new QueueWithStack();
        theQueue.enqueue(1);
        theQueue.enqueue(3);
        theQueue.enqueue(5);

        System.out.println(theQueue.dequeue());
        System.out.println(theQueue.dequeue());
        System.out.println(theQueue.dequeue());
    }
}
