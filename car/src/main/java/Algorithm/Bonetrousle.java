package Algorithm;

/**
 * Created by mayz985 on 12/20/16.
 */
public class Bonetrousle {
    public static void main(String[] args) {
        int n = 12;
        int k = 8;
        int b = 3;

        int[] box = new int[b];

        int smalest = 0;
        for (int i = 1; i <= b; i++) {
            smalest = smalest  + i;
            box[i-1] = i;
        }

        int biggest = 0;
        for (int i = k; i> k-b; i-- ) {
            biggest = biggest + i;
        }

        if (n< smalest || n >biggest) {
            System.out.println("-1");
            return;
        }

        int remainingBiggest = k;

        for(int i = b; i>0; i--) {
            int total = getTotal(b, box);
            //go through each box; starting from the largest box
            if (total + remainingBiggest - i > n) {
                //Too much, go lower
                box[i-1] = n-(total -i);
                break;
            }else {
                //too little, get the max, then next
                box[i-1] = remainingBiggest;
                remainingBiggest --;
            }


        }
        System.out.println(box);
    }

    public static int getTotal (int b, int[] a) {
        int total = 0;
        for (int i = 0; i< b; i++) {
            total = total + a[i];
        }
        return total;
    }

}
