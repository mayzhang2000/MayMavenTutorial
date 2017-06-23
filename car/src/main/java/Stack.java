import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by mayz985 on 9/19/16.
 */
public class Stack<E extends Car> {

    LinkedList<E> list = new LinkedList<>();
    Stack() {
    }

   public void push(E object) {
       list.add(object);
   }

    public E pop() {
        return list.remove(0);
    }

    public Car peek() {
        return list.peek();
    }
    public static void main(String[] args) {

        List<Integer>[] a = (List<Integer>[]) new List [10];
        List<Integer>[] d = new List[10];

        List<Integer>[] b =(List<Integer>[]) new List[10];

        Integer [] c = new Integer[10];

        String [] s = new String[10];
        Object [] o = new Object[10];



        Stack<Car> myStack = new Stack();
        Car car = new Car();
        myStack.push(new Car());
        myStack.push(new CarSubClass());
try {
    System.out.println(myStack.peek());
    final FileInputStream fis = new FileInputStream("/tmp/file");
    final ObjectInputStream ois = new ObjectInputStream(fis);


    final boolean bool = ois.readBoolean();
    final int number = ois.readInt();
    final int number1 = ois.readInt();
    final String string = ois.readUTF();

    System.out.println();


}catch (Exception e) {
    System.out.println(e.getStackTrace() + e.getMessage());
}

    }


}
