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
     * Complete the 'isPalindrome' function below.
     *
     * The function is expected to return a BOOLEAN.
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

    public static boolean isPalindrome(ListNode head) {
        // edge case - empty node
        if(head == null || head.next == null) return true;

        // uses 2 pointer method
        ListNode slow = head;
        ListNode fast = head;

        // advance correct places between both pointers
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;       // skip 1 over
            fast = fast.next.next; // skip 2 over
        }

        ListNode newHead = slow.next;
        slow.next = null;

        // reverse part of list
        ListNode p1 = newHead;
        ListNode p2 = p1.next;

        while(p1 != null && p2 != null) {
            // switch them
            ListNode temp = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = temp;
        }

        // reset
        newHead = null;

        // compare sublists
        ListNode x = head;
        ListNode y = (p2 == null ? p1:p2);
        while(y != null) {
            if(x.data != y.data) {
                return false;
            }

            x = x.next;
            y = y.next;
        }

        return true;
        
    }

}

public class Solution {