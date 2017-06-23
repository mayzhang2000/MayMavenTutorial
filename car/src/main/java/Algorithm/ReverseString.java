package Algorithm;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by mayz985 on 9/12/16.
 */
public class ReverseString {

    public static String newReverseString(String input) {
        char[] inputChars = input.toCharArray();
        int totalLength = inputChars.length;
        for (int i = 0; i<inputChars.length/2; i++) {
            char temp = inputChars[i];
            inputChars[i] = inputChars[totalLength -1 -i];
            inputChars[totalLength-1-i] = temp;
        }

        return new String(inputChars);
    }
    static void partition(int[] ar) {
        int pivot = ar[0];
        for (int i = 1; i<ar.length; i++) {
            //compare the current one with pivot,
            //if bigger, move on
            if (ar[i] <pivot)  {
                //if smaller, move all the ones bigger and equal to pivot
                //Then insert it.
                int location = 0;
                int smallValue = ar[i];
                for (int j = i-1; j>=0;j--) {
                    if (ar[j] == pivot) {
                        location = j;
                    }
                    if (ar[j]>= pivot) {
                        ar[j+1] = ar[j];
                    }
                }

                ar[location] = smallValue;
            }

        }

        printArray(ar);


    }

    static void printArray(int[] ar) {
        for(int n: ar){
            System.out.print(n+" ");
        }
        System.out.println("");
    }

    public static int[][] results = new int[15][15];

    public static int hammingDistance(int x, int y) {
        return Integer.bitCount(x^y);

    }
    public static int addDigits(int num) {
            String input = String.valueOf(num);




            if (input.length() == 1) {
                return Integer.parseInt(input);
            }else {
                String[] parts = input.split("");
                int total = 0;
                for (int i = 0; i< parts.length; i++) {
                    total = total + Integer.parseInt(parts[i]);
                }

                return addDigits(total);

            }

    }

    public static int[] constructRectangle(int area) {
         int w = (int) Math.sqrt(area);
        while (area%w != 0) w--;
        return new int[] {w, area/w};



    }

    public static String[] findRelativeRanks(int[] nums) {
        //build two dimension array to keep track of index.
        int[][] numWithIndex = new int[nums.length][2];
        for (int i = 0; i< nums.length; i++) {
            numWithIndex[i][0] = nums[i];
            numWithIndex[i][1] = i;
        }


        //Sort by descending
        Arrays.sort(numWithIndex, (a,b) -> b[0] - a[0]);

        //Populate the result
        String[] results = new String[nums.length];
        for (int i = 0; i< nums.length; i++) {
            if (i == 0) {
                results[numWithIndex[i][1]] = "First Medal";
            } else if (i == 1) {
                results[numWithIndex[i][1]] = "Second Medal";
            } else {
                results[numWithIndex[i][1]] = String.valueOf(i + 1);
            }

        }
        return results;

    }

    public static void moveZeroes(int[] nums) {
        //go through the list, if is not zero, nothing needs to be done
        //If it is zero, then swap with the last non-zero.

        for(int i  = 0, j = nums.length -1; i< nums.length && i<j;) {
            if (nums[i] == 0) {
                if(nums[j] != 0) {
                    nums[i] = nums[j];
                    nums[j] = 0;
                    i++;
                    j--;
                }else {
                    //move j to non zero
                    while(nums[j] == 0) {
                        j--;
                    }
                }
            }else {
                i++;
            }
        }
        System.out.println();
    }

    public static void moveZeroes2(int[] nums) {
        //go through the list, if is not zero, nothing needs to be done
        //If it is zero, then swap with the next non zero

        for (int i = 0; i< nums.length-1; i++) {
            if (nums[i] ==0 ) {
                //find next non zero
                int index = -1;
                for(int j= i; j<nums.length; j++) {
                    if(nums[j] != 0) {
                        index = j;
                        break;
                    }
                }
                if(index!= -1) {
                    nums[i] = nums[index];
                    nums[index] = 0;
                }

            }
        }
        System.out.println();
    }

    public static int[] twoSum(int[] numbers, int target) {
        int[] results = new int[2];

        //use two pointer, lo and hi, if sum = target, this is it. if sum < target, lo ++; if sum >target, hi--
        int lo = 0;
        int hi = numbers.length -1;

        if (numbers[hi] + numbers[lo] == target) {
            results[0] = lo +1;
            results[1] = hi +1;
            return results;
        }

        while(numbers[hi] + numbers[lo] != target) {
            if (numbers[hi] + numbers[lo] > target ) {
                hi--;
            }else if (numbers[hi] + numbers[lo] < target ) {
                lo++;
            }
        }

        results[0] = lo +1;
        results[1] = hi +1;
        return results;
    }

    public static int findContentChildren(int[] g, int[] s) {
        //sort both arrays
        Arrays.sort(g);
        Arrays.sort(s);
        int total = 0;

        //search lo and hi;
        //Go through each cookie from the largest, find the greedy factor from hi to low to find the one just below it.
        //if find, then increase 1. and move hi range down to the one below this.
        int hi = g.length -1;
        for (int i = s.length -1; i>= 0; i--) {
            for (int j = hi; j>= 0;) {
                if (g[j] > s[i]) {
                    j--;

                }else {
                    total ++;
                    hi = --j;
                    break;
                }
            }
        }

        return total;


    }

    public static int minMoves(int[] nums) {
        int total = 0;

       int a = 7%2;
        int b = 7/2;

        return total;

    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        boolean status = true;
        int[] randomOcc = new int[26];
        int[] magazinOcc = new int[26];

        //Go through each list, to count the number of each letter occurances
        for (int i = 0; i<ransomNote.length(); i++) {
            randomOcc[ransomNote.charAt(i) - 'a'] ++;
        }

        for (int i = 0; i<magazine.length(); i++) {
            magazinOcc[magazine.charAt(i) - 'a'] ++;
        }

        //Then go through the occurances, if there is one magazine occrances is less than ransomNote, return false;
        for (int i = 0; i<26; i++) {
            if (magazinOcc[i] < randomOcc[i]) status = false;
        }

        return status;
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        //dedup, sort, then return which contains.
        List<Integer> unique1 = IntStream.of(nums1).distinct().boxed().collect(Collectors.toList());

       int results[] =  IntStream.of(nums2).distinct().filter(e->unique1.contains(e) ).toArray();
        return results;
    }

    public static int firstUniqChar(String s) {
        //build a index of number of times each letter is shown
        //go through the string to find the first letter with occurance of 1.
        int index = -1;
        int[] occurance = new int[26];
        for (char c: s.toCharArray()) {
            occurance[c-'a'] ++;
        }

        for (int i = 0; i< s.length(); i++) {
            if (occurance[s.charAt(i) -'a'] == 1) {
                index = i;
                break;
            }
        }
        return index;
    }

    public static int maxProfit(String s) {
        int result = 0;
        for (int i = 0; i<s.length(); i++) {
            result = result *26 + s.charAt(i) - 'A' + 1;
        }
        return result;

    }

    public static int majorityElement(int[] nums) {
        int occurance = 1;
        int major = nums[0];

        //go through the num, if next one is the same as major, occurance ++
        //if next one is not the same, occurance --
        //if occurance is already 0, populate it.

        for (int i = 1; i<nums.length; i++ ) {
            if (occurance == 0) {
                major = nums[i];
                occurance = 1;
            }else if (major == nums[i]) {
                occurance ++;
            }else {
                occurance --;
            }
        }

        return major;

    }

    public static boolean isAnagram(String s, String t) {
        //build index of each string, then compare these two arrays.
        boolean bSame = true;
        int[] sIndex = new int[26];
        int[] tIndex = new int[26];

        for(char c: s.toCharArray()) {
            sIndex[c-'a'] ++;
        }

        for(char c: t.toCharArray()) {
            tIndex[c-'a'] ++;
        }

        for (int i = 0; i<26; i++) {
            if (sIndex[i] != tIndex[i]) {
                bSame = false;
                break;
            }
        }
        return bSame;
    }

    public static int longestPalindrome(String s) {
        int length = 0;
        List<Character> lists = new ArrayList<>();
        //go through the list of chars, has two sets. one is the set what i first visit
        //if first visit does not have it, add it to first visit list.
        //if first visit has it already, add 2 to longest, and remove the one visit already
        for (char c: s.toCharArray()) {
            if (lists.contains(new Character(c))) {
                lists.remove(new Character(c));
                length = length +2;
            }else {
                lists.add(new Character(c));
            }
        }
        //at the end if first visit is longer than 0, add 1 to longest
        if (lists.size() >0) length++;

        return length;
    }

    public List<String> readBinaryWatch(int num) {
        //go through all of the time to get the binary bits total is the input
        List<String> times = new ArrayList<>();

        for (int hour = 0; hour <12; hour++) {
            for (int min = 0; min<60; min++) {
                //If total of bin are the name, get this time
                if (Integer.bitCount(hour) + Integer.bitCount(min) == num) {
                    String newString = String.format("%d:%02d", hour, min);
                    times.add(newString);
                }
            }
        }
        return times;

    }

    public boolean containsDuplicate(int[] nums) {
        //go through the list, if already set does not contain it, add it to the list.
        //if it is already there, return false. return
        boolean hasDuplicate = false;
        List<Integer> visitedList = new ArrayList<>();
        for (int num: nums) {
            if (visitedList.contains(new Integer(num))) {
                hasDuplicate = true;
                break;
            }else {
                visitedList.add(new Integer(num));
            }
        }

        return hasDuplicate;

    }

