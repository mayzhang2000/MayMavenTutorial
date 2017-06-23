package Algorithm;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by mayz985 on 1/13/17.
 */
public class BinarySearch {


    public static void main(String[] args) {
        int m = 4;

        Scanner scanner = new Scanner(System.in);
        int total = scanner.nextInt();
        IceCream[] iceCreams = new IceCream[total];
        for (int i = 0; i<total; i++) {
            IceCream iceCream = new IceCream(i, scanner.nextInt());
            iceCreams[i]= iceCream;
        }

        //Now i have got a bunch of icecreams, time to find the pair which has cost total = m;
        Arrays.sort(iceCreams);
        for (int i = 0; i< total; i++) {
            int price = m - iceCreams[i].price;
            int found = binarySearch(iceCreams, i+1, price, total -1);
            if (found != -1)
            System.out.println(iceCreams[i].price + ":" + iceCreams[found].price);
        }




    }

    public static int binarySearch(IceCream[] iceCreams, int beginning, int toMatch, int endding) {
        int index = -1;
        //Get the middle; compare with the middle
        //if toMatch is less than the middle; ending is the middle; search again
        //If toMatch is more than the middle; begging is the middle; search again
        //If toMatch is the same; return it

        if (beginning >= endding ) return index;
        if (beginning == endding) {
            if (iceCreams[beginning].price == toMatch) return beginning;
        }
        int middleIndex = beginning + (endding - beginning)/2;
        if (toMatch <iceCreams[middleIndex].price) {
            endding = middleIndex;
            index= binarySearch(iceCreams, beginning, toMatch, endding);
        }else if (toMatch >iceCreams[middleIndex].price) {
            beginning = middleIndex;
            index = binarySearch(iceCreams, beginning, toMatch, endding);
        }else if (toMatch == iceCreams[middleIndex].price) {
            index = middleIndex;
        }

        return index;
    }
}
