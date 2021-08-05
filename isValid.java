import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


class Result {

    /*
     * Complete the 'isValid' function below.
     *
     * The function is expected to return a BOOLEAN.
     * The function accepts STRING str as parameter.
     */

    public static boolean isValid(String str) {
        // declare new stack
        Stack<Character> stack = new Stack<>();

        // convert string into char array for easier parsing
        char[] charArray = str.toCharArray();

        // iterate thru given string
        for(char s : charArray) {
            // push closing expression
            if(s == '{') {
                stack.push('}');
            }
            else if(s == '(') {
                stack.push(')');
            }
            else if(s == '[') {
                stack.push(']');
            }
            else {
                // empty stack or incorrect matching
                if(stack.empty() || s != stack.peek()) {
                    return false;
                }
                // move onto next
                stack.pop();
            }
        }

        // true / false if empty
        return stack.empty();
    }

}

public class Solution {