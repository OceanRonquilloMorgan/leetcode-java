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
     * Complete the 'getIntersectionNode' function below.
     *
     * The function is expected to return an INTEGER_SINGLY_LINKED_LIST.
     * The function accepts 2 INTEGER_SINGLY_LINKED_LIST head as parameter.
     * BufferedWriter is provided as third parameter for printing debug information.
     * 
     * You may check equality of data in order to check if the node are same. 
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

    public static ListNode getIntersectionNode(ListNode list1, ListNode list2) {
        // edge case: empty lists
        if(list1 == null || list2 == null) return null;

        // find out each length
        int length1 = getLength(list1);
        int length2 = getLength(list2);

        // amount to skip for uneven lengths
        int skip = Math.abs(length1 - length2);

        // O(n)
        while(skip > 0) {
            // if first list's length is longer
            if(length1 > length2) {
                list1 = list1.next;
                skip--;
            }
            else {
                list2 = list2.next;
                skip--;
            }
        }
        
        // O(n)
        while(list1.data != list2.data) {
            list1 = list1.next;
            list2 = list2.next;
        }

        return list1;
    }

    // helper function to get length of a linked list
    public static int getLength(ListNode head) {
        int count = 0;
        while(head != null) {
            head = head.next;
            count++;
        }

        return count;
    }

}

public class Solution {