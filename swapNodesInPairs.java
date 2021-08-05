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

class ListNode {
    public int data;
    public ListNode next;

    public ListNode(int nodeData) {
        this.data = nodeData;
        this.next = null;
    }
}

class SinglyLinkedList {
    public ListNode head;
    public ListNode tail;

    public SinglyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void insertNode(int nodeData) {
        ListNode node = new ListNode(nodeData);

        if (this.head == null) {
            this.head = node;
        } else {
            this.tail.next = node;
        }

        this.tail = node;
    }
}

class SinglyLinkedListPrintHelper {
    public static void printList(ListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }
}



class Result {

    /*
     * Complete the 'swapNodesInPairs' function below.
     *
     * The function is expected to return an INTEGER_SINGLY_LINKED_LIST.
     * The function accepts INTEGER_SINGLY_LINKED_LIST head as parameter.
     */

    /*
     * For your reference:
     *
     * ListNode {
     *     int data;
     *     ListNode next;
     * }
     *
     */

    public static ListNode swapNodesInPairs(ListNode head) {
        if(head == null) return null;

        // dummy node method
        ListNode dummy = head;
        ListNode curr = head;

        // iterate thru
        while(curr.next != null) {
            ListNode temp = new ListNode(curr.data); // store temp value
            ListNode nextNode = curr.next; // store next node

            // switch the node's values
            curr.data = nextNode.data;
            nextNode.data = temp.data;

            if(curr.next.next == null) {
                return dummy;
            }
            
            curr = curr.next.next;
        }
        
        return dummy;
    }

}

public class Solution {