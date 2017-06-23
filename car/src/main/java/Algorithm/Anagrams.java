package Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by mayz985 on 9/12/16.
 */
public class Anagrams {

    public static void main(String args[]) {
        Integer[] integers = {1, 2, 3, 4};
        System.out.println(binarySearch(integers, 3));
    }

    public static int binarySearch(Integer[] integers, int valueToFind) {
        int index = -1;
        int low = 0;
        int high = integers.length-1;

        while (low <= high) {
            int middle = low + (high-low)/2;
            if (integers[middle] == valueToFind) {
                index = middle;
            }
            if (integers[middle] > valueToFind) {
                //get the first half
                high = middle -1;
            }else {
                low = middle +1;
            }
        }


        return index;
    }

    int getMostWork(Integer[] folders, int workers ) {
        int low = folders[folders.length-1];
        int high = 0;
        for (int i = 0; i< folders.length -1; i++) {
            high = high + folders[i];
        }


        while(low <= high) {
            //understaome condition; move low or high as median
            //if meet condition; high = median
            //if not meet condition; low ++;
            int median = low + (high-low)/2;

            int people = 1;
            int workload = 0;

            for (int i = 1; i< folders.length -2; i++) {
                //First all of them should be less then median;

                //Then; go through this
                workload = workload + folders[i];
                if (workload < median ) {

                }else {
                    workload = 0;
                    people ++;
                }


            }

            if (people < workers) {
                high = median;

            }else {
                low ++;
            }

        }


        return low;
    }


}
