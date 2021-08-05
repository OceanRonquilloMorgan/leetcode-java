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
     * Complete the 'fizzbuzz' function below.
     */
    public static void fizzbuzz(int[] nums) {
        for(int i = 0; i < nums.length; i++)
        {
            int n = nums[i];
            
            // divisible by 3 and 5
            if(n%3 == 0 && n%5 == 0)
            {
                System.out.println("fizzbuzz");
            }

            // divisible by 3
            else if(n%3 == 0)
            {
                System.out.println("fizz");
            }

            // divisible by 5
            else if(n%5 == 0 )
            {
                System.out.println("buzz");
            }

            // neither
            else
            {
                System.out.println(nums[i]);
            }
        }
    }

}
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = IntStream.range(0, arrCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        int[] nums = new int[arr.size()];
        int i = 0;
        for (int num: arr) {
            nums[i] = num;
            i ++;
        }
        Result.fizzbuzz(nums);

        bufferedReader.close();
    }
}
