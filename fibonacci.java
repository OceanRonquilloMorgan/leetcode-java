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
     * Complete the 'fibonacci' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts INTEGER n as parameter.
     */
    public static long fibonacci(int n) {
        // iterative method because recursion timeouts
        if(n == 0 || n == 1) return (long) n;

        long fib = 1;
        long prevFib = 1;

        for (int i = 2; i < n; i++) 
        {
            long temp = fib;
            fib += prevFib;
            prevFib = temp;
        }
        return (long) fib;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        long result = Result.fibonacci(n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