    public int[] intersect(int[] nums1, int[] nums2) {

        //first sort both of them
        //pick the first one i, go through the second one until second one is bigger than me.if find it add to the list

        Map<Integer, Integer> map = new HashMap<>();

        for (int i: nums1) {

            if(map.containsKey(i)){
                map.put(i, map.get(i)+1);

            }else {
                map.put(i, 1);
            }

        }

        List<Integer> results = new ArrayList<>();

        for (int i : nums2) {
            if(map.containsKey(i) && map.get(i) > 0) {
                results.add(i);
                map.put(i, map.get(i)-1);
            }
        }

            int[] resultsArray = new int[results.size()];
            for (int i = 0; i<results.size(); i++) {
                resultsArray[i] = results.get(i);
            }
            return resultsArray;
    }

    public static int missingNumber(int[] nums) {
        int missing = -1;

        Arrays.sort(nums);
        //First see if 0 is missing
        if (nums[0]!= 0) missing = 0;

                //go through the list, if next one is not current one + 1; then current one +1 is the missing one.
        if (missing == -1) {
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i + 1] != nums[i] + 1) {
                    missing = nums[i] + 1;

                }
            }
        }

        //If there is still no missing one the next one is the missing one
        if(missing == -1) missing = nums[nums.length-1] +1;

        return missing;

    }
    public int numberOfBoomerangs(int[][] points) {

        int total = 0;
        //for though the list, put in the map of the distance and the number of times it has the same distance.

        //Go through the map, count total.

        //Then move on to the next point.
        Map<Integer, Integer> distanceOccurance = new HashMap<>();

        for(int i = 0; i< points.length; i++) {
            for(int j = 0; j<points.length; j++) {
                if (i== j) continue;
                //get the distance
                int distance = getDistance(points[i], points[j]);
                distanceOccurance.put(distance, distanceOccurance.getOrDefault(distance, 0) + 1);
            }

            for (Integer occur: distanceOccurance.values()) {
                total = total + occur* (occur -1);
            }

            distanceOccurance.clear();
        }
        return total;
    }

    public static int getDistance(int[] point1, int[] point2) {
        int a = point1[0] - point2[0];
        int b = point1[1] - point2[1];

        return a*a + b*b;
    }


    public static String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = num1.length()-1, j = num2.length()-1; i>=0||j>=0||carry >0; i--, j--) {

            int one = i>=0? num1.charAt(i) - '0':0;
            int two = j>=0? num2.charAt(j) - '0':0;
            int sum = (one + two)%10 + carry;
            carry = (one + two + carry)/10;

            sb.append(sum);
        }


        return sb.reverse().toString();

    }

    public static String toHex(int num) {
        StringBuilder sb = new StringBuilder();
        //divid the number by 16, get the remainder and append it to the string.
        //while result != 0; repeat;

        int result = num;
        while(result != 0) {
            int orig = result;
            result = orig/16;
            int remainder = orig %16;
            String remainderString = null;
            if (remainder < 10) {
                remainderString = Integer.toString(remainder);
            }else if (remainder== 10 ){
                remainderString = "a";
            }else if (remainder== 11 ){
                remainderString = "b";
            }else if (remainder== 12 ){
                remainderString = "c";
            }else if (remainder== 13 ){
                remainderString = "d";
            }else if (remainder== 14 ){
                remainderString = "e";
            }else if (remainder== 15 ){
                remainderString = "f";
            }
            sb.append(remainderString);
        }

        return sb.reverse().toString();

    }

    public static int maxProfit(int[] prices) {
        int profit = 0;

        //go through the prices, if one is smaller than previous, then find the biggest remainning one.
        //the gap is the profit.

        //go to the next one, if next profit is bigger than use that.

        for (int i = 0; i< prices.length-1; i++) {
            if (prices[i+1] > prices[i]) {
                int basePrice = prices[i];
                int sellPrice = getMax(i+1, prices);
                if (sellPrice>basePrice) {
                    if (sellPrice - basePrice > profit)
                        profit = sellPrice-basePrice;
                }
            }
        }
        return profit;

    }

    public static int getMax(int startIndex, int[] prices) {
        int max = -1;
        if (startIndex >= prices.length) return max;

        for (int i = startIndex; i<prices.length; i++) {
            int price = prices[i];
            if (price > max) max = price;
        }

        return max;
    }

    public static List<Integer> getDigits(int n) {

        List<Integer> digits = new ArrayList<>();

        while(n >0 ){
            int remaining = n%10;
            digits.add(remaining);
            n = n/10;

        }

        return digits;

    }

    public static int getSumOfSquares(List<Integer> digits) {
        int sum = 0;
        for(Integer number: digits) {
            sum = sum + number * number;
        }
        return sum;
    }

    public static String translateToString(List<Integer> digits) {
        StringBuilder sb = new StringBuilder();
        Collections.sort(digits);

        for(Integer digit: digits) {
            sb.append(digit);
        }

        return sb.toString();

    }
    public static boolean isHappy(int n) {
        boolean bHappy = false;
        Set<String> checkedSet = new HashSet<>();

        if (n<0) return bHappy;

        while(n> 0) {
            //get the individial digits,
            List<Integer> digits = getDigits(n);
            //get the sum of each squares
            int sum = getSumOfSquares(digits);
            //if the sum is 1, done
            if (sum == 1) {
                return true;
            } else {
                //If sum is not 1, check if it is in the map
                String digitString = translateToString(digits);
                if (checkedSet.contains(digitString)) {
                    return false;
                } else {
                    checkedSet.add(digitString);
                    n = sum;
                }
            }
        }

        return bHappy;

    }

    public static boolean isPowerOfThree(int n) {
        boolean power = false;
        //find out if there is a number times it self three times and equal to this number.
        //if the power is bigger than n, return;

        for (int i = 0; i<=n; i++) {
            int powerResult = i *i * i;
            if (powerResult == n) {
                power = true;
                break;
            }else if (powerResult > n) {
                break;
            }
        }
        return power;

    }

    public boolean isPowerOfTwo(int n) {
        boolean power = false;
        //find out if there is a number times it self three times and equal to this number.
        //if the power is bigger than n, return;

        for (int i = 0; i<=n; i++) {
            int powerResult = i *i ;
            if (powerResult == n) {
                power = true;
                break;
            }else if (powerResult > n) {
                break;
            }
        }
        return power;

    }

    public static int searchInsert(int[] nums, int target) {

        int low = 0;
        int high = nums.length-1;


        while (high >=low) {
            int mid = (high-low)/2 + low;
            if (nums[mid] == target) {

                return mid;
            }else if (nums[mid] > target){
                high = mid -1;
            }else if (nums[mid] < target){
                low = mid +1;
            }

        }





        return low;

    }

    public int climbStairs1(int n) {
        int a = 1, b = 1;
        while (n-- > 0)
            a = (b += a) - a;
        return a;

    }

    Map<Integer, Integer> steps = new HashMap<>();
    public int climbStairs(int n) {
        if (n ==0) return 0;
        if (n == 1) return 1;
        if (n ==2) return 2;

        if (!steps.containsKey(n) ){
            steps.put(n, climbStairs(n-1) + climbStairs1(n-2));
        }

        return steps.get(n);




    }

    public static int maxSubArray(int[] nums) {

        //go through different array size, and put into the map (int[], size), also keep track of the max
        int soFarMax = nums[0];
        int maxEndingHere = soFarMax;

        //with the next number, get the max
        for (int i = 1; i<nums.length; i++) {
            maxEndingHere = Math.max(maxEndingHere + nums[i], nums[i]);
            soFarMax = Math.max(soFarMax, maxEndingHere);

        }


       return soFarMax;




    }

    public int hammingWeight(int n) {
        return Integer.bitCount(n);


    }





    public boolean isUgly(int num) {

        int remamining = 0;
        int product = num;

        int[] prime = {2, 3, 5};
        for (int factor: prime) {
            while (remamining == 0) {
                int number = product;
                product = number / factor;
                remamining = number % factor;
            }
        }
        if (remamining ==0 ){
            return true;
        }else {
            return false;
        }
    }

    public static boolean isPerfectSquare(int num) {
        boolean bIsPerfect = false;

        if (num ==1) return true;

        //use binary search
        //If mean square is bigger, need to look in lower end
        //If mean square equals, return and done
        //If mean square is less, need to look at higher end.

        int low = 0;
        int high = num;



        while(high >= low) {
            int middle = low + (high-low)/2;
            int product = middle * middle;
            if (product == num) {
                bIsPerfect = true;
                break;
            }else if (product > num) {
                high = middle-1;
            }else {
                low = middle +1;
            }

        }

        return bIsPerfect;


    }

    public int removeElement(int[] nums, int val) {
        int length= nums.length;
        for (int i = 0; i< length;) {
            if (nums[i] == val) {
                //length -1 and move the last one to this position
                if (nums[length -1] != val) {
                    nums[i] = nums[length - 1];
                    length--;
                    i++;

                }else {
                    length --;
                }

            }else {
                i++;
            }
        }

        return length;



    }


    public static int addHelper(int[] digits, int position, int toAdd, List<Integer> results) {
        int carry = 0;

        int sum = digits[position] + toAdd;
        if (sum>=10) {
            carry = 1;
            int digit = sum -10;
            results.add(digit);

        }else {
            carry = 0;
            results.add(sum);
        }
        return carry;
    }
    public static int[] plusOne(int[] digits) {

        if (digits == null) return null;
        if (digits.length <1) return new int[0];

        //e.g. {1,2} return {1, 3}
        int toAdd = 1;

        List<Integer> results = new ArrayList<>();

        //the last digit add one, all the others add the carry;
        int carry = addHelper(digits, digits.length - 1, toAdd, results);


        for (int i = digits.length-2; i>=0; i--) {
            carry = addHelper(digits, i, carry, results);
        }

        if (carry ==1) {
            results.add(1);
        }

        Collections.reverse(results);
        int resultsArray[] = new int[results.size()];
        for (int i = 0; i<results.size(); i++) {
            resultsArray[i] = results.get(i);
        }
        return resultsArray;
    }

    public static void generateHelper(int numRows, List<List<Integer>> results) {
        if (numRows ==0){
            return;
        }
        if (numRows ==1) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            results.add(list);
            return;

        }

        if (numRows == 2) {
            generateHelper(numRows-1, results);
            List<Integer> list = new ArrayList<>();
            list.add(1);
            list.add(1);
            results.add(list);
            return;

        }

        //If 3,
        generateHelper(numRows-1, results);
        List<Integer> list = new ArrayList<>();
        list.add(1);
        //Insert the sum
        List<Integer> lastRow = results.get(results.size()-1);
        for (int i = 0; i<lastRow.size()-1; i++) {
            int sum = lastRow.get(i) + lastRow.get(i+1);
            list.add(sum);
        }
        list.add(1);
        results.add(list);


    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> results = new ArrayList<>();
        generateHelper(numRows, results);
        return results;


    }

    public static int countSegments(String s) {
        int count = 0;
        boolean previousIsSpace = true;
        if (s.length() ==0) return 1;

        char[] parts = s.toCharArray();
        for(char c: parts) {
            if (c == ' ') {
                if(!previousIsSpace) previousIsSpace = true;
            }else {
                if(previousIsSpace) {
                    count++;
                    previousIsSpace = false;
                }
            }
        }

        return count;

    }

    public static int arrangeCoins(int n) {
        int total = 0;

        int remaining = n;
        for (int i = 1; i<=n && remaining >0; i++) {
            remaining = remaining-i;
            if (remaining >=0)
                total ++;
        }

        return total;

    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> results = new ArrayList<>();


        if (rowIndex == 0) {
            results.add(1);
            return results;
        }

        if (rowIndex ==1) {
            results.add(1);
            results.add(1);
            return results;
        }

        List<Integer> previousList = getRow(rowIndex -1);
        results.add(1);
        for (int i = 0; i<previousList.size()-2; i++) {
            int sum = previousList.get(i) + previousList.get(i+1);
            results.add(sum);
        }

        results.add(1);
        return results;
    }

    public static boolean isValid(String s) {
        if (s == null||s.length() ==0) return true;
        char[] chars = s.toCharArray();
        Character[] openChars = {'(', '{', '['};
        Character[] endChars = {')', '}', ']'};

        //make sure it starts with
        char firstChar = chars[0];
        List<Character> openList = Arrays.asList(openChars);
        List<Character> endList = Arrays.asList(endChars);

        Stack<Character> stack = new Stack<>();
        if (endList.contains(firstChar)) {
            return false;
        }else {
            stack.push(firstChar);
        }

        for(int i = 1; i<chars.length; i++) {
            char nextChar = chars[i];
            if(endList.contains(nextChar)) {
                if (stack.empty()) return false;
                char stackedChar = stack.pop();


                    if (nextChar==')' && stackedChar != '(') return false;
                    if (nextChar=='}' && stackedChar != '{') return false;
                    if (nextChar==']' && stackedChar != '[') return false;


            }else {
                stack.push(nextChar);
            }
        }

        if (!stack.empty()) return false;

        return true;



    }

    public static boolean isPalindrome(String s) {
        //go through with two pointers. if head is qualified and tail is qualified, then compare.
        //If not the same, return false.
        int head = 0;
        int tail = s.length() -1;
        char[] chars = s.toCharArray();

        while (head <= tail) {
            if (!Character.isLetterOrDigit(chars[head])) {
                head++;
            }else if (!Character.isAlphabetic(chars[tail])){
                tail--;
            }else {
                if (Character.toLowerCase(chars[head]) != Character.toLowerCase(chars[tail])) {
                    return false;
                }else {
                    head++;
                    tail --;
                }

            }
        }

        return true;
    }

    public String longestCommonPrefix(String[] strs) {
        if(strs.length <1) return "";

        int minLenth = Integer.MAX_VALUE;
        for (String str: strs) {
            if (str.length() <minLenth) minLenth = str.length();
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i<minLenth; i++) {
            char thisChar = strs[0].charAt(i);
            for (String str: strs) {
                if (thisChar != str.charAt(i)) {
                    return sb.toString();
                }
            }
            sb.append(thisChar);

        }

        return sb.toString();

    }

    public static String addBinary(String a, String b) {
        if (a == null) return b;
        if (b == null) return a;

        String[] partsA = a.split("");
        String[] partsB = b.split("");

        List<Integer> sumList = new ArrayList<>();
        int carry = 0;

        for (int i = a.length()-1, j = b.length()-1; i>=0 || j>=0; i--, j--) {
            int inta = i<0? 0: Integer.parseInt(partsA[i]);
            int intb = j<0? 0: Integer.parseInt(partsB[j]);
            int sum = inta + intb + carry;
            if (sum >= 2) {
                int value  = sum%2;
                carry = sum /2;
                sum = value;
            }else {
                carry = 0;
            }
            sumList.add(sum);
        }



        //if at the end there is still carry, append 1
        if(carry != 0 ) {
            sumList.add(carry);
        }

        Collections.reverse(sumList);
        StringBuilder sb = new StringBuilder();
        for(Integer int1: sumList) {
            sb.append(int1);
        }
        return sb.toString();

    }

    public static boolean allUpper(String input) {
        String uppper = input.toUpperCase();
        return input.equals(uppper);

    }

    public static boolean allLower(String input) {
        String lower = input.toLowerCase();
        return input.equals(lower);
    }

    public static boolean firstUpper (String input) {
        //first mast be upper
        //rest must be lower
        char first = input.charAt(0);
        int firstNumber = first -'A';
        if (firstNumber >=0 && firstNumber <26 ) {
            for (int i = 1; i<input.length(); i++) {
             char next = input.charAt(i);
             int nextNumber = next -'a';
             if (nextNumber >=0 && nextNumber <26) {

             }else {
                 return false;
             }
            }
        }else {
            return false;
        }

        return true;
    }
    public static boolean detectCapitalUse(String word) {
        //all uppper
        //all lower
        //only first upper.
        if (word== null) return true;

        String[] parts = word.split(" ");

        for (String part: parts) {
            //if it is ..or..or..or
            if (!(allUpper(part)||allLower(part) ||firstUpper(part))) {
                return false;
            }
        }

        return true;


    }
    public String reverseString(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i<chars.length/2; i++) {
            char temp = chars[i];
            chars[i] = chars[chars.length-1-i];
            chars[chars.length-1-i] = temp;
        }
        return new String(chars);
    }

    public static int strStr(String haystack, String needle) {
        int index = -1;

        if (haystack.length() < needle.length()) return index;
        if (haystack.length() == 0 && needle.length() ==0 ) return 0;
        for (int i = 0; i< haystack.length(); i++) {
            if (i+needle.length() >haystack.length()) {
                index = -1;
                break;
            }
            String parts = haystack.substring(i, i+needle.length());
            if (parts.equals(needle)) {
                index = i;
                break;
            }
        }

        return index;

    }

    public static String countAndSay(int n) {
        if (n == 0) return "";
        if (n ==1) {
            return "1";
        }
        if (n ==2) {
            return "11";
        }

        //Now deal with 3;
        StringBuffer sb = new StringBuffer();
        String previous = countAndSay(n-1);
        //find out how many what.
        int count = 1;
        char thisChar = previous.charAt(0);
        for (int i = 1; i<previous.length();i++) {

            char nextChar = previous.charAt(i);
            if (thisChar == nextChar) {
                count ++;

            }else {
                //time to store the value;

                sb.append(count);
                sb.append(thisChar);
                //reset
                count = 1;
                thisChar = nextChar;
            }
            if (i == previous.length() -1) {
                sb.append(count);
                sb.append(thisChar);
            }


        }
        return sb.toString();


    }

    public static String reverseWholeString(String s) {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();

    }

    public static String reverseFirstFew(String s, int k) {
        String firstPart = s.substring(0, k);
        String secondPart = s.substring(k, s.length());
        return reverseWholeString(firstPart) + secondPart;
    }
    public static String reverseStr(String s, int k) {
            StringBuilder sb = new StringBuilder();
            if (s == null) return null;
            if (s.length() <= k) {
                //reverse the whole string
                sb.append(reverseWholeString(s));
            }else if (s.length() <=2*k){

                //reverse the first k
                sb.append(reverseFirstFew(s, k));
            }else {
                //split into parts.

                int times = s.length() /(2*k);
                int remaining = s.length() %(2*k);

                for(int i = 0;  i< times; i++) {
                    int start = i*(2*k);
                    String part = s.substring(start, start+(2*k));
                    sb.append(reverseFirstFew(part, k));
                }

                String remainingString = s.substring(times *2*k, s.length());

                if (remainingString.length() <= k) {
                    //reverse the whole string
                    sb.append(reverseWholeString(remainingString));
                }else if (remainingString.length() <=k){

                    //reverse the first k
                    sb.append(reverseFirstFew(remainingString, k));
                }
                sb.append(reverseWholeString(remainingString));
            }

            return sb.toString();

    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        //[1,1,0,1,1,1]

        int count = 0;
        int maxCount = 0;

        for (int num: nums) {
            if (num ==1) {
                count ++;
            }else {
                maxCount = Math.max(count, maxCount);
                count = 0;
            }
        }
        maxCount = Math.max(count, maxCount);

        return maxCount;

    }

    public int removeDuplicates(int[] nums) {
        //if next is the same as current, move it to the end
        //Use two pointers, one from front; one from the end.
        if (nums.length <2) return nums.length;
        int id = 1;


        for (int i = 1; i<nums.length-1; i++) {
            if (nums[i] != nums[i+1]) {
                nums[id] = nums[i];
                id ++;
            }
        }
        return id;



    }

    public boolean containsDuplicate1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            if(map.containsKey(num) ) {
                return true;
            }else {
                map.put(num, 1);
            }
        }

        return false;
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i<nums.length; i++) {
            if(map.containsKey(nums[i]) ) {
                List<Integer> firstList = map.get(nums[i]);
                for(Integer first: firstList) {
                    if (Math.abs(first - i) <= k) {
                        return true;
                    }
                }
                firstList.add(i);
                map.put(nums[i], firstList);
            }else {
                List<Integer> firstList = new ArrayList<>();
                firstList.add(i);
                map.put(nums[i], firstList);
            }
        }

        return false;
    }

    public static void rotate(int[] nums, int k) {
        int numOfRotates = k%nums.length;

        if (nums.length == 0) return;

        for (int i = 0; i<numOfRotates; i++) {

            int temp = nums[nums.length -1];
            for(int j =0 ; j<nums.length; j++) {
                int next = nums[j];
                nums[j] = temp;
                temp = next;
            }
        }

    }

    public static void append(int[] nums1, int m, int[] nums2, int n, int start) {
        for (int i = 0; i<n-start; i++) {
            nums1[m+i] = nums2[start +i];
        }

    }

    public static int findLocation(int[] nums1, int start, int end, int toFind) {
        while(start <= end) {
            int middle = start + (end - start) / 2;
            if (nums1[middle] == toFind) {
                return middle;
            } else if (nums1[middle] > toFind) {
                end = middle;
            }else {
                start = middle;
            }
        }

        return start;



    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {

        //mark the value of the index to negative. then print out the index which is positive.
        for (int i = 0; i<nums.length; i++) {
            int value = Math.abs(nums[i]);
            if (nums[value -1]>0 ) {
                nums[value-1] = (-1) * nums[value-1];
            }
        }
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i<nums.length; i++) {
            if (nums[i] >0)  {
                res.add(i+1);
            }
        }

        return res;
    }

    public int[] twoSum1(int[] nums, int target) {
       //find if the difference is in the map, if it is, then done.
        //otherwise, put in the map
        int[] res = new int[2];
        Map<Integer, Integer> occuranceMap = new HashMap<>();


        for (int i = 0; i< nums.length; i++) {
            int difference = target - nums[i];
            if(occuranceMap.containsKey(difference)) {
                res[0] = i;
                res[1] = occuranceMap.get(difference);
                return res;
            }
            occuranceMap.put(nums[i], i);
        }
        return res;
    }

    public int thirdMax(int[] nums) {
        int[] sorted = IntStream.of(nums).distinct().sorted().toArray();

        if (sorted.length <3) {
            return sorted[sorted.length -1];
        }

        return sorted[sorted.length -3];
    }

    public static int findPairs(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0)   return 0;

        int total = 0;

        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums) {
            map.put(num, map.getOrDefault(num, 0) +1);
        }



        for(Map.Entry<Integer, Integer> e: map.entrySet()) {

            if (k ==0) {
                if (e.getValue() >=2) {
                    total ++;
                }
            }else {
                int toFind = e.getKey() + k;
                if (map.containsKey(toFind)) {
                    total++;
                }
            }
        }

        return total;

    }

    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i<nums.length-1;) {
            if (nums[i] != nums[i+1]) {
                return nums[i];
            }else {
                i= i+2;
            }
        }

        return nums[nums.length -1];

    }



    public int islandPerimeter(int[][] grid) {
        if (grid.length == 0) return 0;
        if(grid[0].length == 0) return 0;

        int total = 0;

        //Check horizontal
        for (int i = 0; i<grid.length; i++) {
            int previous = 0;
            for (int j = 0; j<grid[0].length; j++) {

                    if (previous != grid[i][j]) {
                        total++;
                        previous = grid[i][j];
                    }
                //If it is the last one and it is 1, add 1
                if ((j == grid[0].length -1) && (grid[i][grid[0].length -1] == 1)) {
                    total ++;
                }

            }
        }

        //Check vertical
        for (int i = 0; i<grid[0].length; i++) {
            int previous = 0;
            for(int j = 0; j<grid.length; j++) {
                if (previous != grid[j][i]) {
                    total ++;
                    previous = grid[j][i];
                }
                //if it is the last one
                if ((j == grid.length -1) && grid[grid.length -1][i] ==1) {
                    total ++;
                }
            }
        }

        return total;

    }

    public static boolean isAnagram1(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        int[] occ1 = new int[26];
        for (int i = 0; i<s1.length(); i++) {
            occ1[s1.charAt(i) -'a'] = occ1[s1.charAt(i) -'a'] +1;
        }

        for (int i = 0; i<s2.length(); i++) {
            occ1[s2.charAt(i) -'a'] = occ1[s2.charAt(i) -'a'] -1;

        }

        for (int i = 0; i<26; i++) {
            if (occ1[i] != 0) {
                return false;
            }
        }
        return true;



    }
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s.length()<p.length()) return res;


        for (int i = 0; i<s.length(); i++) {
            if (i + p.length() > s.length()) return res;
            if (p.contains(s.substring(i, i+1))) {
                if(isAnagram1(s.substring(i, i + p.length()), p)) {
                    res.add(i);
                }
            }

        }

        return res;

    }

    public String[] findWords(String[] words) {
        char[] line1 = {'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'};
        char[] line2 ={'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'};
        char[] line3 ={'z', 'x', 'c', 'v', 'b', 'n', 'm'};

        Set<Character> line1Set = new HashSet<>();
        for(char thisChar: line1) {
            line1Set.add(thisChar);
        }

        Set<Character> line2Set = new HashSet<>();
        for(char thisChar: line2) {
            line2Set.add(thisChar);
        }

        Set<Character> line3Set = new HashSet<>();
        for(char thisChar: line3) {
            line3Set.add(thisChar);
        }

        List<String> goodStrings = new ArrayList<>();

        for(String word: words) {
            char[] chars = word.toCharArray();
            Set<Character> charSet = line1Set;;
            //find which line is the first char.
            if (chars.length != 0) {
                char firstChar = chars[0];
                char firstLowerChar = Character.toLowerCase(firstChar);

                if (line1Set.contains(firstLowerChar)) {
                    charSet = line1Set;
                }else  if (line2Set.contains(firstLowerChar)) {
                    charSet = line2Set;
                }else {
                    charSet = line3Set;
                }

            }

            //if the rest chars are all from the same line, add to result.
            if (chars.length == 1) {
                goodStrings.add(word);
            }else {
                boolean allSameRow = true;
                for (int i = 1; i<word.length(); i++) {
                    if (!charSet.contains(Character.toLowerCase(chars[i]))) {
                        allSameRow = false;
                    }
                }
                if (allSameRow) goodStrings.add(word);
            }

        }

        String[] res = new String[goodStrings.size()];
        for(int i = 0; i<goodStrings.size(); i++) {
            res[i] = goodStrings.get(i);
        }

        return res;
    }

    public static boolean wordPattern(String pattern, String str) {
        //splint str to parts and make sure the parts is the same size as pattern.length
        String[] parts = str.split(" ");
        char[] chars = pattern.toCharArray();

        if (parts.length != pattern.length()) return false;

        //put into a map
        Map<Character, String> dic = new HashMap<>();
        for(int i = 0; i< chars.length; i++) {
            char thisChar = chars[i];
            if(dic.containsKey(thisChar)) {
                String mappedString = dic.get(thisChar);
                if (!mappedString.equals(parts[i])) {
                    return false;
                }
            }else {
                //Need to check if this value is already mapped to something else.
                if (dic.values().contains(parts[i])) return false;
                dic.put(thisChar, parts[i]);
            }
        }

        return true;


    }



    public static boolean isPrime(int n,Map<Integer, Boolean> primeMap ) {
        if (n ==1) return true;
        if (primeMap.containsKey(n)) {
            return primeMap.get(n);
        }
        for (int i = 2; i<n; i++) {
            if (n%i == 0) {
                primeMap.put(n, false);
                return false;
            }
        }
        primeMap.put(n, true);
        return true;
    }

    public static int countPrimes(int n) {

        //check if itself is prime. if yes, = 1+ countPrimes(i-1); else, = countPrimes(i-1) and put it in a map.

        if (n ==1) return 1;
        if (n ==2) return 2;
        if (n == 3) return 3;

        Map<Integer, Boolean> primeMap = new HashMap<>();

        int count = 0;
        for (int i = 1; i<n; i++) {
            if (isPrime(i, primeMap)) {
                count ++;
            }
        }

        return count;

    }

    public static boolean isIsomorphic(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        if (sChars.length != tChars.length) return false;

        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i<sChars.length; i++) {
            if (map.containsKey(sChars[i])) {
                if (!map.get(sChars[i]).equals(tChars[i])) {
                    return false;
                }
            }else {
                if (map.containsValue(tChars[i])) {
                    return false;
                }
            }

            map.put(sChars[i], tChars[i]);

        }
        return true;
    }


    public static boolean checkPerfectNumber(int num) {

        //find all of it's factors
        int total = 0;

        for (int i = 1; i<=Math.sqrt(num); i++) {
            if (num%i ==0) {
                total = total + i;
                total = total + num/i;
            }
        }




        if (total == num) return true;
        return false;

    }

    public boolean isPalindrome(int x) {
        String input = String.valueOf(x);
        for (int i = 0; i<input.length()/2; i++) {
            if (!input.substring(i, i+1).equals(input.substring(input.length()-1-i, input.length() -i))) {
                return false;
            }
        }

        return true;

    }

    public int findNthDigit(int n) {

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i<=n; i++) {
            sb.append(i);
        }

        return Integer.parseInt(sb.substring(n - 1, n));
    }

    public static int reverse(int x) {
        if (x < 0) {
            x = x * (-1);
            StringBuilder sb = new StringBuilder("" + x);
            sb.reverse();
            try {
                return Integer.parseInt(sb.toString()) * (-1);
            }catch (NumberFormatException e) {
                return 0;
            }
        }else {

            StringBuilder sb = new StringBuilder("" + x);
            sb.reverse();
            try {
                return Integer.parseInt(sb.toString());
            }catch(NumberFormatException e) {
                return 0;
            }

        }

    }

    int trailingZeroes(int n) {
        if (n <5) return 0;
        return n/5 + trailingZeroes(n/5);
    }


    public static String convertToTitle(int n) {


       List<Integer> list = new ArrayList<>();
        char[] maps = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N','O', 'P', 'Q','R', 'S','T',
        'U','V', 'W', 'X', 'Y', 'Z'};

        //get it between 1 to 26
        int extra = n%26;
        list.add(extra);
        n = n/26;

        while (n >1 || n==1 && extra != 0) {
            if (extra == 0) {
                extra = n%26 -1;
            }else {
                extra = n % 26;
            }
            list.add(extra);
            n = n/26;

        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i<list.size(); i++) {
            int index = list.get(i) -1;
            if (index == -1) index = 25;
           char thechar = maps [index] ;
            sb.append(thechar);

        }

        return sb.reverse().toString();





    }


    public static String test(int n) {
        String res = "";

        while (n>0) {
            res = (char)((n-1)%26 + 56) + res;
            n = (n-1)/26;
        }

        return res;
    }

    public static int titleToNumber(String s) {
        StringBuffer sb = new StringBuffer(s);
        String newString = sb.reverse().toString();
        //A = 1; Z = 26; AA = 27
        char[] chars = newString.toCharArray();

        char thisChar = chars[0];
        int res =  thisChar -'A' + 1;

        //Next char
        for (int i =1; i<chars.length; i++ ) {
            //how many 26 to multiply
            int subProduct = 1;
            int n = i;
            while(n>0){
                subProduct = subProduct * 26;
                n--;
            }
            res = res + (chars[i] -'A' + 1 ) * subProduct;
        }

        return res;


    }

    public static boolean isPowerOfThree1(int n) {
       //3 how many times is it.

        if (n ==1) return true;
        if (n<3) return false;

        //Now n>=3
        int previousTotal  = 1;
        for (int i = 1; i<n && previousTotal <n; i++) {
            //get i number of three multiply

            previousTotal = previousTotal *3;

            if (previousTotal == n) return true;

        }

        return false;

    }

    public static int mySqrt(int x) {
        //find the number who times itself with the result between x and x-1;

        if (x ==0) return 0;

        int low = 1;
        int high = x;

        int res = -1;

        while(low <=high) {
            int middle = low + (high -low) /2;
            if (middle * middle ==x){
                return middle;
            }else if (middle*middle >x){
                high = middle -1;
            }else if (middle *middle <x) {
                low = middle +1;
            }
        }

        return low-1;

    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=m-1, j=n-1, k=m+n-1;
        while (i>-1 && j>-1) nums1[k--]= (nums1[i]>nums2[j]) ? nums1[i--] : nums2[j--];
        while (j>-1)         nums1[k--]=nums2[j--];
        System.out.println();

    }

    public int firstBadVersion(int n) {

        int low = 1;
        int high = n;

        while(low <= high) {
            int mid = low + (high-low)/2;
            if (isBadVersion(mid)) {
                //this is already bad
                high = mid -1;
            }else {
                low = mid +1;
            }
        }

        return low;


    }

    public static int findRadius(int[] houses, int[] heaters) {


        int largestDistance = Integer.MIN_VALUE;

        //for each house, find the heater which is closest to it, and put it in map
        for (int i = 0; i< houses.length; i++) {
            int thisHouseDistance = Integer.MAX_VALUE;

            for (int j = 0; j<heaters.length; j++) {
                int distance2 = houses[i] - heaters[j];
                if (distance2 < 0) distance2 = (-1) * distance2;
                thisHouseDistance = Math.min(thisHouseDistance, distance2);
            }


            largestDistance = Math.max(largestDistance, thisHouseDistance);

        }

        return largestDistance;



    }

    public boolean isBadVersion(int version) {
        return true;
    }



    public static void main(String[] args) {
        int[] input = {1,1,0,1,1,1};
        findMaxConsecutiveOnes1(input);
    }

    public int[] twoSum5(int[] numbers, int target) {
        int[] indexes = new int[2];
        Map<Integer, Integer> position = new HashMap<>();
        for (int i = 0; i<numbers.length; i++) {
            position.put(i+1, numbers[i]);
        }
        //first round put these into map
        position.keySet().
        for (Integer indx: position.keySet()) {


        }

        return indexes;
    }

    Map<Integer, List<Integer>> maps = new HashMap<>();
    public List<Integer> getRow1(int rowIndex) {
       if (maps.get(rowIndex)!= null) return maps.get(rowIndex);

        List<Integer> rowList = new ArrayList<>();
        if (rowIndex == 0)  {
            rowList.add(1);
            maps.put(0, rowList);

        }else if (rowIndex == 1)  {
            rowList.add(1);
            rowList.add(1);
            maps.put(1, rowList);

        }else {
            rowList.add(1);
            List<Integer> previousRow = maps.get(rowIndex-1);
            if (previousRow== null) {
                previousRow = getRow1(rowIndex-1);
            }

            for (int i = 1; i<previousRow.size(); i++) {
                rowList.add(previousRow.get(i) + previousRow.get(i-1));
            }
            rowList.add(1);
        }


        return rowList;

    }

    public int searchInsert1(int[] nums, int target) {
        //go through each one, record the index
        int index = 0;
        for (int i = 0; i<nums.length; i++) {
            if (target<nums[i]) {
                index = i;
                break;
            }else if (target == nums[i]) {
                index = i;
                break;
            }else {
                index = i+1;
            }
        }

        return index;

    }

    public static int findMaxConsecutiveOnes1(int[] nums) {

        List<Integer> lengthList = new ArrayList<>();
        for (int i = 0; i<nums.length; i++) {
            int length = 0;
            if (nums[i] ==1) {
                length ++;
                if (i == nums.length -1) {
                    lengthList.add(length);
                }
                for (int j = i+1; j<nums.length; j++) {
                    if (nums[j] ==1) {
                        length ++;
                        if (j == nums.length-1) lengthList.add(length);
                    }else {
                        lengthList.add(length);
                        break;
                    }
                }

            }
        }

        lengthList.sort(Comparator.naturalOrder());
        if (lengthList.size() >=1) {
            return lengthList.get(lengthList.size() - 1);
        }else {
            return 0;
        }
    }

    public static List<Integer> findDisappearedNumbers1(int[] nums) {
        List<Integer> missing = new ArrayList<>();

        for (int num: nums) {
            int index = Math.abs(num)-1;
            if (nums[index] > 0) {
                nums[index] = nums[index] * (-1);
            }
        }

        for (int i = 0; i<nums.length; i++) {
            if (nums[i] >0)
                missing.add(i+1);
        }

        return missing;
    }


    public static int removeDuplicates1(int[] nums) {
        //It is sortted. just compare with the one after it. if it is the same, move it to the last, and every one else move up.

        int index = 1;
       for (int i = 1; i<nums.length; i++) {
           int before = i -1;
           if (nums[i] != nums[before]) {
               nums[index] = nums[i];
               index++;
           }
       }

       return index;
    }

    public static void moveZeroes1(int[] nums) {
        //swap with the next

        int index = 0;

        for (int num: nums) {
            if (num != 0) {
                nums[index] = num;
                index++;
            }
        }

        for (int i = index; i<nums.length; i++){
            nums[i] = 0;
        }

    }

    public static int[] plusOne1(int[] digits) {

        List<Integer> resultList = new ArrayList<>();
        int carry = 0;


        for (int i = digits.length-1; i>=0; i--) {
            int sum;
            if (i == digits.length -1) {
                sum = digits[i] + 1 + carry;
            }else {
                sum = digits[i] + carry;
            }
            int value = sum %10;
            carry = sum /10;
            resultList.add(value);
        }
        if (carry >0) resultList.add(carry);

        int[] result = new int[resultList.size()];
        for (int i = 0; i<resultList.size(); i++) {
            result[i] = resultList.get(resultList.size()-1 -i);
        }

        return result;

    }
    public boolean containsNearbyDuplicate1(int[] nums, int k) {

        Map<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i< nums.length; i++) {

           if (seen.containsKey(nums[i])) {
               if (i - seen.get(nums[i]) <=k ) {
                   return true;
               }else {
                   seen.put(nums[i], i);
               }

           }else {
               seen.put(nums[i], i);
           }
        }

        return false;

    }
    public int[] twoSum2(int[] nums, int target) {
        int[] indexes = new int[2];
        Map<Integer, Integer> seen = new HashMap<>();

        for (int i = 0; i< nums.length; i++) {
            if (seen.keySet().contains(target - nums[i])) {
                indexes[0] = i;
                indexes[1] = seen.get(target-nums[i]);
            }else {
                seen.put(nums[i], i);
            }
        }

        return indexes;

    }

    public int findUnsortedSubarray1(int[] nums) {
        //sort it
        //then find the first diff and the last diff

        int[] sorted = IntStream.of(nums).sorted().toArray();
        int start = -1;
        int end = -1;

        for (int i = 0; i<nums.length; i++) {
            if (nums[i] != sorted[i]) {
                start = i;
                break;
            }
        }

        for (int i = nums.length -1; i>=0; i--) {
            if (nums[i] != sorted[i]) {
                end = i;
                break;
            }
        }

        if (start == -1 && end ==-1 ) return 0;
        return end-start+1;

    }

    public int[][] matrixReshape1(int[][] nums, int r, int c) {

        int rows = nums.length;
        if (rows <1) return nums;
        int column = nums[0].length;
        if (rows * column != r*c) return nums;

        int[][] result = new int[r][c];

        List<Integer> list = new ArrayList<>();
        for (int[] num: nums) {
            for (int one: num) {
                list.add(one);
            }
        }

        for (int i = 0; i<list.size(); i++) {
            result[i/c][i%c] = list.get(i);
        }

        return result;


    }

    public static List<String> findRepeatedDnaSequences(String s) {

        Set<String> resultSet = new HashSet<>();
        Set<String> seenSet = new HashSet<>();

        for (int i = 0; i + 9 <s.length(); i++) {
            String subString = s.substring(i, i+10);
            if (!seenSet.add(subString)) {
                resultSet.add(subString);
            }

        }

        List<String> result = new ArrayList<>(resultSet);
        return result;

    }

    public int findLHS(int[] nums) {
        //go through the input and put into map of key and number of occurances.

        //For each key, if there is key +1, then count the total of both and compare with the max
        int total = 0;

        Map<Integer, Integer> occurances = new HashMap<>();
        for (int num: nums) {
            occurances.put(num, occurances.getOrDefault(num, 0) +1);
        }

        for(Integer key: occurances.keySet()) {
            if (occurances.containsKey(key +1)) {
                if (occurances.get(key) + occurances.get(key+1) > total ) total = occurances.get(key) + occurances.get(key+1);
            }
        }

        return total;

    }
    public static int distributeCandies(int[] candies) {
        //put them into a Map.
        //He can only get half. if half is larger or equals to the keys, return keys
        //if half is less than the keys, then return half.
        Map<Integer, Integer> candiesMap = new HashMap<>();
        for (int i = 0; i<candies.length; i++) {
            Integer key = candies[i];
            if (candiesMap.containsKey(key)) {
                candiesMap.put(key, candiesMap.get(key) +1);
            }else {
                candiesMap.put(key, 1);
            }
        }

        int keys = candiesMap.keySet().size();
        int half = candies.length/2;

        if (half >=keys) {
            return keys;
        }else {
            return half;
        }






    }



    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result= new ArrayList<>();
        dfs(nums,0,new ArrayList<Integer>(),result);
        return result;
    }

    public static void dfs(int[] nums,int index,List<Integer> path,List<List<Integer>> result){
        result.add(path);
        for(int i=index;i<nums.length;i++){
            if(i>index&&nums[i]==nums[i-1]) continue;
            List<Integer> nPath= new ArrayList<>(path);
            nPath.add(nums[i]);
            dfs(nums,i+1,nPath,result);
        }
    }

    int min = Integer.MAX_VALUE;
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() ==0 ) return 0;
        int sum = triangle.get(0).get(0);
        int index = 0;


        helper(sum, index, 1, triangle);

        return min;

    }

    public void helper(int sum, int index, int row, List<List<Integer>> triangle) {

        if (row == triangle.size()) {
            if (min > sum) min = sum;
        }
        int originSum = sum;
        int leftSum = originSum + triangle.get(row).get(index);
        helper(leftSum, index, row +1, triangle);

        int rightSum = originSum + triangle.get(row).get(index +1);
        helper(rightSum, index+1, row +1, triangle);

    }


    public static int maxSubArray2(int[] nums) {
        if (nums == null || nums.length <1) return 0;
        int max = nums[0];
        for (int i = 0; i<nums.length; i++) {
            int maxSubSum = nums[i];
            int subSum = nums[i];
            for (int j = i+1; j<nums.length; j++) {
                subSum = subSum * nums[j];
                if (subSum > maxSubSum) maxSubSum = subSum;
            }
            if (maxSubSum > max) max = maxSubSum;

        }
        return max;

    }

    public static int[][] matrixReshape(int[][] nums, int r, int c) {
        if (nums == null) return nums;
        int rows = nums.length;
        if (rows == 0) return nums;
        int columns = nums[0].length;

        int total = rows * columns;
        int expectedTotL = r * c;
        if (total != expectedTotL) return nums;

        int[][] reshaped = new int[r][c];

        for (int i = 0; i<total; i++) {
            int oldRow = i/columns;
            int oldColumn = i%columns;

            int newRow = i/c;
            int newColumn = i%c;
            reshaped[newRow][newColumn] = nums[oldRow] [oldColumn];

        }

        return reshaped;


    }

    public static int findUnsortedSubarray(int[] nums) {

        int beginningIndex = 0;
        int endingIndex = nums.length -1;
        //Find the first one who is larger than the remaining.
        boolean foundit1 = false;
        for (int i = 0; i<nums.length-1; i++) {
            int theOne = nums[i];
            for (int j= i+1; j<nums.length; j++) {
                if (theOne >nums[j]) {
                    beginningIndex = i;
                    foundit1 = true;
                    break;
                }
            }
            if (foundit1) break;

        }

        boolean foundit2 = false;
        //Find the first one from the back who is smaller than the remaining.
        for (int i= nums.length-1; i>0; i--) {
            int theone = nums[i];
            for (int j= i-1; j<=0; j--) {
                if (theone < nums[j]) {
                    endingIndex = i;
                    foundit2 = true;
                    break;
                }
            }
            if (foundit2) break;

        }
        int gap = endingIndex - beginningIndex +1;
        if (!foundit1 && !foundit2 && gap == nums.length ) gap = 0;
        return gap;
    }

    public static String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        Character[] vowes = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        List<Character> listChars = Arrays.asList(vowes);
        //get a map of location and value.
        Map<Integer, Character> maps = new HashMap<>();
        for (int i = 0; i<chars.length; i++) {
            if (listChars.contains(chars[i])) {
                maps.put(i, chars[i]);
            }
        }
        //swap those values
        List<Integer> listKeys = new ArrayList(maps.keySet());
        listKeys.sort(Comparator.naturalOrder());
        for (int i = 0; i< listKeys.size()/2; i++) {
            Character thisChar = maps.get(listKeys.get(i));
            chars[listKeys.get(i)] = maps.get(listKeys.get(listKeys.size() -1 -i));
            chars[listKeys.get(listKeys.size() -1 -i)] = thisChar;

        }

        return new String(chars);

    }

    public boolean isPowerOfFour(int num) {
        boolean bPower = false;
        int product = 1;
        while(product < num) {
            product = product *4;
            if (product == num) {
                bPower = true;
                break;
            }
        }

        return bPower;

    }

    public static boolean isWinner(int x, int y) {
        boolean winner = false;

        if (x<1 ||x>15|| y<1 || y>15) return false;

        if ((x-2<1 || y+1 >15) && (x-2<1 || y-1<1) && (x+1 >15 ||y-2<1) && (x+1>15 ||y-2 <1)) {
            results[x-1][y=1] = 0;
            return false;
        }


        if (results[x-1][y-1] != -1) {
            if (results[x-1][y-1] == 1) {
                return true;
            }else {
                return false;
            }
        }else {

                //If I can make next person to lose, then I win
                boolean nextWinner = true;
                if (x-2 >= 1 && y+1 <=15) {
                    if(!isWinner(x-2, y+1)) {
                        nextWinner = false;
                    }
                }

                if(nextWinner && (x-2>=1 && y-1 >=1)) {
                    if(!isWinner(x-2, y-1)) {
                        nextWinner = false;
                    }
                }

                if(nextWinner && (x+1<=15 && y-2 >=1)) {
                    if(!isWinner(x+1, y-2)) {
                        nextWinner = false;
                    }
                }

                if(nextWinner && (x-1>=1 && y-2 >=1)) {
                    if(!isWinner(x-1, y-2)) {
                        nextWinner = false;
                    }
                }
                //if ( !isWinner(x-2, y+1)|!isWinner(x-2, y-1)|!isWinner(x+1, y-2) ||!isWinner(x-1, y-2) ) {

                if (nextWinner == false)  {
                    winner = true;
                    results[x][y] = 1;
                }else {
                    winner = false;
                    results[x][y] = 0;
                }

        }
        return winner;

    }


    public static int lonelyNumber(int[] a) {
        int result = 0;

        for(int i : a) {
            result = result ^ i;
        }

        return result;
    }

    public static void permutingArray(int[] input1, int[] input2, int k) {
        //sort them, then input1.beginning + input2.end ; if less then k, print No and done
        Arrays.sort(input1);
        Arrays.sort(input2);
        boolean result = true;
        for (int i = 0, j = input1.length  -1; i< input1.length && j>=0; i++, j--) {
            if (input1[i] + input2[j] < k) {
                result = false;
            }
        }
        if (result) {
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }


    }

    public static void jimOrder(int[][] input) {
        int [] results = new int[input.length];
        for (int i = 0; i<input.length; i++) {
            results[i] = input[i][0] + input[i][1];
        }

        //Now need to sort the results from largest and print the index
        //find the one which is next smaller than
        int max = 2000000;

        int largestIndex = getLargestIndex(results, max);
        System.out.println(largestIndex);
        while(largestIndex != -1) {
            largestIndex = getLargestIndex(results, results[largestIndex]);
            System.out.println(largestIndex);
        }






    }

    public static int getLargestIndex(int[] results, int max) {
        int largestIndex = -1;
        int largest = 0;

        for (int i = 0; i<results.length; i++) {
            if (results[i] < max) {
                if (largestIndex == -1) {
                    largestIndex = i;
                    largest = results[i];
                }else {
                    if (results[i] > largest) {
                        largest = results[i];
                        largestIndex = i;
                    }
                }

            }

        }
        return largestIndex;
    }

    public static void markToys(int[] input, int k) {
        Arrays.sort(input);
        int total = 0;
        int numberOfTypes = 0;

        for (int i = 0; i<input.length; i++) {
            total = total + input[i];
            if (total <k) {
                numberOfTypes ++;
            }else {
                break;
            }
        }

        System.out.println(numberOfTypes);
    }

    public static void findLargestPermutation(int[] input, int k) {
        //do this k times
        //This is: find the largest one index, swap with the location
        int beginning = 0;
        for (int j = 0; j<k; j++) {
            swap(input, beginning++);
        }



    }

    private static void swap(int[] input, int beginning) {
        int largestIndex = beginning;
        int largest = input[largestIndex];
        for (int i = beginning; i < input.length; i++) {
            if (input[i] > largest) {
                largest = input[i];
                largestIndex = i;
            }
        }
        input[largestIndex] = input[beginning];
        input[beginning] = largest;

    }

    public static void buyToys(int[] input) {
        //sort the input, then start from the first one, get the range, and find the index of the next one who is more than this;
        Arrays.sort(input);
        int start = 0;
        int value = input[start] +4;

        int total = 0;

        int nextOne = getNextOne(input, start, value);
        total ++;

        while (nextOne <input.length) {
            nextOne = getNextOne(input, nextOne, input[nextOne] +4);
            total ++;

        }
        System.out.println(total);

    }

    private static int getNextOne(int[] input, int start, int value) {
        int nextOne = start;

        if (start+1 <input.length) {
            for (int i = start + 1; i < input.length; i++) {
                //Get the last one who is less than value; then next one is ++
                if (input[i] < value) {
                    nextOne = i;
                }
            }
        }
        nextOne ++;
        return nextOne;
    }

    public static void missingNumbers(int[] input1, int[] input2) {
        //Build the frequency of input1 and input2.
        //Go though the input2 and input1, compare their frequency, if less, then print that number.
        int[] frequency1 = new int[10000];
        for(int i = 0; i<input1.length; i++) {
            frequency1[input1[i]] ++;
        }

        int[] frequency2 = new int[10000];
        for(int i = 0; i<input2.length; i++) {
            frequency2[input2[i]] ++;
        }

        for(int i = 1; i<1001; i++) {
            if (frequency2[i] > frequency1[i]) {
                System.out.println(i);
            }
        }

    }
    public static void radioTransmitter() {
        int[] ar = {1, 2, 3, 4, 5};
        int k = 1;
        int total = 0;
        Arrays.sort(ar);
        int beginning = 0;

        while(beginning < ar.length) {

            //Find the location of the lamp; set new begging
            //The location is from the array who is next smaller than this value;
            //Find the lower boundry: who is biggest smaller than this value;

            int distance = ar[beginning] + k;

            if (distance > ar[ar.length -1]) break;

            int candidate = beginning;

            candidate = findLowerBound(ar, beginning, distance);

            if(candidate != beginning) total ++;

            beginning = findLowerBound(ar, candidate, distance + k);

        }

        System.out.println(total);
        //first sort the array
        //go through the list, remember the begiining point;
        // begiining + k; find that element; total +1; new location is beggining + 2k;
    }

    private static int findLowerBound(int[] ar, int beginning, int distance) {
        int candidate = beginning;
        for (int i = beginning; i<ar.length; i++) {
            if (ar[i] < distance) {
                candidate = i;
            }else if (ar[i]== distance){
                candidate = i;
                break;
            }else {
                break;
            }

        }
        return candidate;
    }

    public  static void closestNumbers (long[] ar) {
       //sort the list
        Arrays.sort(ar);

        //iterate and keep track of the gap,
        List<Long> results = new ArrayList<>();
        long smallest = ar[1] - ar[0];
        results.add(ar[1]);
        results.add(ar[0]);

        for (int i = 1; i<ar.length -1; i++) {
            if (ar[i+1] - ar[i] == smallest) {
             results.add(ar[i+1]);
             results.add(ar[i]);
            }else if (ar[i+1] - ar[i] < smallest) {
                results.clear();
                results.add(ar[i+1]);
                results.add(ar[i]);
            }

        }

        System.out.println();
        // if bigger than closest, do nothing
        // if it is the same as the smallest so far, add to the result lest
        // if it is smaller than the smallest, get rid of the old, keep the new

    }

    public static void firstUnique() {
        char[] ar = {'a', 'a', 'b', 'c', 'c'};
        List<Character> uniqueList = new ArrayList<>();
        List<Character> duplicateList = new ArrayList<>();

        for (int i = 0; i<ar.length; i++) {
            Character thisChar = ar[i];
            //Not on either list, add it to unique list
            if ((!uniqueList.contains(thisChar)) && (!duplicateList.contains(thisChar))) {
                uniqueList.add(thisChar);
            }else if ((uniqueList.contains(thisChar))) {
                //if on unique, then remove from unique, add to dup
                uniqueList.remove(thisChar);
                duplicateList.add(thisChar);
            }

        }
        System.out.println(uniqueList.get(0));

    }

    public static void firstUnique2() {
        char[] ar = {'a', 'a', 'b', 'c', 'c'};
        int[] count = new int[26];
        //get the number of occurance
        for (int i = 0; i<ar.length; i++) {
            count[ar[i]-'a'] ++;
        }

        for (int i = 0; i<ar.length; i++) {
            if (count[ar[i]-'a'] == 1) {
                System.out.println(ar[i]);
            }
        }




    }
    public static void countingSort2(int[] ar) {
        int[] countEqualLess = new int[100];
        //int all to 0;
        for (int i = 0; i<100; i++) {
            countEqualLess[i] = 0;
        }

        for (int i = 0; i< ar.length; i++) {
            int number = ar[i];
            for (int j = 0; j<100; j++) {
                if (j>= number) {
                    countEqualLess[j]++;
                }
            }

        }

        printArray(countEqualLess);
    }
    public static void countingSort(int[] ar) {
        int [] times = new int[100];
        //int all to 0;
        for (int i = 0; i<100; i++) {
            times[i] = 0;
        }

        for (int i = 0; i< ar.length; i++) {
            times[ar[i]] ++;
        }

        int[] sortedArray = new int[ar.length];
        //Create a new array with the right order
        List<Integer> sorted = new ArrayList<>();
        for (int i = 0; i< 100; i++) {
            if (times[i] != 0 ) {
                for (int j = 0; j< times[i]; j++) {
                    sorted.add(i);
                }
            }
        }

        Integer[] me = sorted.toArray(new Integer[0]);

        for (int i = 0; i<ar.length; i++ ) {
            sortedArray[i] = me[i];
        }
       printArray(sortedArray);


    }
    public static int[] quickSort(int[] ar) {
        if (ar.length ==1 ) {
            return ar;
        }
        if (ar.length == 2) {
            if (ar[1] <ar[0]) {
                int small = ar[1];
                ar[1] = ar[0];
                ar[0] = small;
            }
            return ar;
        }
        if (ar.length >2) {
            //partition into two aways; smallset and largeset
            int pivot = ar[0];
            int pivotLocation = 0;

            for (int i = 1; i<ar.length; i++) {
                if (ar[i] <= pivot) {
                    int smallOne = ar[i];


                    //go backward of the list, move them right one place
                    //Find the location of the pivot and insert the small one there.
                    for (int j = i-1; j>=0; j--) {
                        if (ar[j] == pivot) {
                            pivotLocation = j;
                        }
                        if (ar[j] >= pivot) {
                            ar[j+1] = ar[j];
                        }
                    }

                    ar[pivotLocation] = smallOne;
                    pivotLocation ++;
                }
            }
            int[] leftSet = Arrays.copyOfRange(ar, 0, pivotLocation);
            int[] rightSet = Arrays.copyOfRange(ar, pivotLocation + 1, ar.length);
            //sort on smallset + pivoit + sort on largeset
            System.out.println();
            int[] leftSorted = quickSort(leftSet);
            int[] rightSorted = quickSort(rightSet);
            int[] resultArray = new int[ar.length];
            for (int i = 0; i<leftSorted.length; i++) {
                resultArray[i] = leftSorted[i];
            }
            resultArray[leftSorted.length] = pivot;
            for (int i= 0; i<rightSorted.length; i++) {
                resultArray[leftSorted.length + 1 + i] = rightSorted[i];
            }

            return resultArray;
        }
        return ar;
    }

    public static void insertTimes() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Integer[] a = new Integer[n];
        for (int i = 0; i<n; i++) {
            a[i] = in.nextInt();
        }

        for (int i = 1; i < n; i++) {
            int value = a[i];
            //compare with the ones before it, if bigger or equals, just put it there;
            // if it is smaller, move on to the one before it.
            for (int j = i-1; j>=0; j--) {
                if (value >= a[j]) {
                    a[j+1] = value;
                    break;
                }else {
                    a[j+1] = a[j];
                }
            }
        }
        System.out.println();

    }

    public static void insertSort() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Integer[] a = new Integer[n];
        for (int i = 0; i<n; i++) {
            a[i] = in.nextInt();
        }

        for (int i = 1; i < n; i++) {
            //working on i; go through all up to i, if all less then it, nothing needs to be done
            //if found one smaller; insert it to that position, all remaining move;
            for (int j = 0; j< i; j++) {
                if (a[j] > a[i]) {
                    //shift to the right
                    int temp = a[i];
                    for (int k = i; k>j; k--) {
                        a[k] = a[k-1];
                    }
                    a[j] = temp;
                }
            }

            System.out.println("");
        }

    }

    public static void binString() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String B = in.next();

        int total = 0;
        for (int i = 0; i<n-2;) {
            if (B.substring(i, i+3).equals("010")) {
                total = total +1;
                i = i+3;
            }else {
                i ++;
            }
        }
        System.out.println(total);

    }




    public static void funnyString() {
        Scanner in = new Scanner(System.in);
        int total = in.nextInt();
        for (int i = 0; i< total; i++) {
            String input = in.next();
            char[] b = input.toCharArray();
            //Get the reverse
            char[] a = input.toCharArray();
            for (int j = 0; j<a.length/2; j++) {
                char temp = a[a.length-1 -j];
                a[a.length-1-j] = a[j];
                a[j] = temp;
            }
            //iterate through if all distance equals, then true;
            boolean funny = true;
            if (a.length <1) {
                System.out.println("Funny");
            }else {
                for (int j = 1; j < a.length; j++) {
                    if (((a[j] - a[j - 1]) == (b[j] - b[j - 1]) ||
                            (((a[j] - a[j - 1]) == (b[j] - b[j - 1]) * (-1))))) {
                        funny = true;

                    }else {
                        funny = false;
                        break;
                    }
                }
                if (funny) {
                    System.out.println("Funny");
                }else {
                    System.out.println("Not Funny");
                }
            }

        }

    }

    public static void sos() {
        Scanner in = new Scanner(System.in);
        String S = in.next();
        String sos = "SOS";
        int times = S.length() / sos.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i< times; i++) {
            sb.append(sos);
        }

        //Now time to compare s and sb
        char[] input = S.toCharArray();
        char[] expected = sb.toString().toCharArray();
        int total = 0;
        for (int i = 0; i<input.length; i++) {
            if (input[i] != expected[i]) total ++;
        }
        System.out.println(total);
    }
    public static void cipher() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.next();
        int k = in.nextInt();

        int m =  (int)'Z';

        int times = k%26;

        StringBuilder sb = new StringBuilder();
        char[] a = s.toCharArray();
        for (char one: a) {
            //If one is a character, rotate; otherwise, just append it.
            String oneString = new Character(one).toString();
            if (oneString.matches("[a-zA-Z]")) {
                int newChar = one + times;

                if(oneString.matches("[a-z]")) {
                    if (newChar > 122) newChar = newChar - 26;
                }else {
                    if (newChar > 90) newChar = newChar -26;
                }

                sb.append((char)(newChar));
            }else {
                sb.append(one);
            }
        }
        System.out.println(sb.toString());

    }
    public static void panGrams() {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        String lowerInput = input.toLowerCase();
        String allCharString = "abcdefghijklmnopqrstuvwxyz";
        char[] allChars = allCharString.toCharArray();
        boolean hasAll = true;
        for (char c: allChars) {
            if(!lowerInput.contains(new Character(c).toString()) ) {
                hasAll = false;
                break;
            }
        }

        if (hasAll) {
            System.out.println("pangram");
        }else {
            System.out.println("not pangram");
        }

    }


    public static int twoCharacters() {

        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        String input = in.next();

        //Find the unique characters
        Set<Character> uniqueChar = new HashSet<>();
        char[] a = input.toCharArray();
        for (int i = 0; i<a.length; i++) {
            uniqueChar.add(a[i]);
        }

        //Find the combinations of the twos.
        List<String> combinations = new ArrayList<>();
        Character[] uniqueArray = uniqueChar.toArray(new Character[0]);
        for (int i = 0; i<uniqueArray.length-1; i++) {

            for (int j = i+1; j<uniqueArray.length; j++) {
                StringBuilder sb = new StringBuilder();
                sb.append(uniqueArray[i]);
                sb.append(uniqueArray[j]);
                combinations.add(sb.toString());
            }

        }
        List<String> listString = new ArrayList<>();
        //Leave only the twos
        List<String> parsedString = new ArrayList<>();
        for (int i = 0; i<combinations.size(); i++) {
            StringBuilder sb = new StringBuilder();
            for (char t: a) {
                Character character = new Character(t);
                String characterString =  character.toString();
                if (combinations.get(i).contains(characterString)) {
                    sb.append(t);
                }
            }

            listString.add(sb.toString());

        }

        //Get rid of the neighbors are the sames
        List<String> finalList = new ArrayList<>();
        for (String one: listString) {
            boolean skip = false;
            if (one.length() >1) {
                char[] b = one.toCharArray();
                for (int i = 1; i<b.length; i++) {
                    if (b[i] == b[i-1]) {
                        skip = true;
                    }
                }

            }

            if (!skip) finalList.add(one);

        }

        //Find the longest one

        int longest = 0;
        for (String one: finalList) {
            if (one.length() > longest) longest = one.length();
        }

        System.out.println(longest);

        return longest;
    }
    public static int countCamelCase(String input) {

        String[] parts = input.split("[A-Z]");
        return parts.length;
    }

    public static String dedupString(String input) {
        String result = "";
        char[] a = input.toCharArray();
        if (a.length == 0) {
            result = "Empty String";
            return result;
        }else if (a.length == 1) {
            return input;
        }
        //if it is longer than 2, we need to find out if there is dup.

        for(int i = 1; i<a.length; i++) {
            if (a[i] == a[i-1]) {
                result = dedupString(input.substring(0, i-1) + input.substring(i+1, a.length));
                break;
            }
            if ( i == a.length -1) {
                //up to the last one already
                return input;
            }
        }
        return result;
    }


    public static boolean isIso(String input1, String input2) {
        boolean same = true;
        if (input1.length() != input2.length()) {
            same = false;
           return same;
        }
        Map<Character, Character> stringMap = new HashMap<>();
        for (int i = 0; i<input1.length(); i++) {String subString1 = input1.substring(i, i+1);
            char char1 = input1.charAt(i);
            char char2 = input2.charAt(i);
            //If hashmap does not have it, add to it;
            if(!stringMap.containsKey(char1)) {
                if (stringMap.containsValue(char2)) {
                    same = false;
                    break;
                }else {
                    stringMap.put(char1, char2);
                }
            }else if (!stringMap.get(char1).equals(char2)) {
                same = false;
                    break;
            }





        }
        return same;
    }


    public static int getMedian(Integer ar1[], Integer ar2[], int n) {



        List<Integer> list1 = Arrays.asList(ar1);
        List<Integer> list2 = Arrays.asList(ar2);

        List<Integer> list3 = new ArrayList<>();

        list3.addAll(list2);
        list3.addAll(list1);
        list3.sort(Comparator.naturalOrder());

        int median = (list3.get(4) + list3.get(5))/2;
        System.out.println();

        return median;
    }

    public static String newRemoveSubString(String input, char subString) {
        return input.replaceAll(Character.toString(subString), "");

    }

    public static int findSecond() {
        int i = -1;

        int[] input = {1, 6, 9, 8, 2};

        return i;
    }

    public static List<String> findDuplicates() {
        List<String> duplidateStrings = new ArrayList<> ();

        String input = "abcccdeee";
        char[] inputChars = input.toCharArray();
        int length = 1;
        int index = 0;
        for(int i = 1; i<inputChars.length; i++) {
          //If it is end of the line:
          if ((i == inputChars.length -1)&& length >1 ) {
              System.out.println(input.substring(index, index+length));
          }
          if(inputChars[i] == inputChars[i-1]) {
                //same
                length ++;
          } else {
              //not same
              if (length >1) {
                  System.out.println(input.substring(index, index+length));
              }
              //reset to start a new one
              length = 1;
              index = i;
          }
        }
        return duplidateStrings;
    }
}
