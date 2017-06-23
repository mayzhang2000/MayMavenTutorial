package Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by mayz985 on 10/26/16.
 */
public class JumpOverNumber {


    public static void main(String[] args) {
        List<String> cells = Arrays.asList(
                "0,0,0",
                "0,0,0",
                "0,0,0"
        );
        System.out.println(count_the_paths(cells));


    }

    public static int count_the_paths(List<String> grid) {
        // Write your solution here
        int total = 0;
        String[][] cells = new String[grid.size()][];
        for (int i = 0; i<grid.size(); i++) {
            String[] cell = grid.get(i).split(",");
            cells[i] = cell;
        }

        List<Integer> totals = new ArrayList<>();
        travel(cells, 0, 0, total, totals);

        return total;
    }

    private static void travel(String[][] cells, int row, int column, int total, List<Integer> totals) {
        int totalRows = cells.length-1;
        int totalColumn = cells[0].length-1;

        //If already at the destination; add total to totals
        if (row == totalRows & column == totalColumn) {
            totals.add(total);
        }else if (row == totalRows) {
            //If you are already to last row, just go to the next column;
            total = total + (totalColumn - column);
            totals.add(total);

        }else if (column == totalColumn) {
            //If you are already to the last column; just go to the next row;
            total = total + (totalRows - row);
            totals.add(total);
        }else {
            //Otherwise, go left, then go right;
            total ++;
            travel(cells, row+1, column, total, totals);
            travel(cells, row, column+1, total, totals);
        }




    }

    static int  getNumberOfTimes(List<Integer> listNumber) {
        int times = 0;
        for (int i = 0; i< listNumber.size();) {
            if (listNumber.get(i) == 0 ) {
                times = -1;
                break;
            }else {
                times ++;
                i = i+ listNumber.get(i);

            }
        }
        return times;
    }

    static int digitSum(long number) {
        int sum = 0;

        if (number <0) {
            number = number * -1;
        }

        while (number >0 ) {
            sum = sum + (int)number % 10;
            number = number / 10;
        }

        return sum;
    }

    static boolean isPalindrome(long number) {
        boolean bResult = true;
        String input = (new Long(number)).toString();

        for (int i = 0; i<input.length()/2; i++) {
            if (input.charAt(i) != input.charAt(input.length() -1 -i)) {
                bResult = false;
            }
        }
        return bResult;
    }

    static int fibonacci(int n ) {
        int number = 1;

        if (n ==0 || n == 1) {
            number = 1;
        }else {
            number = fibonacci(n-2) + fibonacci(n-1);
        }

        return number;
    }

    public static List<Integer> longest_increasing_subsequence(List<Integer> sequence) {
        List<Integer> lenghList = new ArrayList<>();
        for (int i = 0; i< sequence.size(); i++) {
            lenghList.add(1);
        }

        for (int i = 1; i< sequence.size(); i++) {
            for (int j = 0; j<i; j++) {
                if (sequence.get(j) < sequence.get(i)) {
                    int max = lenghList.get(j) + 1;
                    if (max > lenghList.get(i)) {
                        lenghList.set(i, max);
                    }
                }
            }
        }

        int maxLength =  Collections.max(lenghList);
        int location = Collections.binarySearch(lenghList, maxLength);

        List<Integer> returnList = new ArrayList<>();
        returnList.add(sequence.get(location));

        int maxValue = sequence.get(location);
        for (int m = location-1; m> 0 ; m--) {
            if (sequence.get(m) < maxValue) {
                returnList.add(sequence.get(m));
                maxValue = sequence.get(m);

            }

        }

        return returnList;

    }

}
