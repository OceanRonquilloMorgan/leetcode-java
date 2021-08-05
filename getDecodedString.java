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
     * Complete the 'getDecodedString' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING encoded as parameter.
     */

    public static String getDecodedString(String encoded) {
        // edge cases
        if(encoded.length() == 0) return "";

        int stack = 0;
        int start = -1;
        int end = -1;
        int num = 0;

        for(int i = 0; i < encoded.length(); i++) {
            if(encoded.charAt(i) == '[') {
                if(start == -1) {
                    start = i;
                }
                stack++;
            }

            else if(encoded.charAt(i) == ']') {
                stack--;
                if(stack == 0) {
                    end = i;
                    break;
                }
            }

        }

        if(start == -1) return encoded;

        String res = "";

        for(int i = 0; i < start; i++) {
            if(encoded.charAt(i) >= '0' && encoded.charAt(i) <= '9') {
                num = num*10 + encoded.charAt(i) - '0';
            }

            else {
                res += encoded.charAt(i);
            }
        }

        String str = getDecodedString(encoded.substring(start+1, end));

        for(int i = 0; i < num; i++) {
            res += str;
        }

        return res + getDecodedString(encoded.substring(end+1));
    }

}

public class Solution {