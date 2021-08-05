import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class PrintHelper {
    public static void printList(Queue q, BufferedWriter bufferedWriter) throws IOException {
        while (!q.isEmpty()) {
            int val = (int)q.poll();
            bufferedWriter.write(String.valueOf(val));
            bufferedWriter.write(" ");
        }
    }
}



class Result {

    /*
     * Complete the 'reverseFirstKElements' function below.
     *
     * The function accepts following parameters:
     *  1. Queue queue
     *  2. INTEGER k
     */

    public static void reverseFirstKElements(Queue<Integer> queue, int k) {
        // edge cases: empty queue or k is greater than size of queue
        if(queue.isEmpty() || k <= 0 || k > queue.size()) {
            return;
        }

        // declare stack
        Stack<Integer> stack = new Stack<Integer>();

        // push first k elements into stack
        for(int i = 0; i < k; i++) {
            // add to stack and move onto next in queue
            stack.push(queue.remove());
        }

        // begin reversing: add to queue
        while(!stack.empty()) {
            queue.add(stack.peek());
            // move onto next
            stack.pop();
        }

        // remove remaining elements
        int length = queue.size() - k;

        // complete reversals
        for(int i = 0; i < length; i++) {
            queue.add(queue.remove());
        }
    }

}

public class Solution {