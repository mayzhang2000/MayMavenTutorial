package Algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mayz985 on 9/12/16.
 */
public class FibonacciSequence {
    public List<Integer> getFibonacciSequence(int n) {
        List<Integer> lists = new ArrayList<Integer>();
        if (n == 0) return lists;
        if (n == 1) {
            lists.add(0);
            return lists;
        }
        if (n == 2) {
            lists.add(0);
            lists.add(1);
            return lists;
        }
        //For 3 and above
        lists = getFibonacciSequence(n-1);
        int next = lists.get(lists.size()-1) + lists.get(lists.size()-2);
        lists.add(next);
        return lists;
    }

    public Integer getNthValue(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        //If n = 3 and above
        Integer next = getNthValue(n-1) + getNthValue(n-2);
        return next;
    }

    public static void main(String[] args) {
        List fiboList = new FibonacciSequence().getFibonacciSequence(8);
        Integer next = (Integer) new FibonacciSequence().getNthValue(8);
        System.out.println(fiboList);
    }
}
