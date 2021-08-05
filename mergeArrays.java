import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Result {

    /*
     * Complete the 'mergeArrays' function below.
     *
     * Do not return anything, modify the array nums1
     */
    public static void mergeArrays(int[] nums1, int[] nums2) {
        int i = nums1.length - nums2.length - 1;

        int j = nums2.length - 1;

        int buffer = i + nums2.length;

        // merge nums1 and nums2 beginning from last element in both
        while(j >= 0) {
            if(i >= 0 && nums1[i] > nums2[j]) {
                // copy element
                nums1[buffer] = nums1[i];
                i--;
            }

            else {
                //copy element
                nums1[buffer] = nums2[j];
                j--;
            }

            // move indices over
            buffer--;

        }      
    }
}

public class Solution {