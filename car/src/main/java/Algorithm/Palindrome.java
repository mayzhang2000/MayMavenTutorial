package Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * A palindrome is a word, or phrase, that when the letters are reversed, the spelling is the same. Some examples include, “eve,” “level,
 */
public class Palindrome {

    public static void main(String[] args) {
       // System.out.println(isPalidrome("aaaa"));
        //System.out.println(findLongestPalindrome("12321"));
        //System.out.println(findOccurance("babalabalabalatheend", "alabala"));

        Integer[] inputs = {1, 2, 3, 4, 5, 6, 7};
        int n = 3;

        for (int j = 0; j<n; j++ ) {
            Integer temp = inputs[inputs.length - 1];
            for (int i = inputs.length - 1; i > 0; i--) {
                inputs[i] = inputs[i - 1];
            }
            inputs[0] = temp;
        }
        System.out.println();
    }


   public static int findOccurance(String input, String toSearch) {
       int times = 0;
       int toSearchHash = toSearch.hashCode();
       int toSearchLength = toSearch.length();

       for (int i= 0; i<= input.length()-toSearchLength; i++) {
           //get substring
           String subString = input.substring(i, i+toSearchLength);
           if (subString.hashCode() == toSearchHash) {
               if (subString.equals(toSearch)) times++;
           }
       }
       return times;

   }


    public static boolean isPalidrome(String input) {
        boolean bResult = true;

        char[] inputChars = input.toCharArray();
        int charLength = inputChars.length;
        for (int i = 0; i< charLength/2; i++ ) {
            if( inputChars[i] != inputChars[charLength -1 -i]) {
                bResult = false;
            }
        }

        return bResult;
    }

    public static int findLongestPalindrome(String input) {
        int min = 1;
        int max = input.length();
        int maxLength = 1;
        boolean found = false;

        while(min<max) {
            found = false;
            //working on the mean;
            int mean = min+(max-min)/2;
            for (int i=0; i<input.length(); i++) {
                //Get sub string
                if (i+mean <=input.length()) {
                    if (isPalidrome(input.substring(i, i + mean))) {
                        found = true;
                        break;
                    }
                }else {
                    break;
                }
            }
            //if mean is happy, then min= mean; max not changed
            if (found) {
                min=mean;
                maxLength = min;
            }else {
                min++;
                max=mean;
            }
            //if mean is not happy, then min++; max = mean
        }
        return maxLength;
    }
}
