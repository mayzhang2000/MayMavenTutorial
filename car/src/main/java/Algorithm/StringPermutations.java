package Algorithm;

import java.util.HashSet;
import java.util.Set;

/**
 * Java Program to find all permutations of a String
 * @author pankaj
 *
 */
public class StringPermutations {

    public static void main(String[] args) {
        premutation("", "123");
    }

    public static void premutation(String prefix, String input) {
        if(input.length() == 1) {
            System.out.println(prefix + input);
        }
        for (int i = 0; i<input.length(); i++ ) {
            premutation(prefix + input.substring(i, i+1), input.substring(0,i) + input.substring(i+1,input.length()));
        }
    }



}