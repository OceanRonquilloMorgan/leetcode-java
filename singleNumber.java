import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;



class Solution {

    /*
     * Complete the 'singleNumber' function below.
     *
     * The function is expected to return an INTEGER.
     */

    public static int singleNumber(int[] nums) {
    // key = count, value = the number
    Hashtable<Integer, Integer> map = new Hashtable<Integer, Integer>();

    // add to our hashmap
    for(int i = 0; i < nums.length; i++) {
        Integer count = map.get(nums[i]);

        // value doesn't exist in map yet
        if(count == null) {
                map.put(nums[i], 1);
        }
        // value already exists
        else {
            // increment count
            map.put(nums[i], count + 1);
        }
    }

    // O(n) - iterate back thru to identify
    // elements in hashtable
    for(int i = 0; i < nums.length; i++) {
        Integer count = map.get(nums[i]);
        if(count == 1) {
            return nums[i];
        }
        else continue;
    }

    return nums[0];

        
    }


    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        String allNums = scanner.nextLine().trim();
        String[] splitNums = allNums.split("\\s+");
        int[] nums = new int[splitNums.length];
        for (int i = 0; i < splitNums.length; i++){
            nums[i] = Integer.parseInt(splitNums[i]);
        }
        
        System.out.println(singleNumber(nums));
    }
}
