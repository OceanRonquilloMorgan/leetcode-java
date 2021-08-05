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
     * Complete the 'convertToBinary' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts INTEGER num as parameter.
     */

    public static String convertToBinary(int num) {
        String output = "";
        while(num > 0) {
            // use bit manipulation
            output = ((num%2) == 0 ? "0" : "1") + output;
            // move int placement over
            num = num/2;
        }
        return output;
    }

}

public class Solution {