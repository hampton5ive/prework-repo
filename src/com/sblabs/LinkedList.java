package com.sblabs;

/**
 * Created by alextam on 5/20/18.
 */
public class LinkedList {

    static class ListNode {
      public int val;
      public ListNode next;
      ListNode(int x) { val = x; next = null; }
    }

    public static void main(String[] args) {
        /*ListNode first = new ListNode(1);
        ListNode second = new ListNode(1);
        ListNode third = new ListNode(2);
        ListNode fourth = new ListNode(3);
        ListNode fifth = new ListNode(3);

        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;

        deleteDuplicates(first);*/

        ListNode first = new ListNode(12);
        ListNode second = new ListNode(11);
        ListNode third = new ListNode(11);
        ListNode fourth = new ListNode(10);
        ListNode fifth = new ListNode(11);
        ListNode sixth = new ListNode(41);
        ListNode seventh = new ListNode(0);
        ListNode eighth = new ListNode(7);
        ListNode ninth = new ListNode(41);
        ListNode tenth = new ListNode(11);

        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        sixth.next = seventh;
        seventh.next = eighth;
        eighth.next = ninth;
        ninth.next = tenth;

        printList(deleteDuplicatesUnsorted(first));

        /*ListNode first = new ListNode(9);
        ListNode second = new ListNode(9);
        first.next = second;
        ListNode third = new ListNode(1);
        second.next = third;

        ListNode a = new ListNode(1);
        addTwoNumbers(first, a);*/
    }

    public static ListNode deleteDuplicatesUnsorted(ListNode A) {
        ListNode current = A;
        ListNode prev = null;
        while(current != null) {
            System.out.println("Current:" + current.val);
            ListNode other = A;
            int i=0;
            while(other != null) {
                System.out.println(i);
                if (current.val == 11 && i == 7) {
                    boolean breakpt = true;
                }
                if (current != other && current.val == other.val) {
                    prev.next = other.next;
                    other = other.next;
                }
                prev = other;
                if (other != null) {
                    other = other.next;
                }
                i++;
            }
            current = current.next;
        }
        return A;
    }

    public static ListNode deleteDuplicates(ListNode A) {
        ListNode node = A;
        ListNode current = A;
        int num = A.val;
        while (current != null) {
            if (current.val != num) {
                node.next = current;
                num = current.val;
                node = current;
            }
            current = current.next;
        }
        node.next = null;
        return A;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry =0;

        // USED TO CONSTRUCT RESULT LL PROPERLY
        ListNode newHead = new ListNode(0);
        ListNode p1 = l1, p2 = l2, p3=newHead;

        while(p1 != null || p2 != null){
            if(p1 != null){
                carry += p1.val;
                p1 = p1.next;
            }

            if(p2 != null){
                carry += p2.val;
                p2 = p2.next;
            }

            // REMEMBER THIS ORDER, we need this to get the pointers right
            p3.next = new ListNode(carry%10);
            p3 = p3.next;
            carry /= 10;
        }

        if(carry==1)
            p3.next=new ListNode(1);

        // RETURN PROPER HEAD WITHOUT THE DUMMY
        return newHead.next;
    }

    /*public static ListNode addTwoNumbers(ListNode A, ListNode B) {
        //region myattempt
        ListNode result = null;
        ListNode prev = null;
        ListNode currA = A;
        ListNode currB = B;

        int aSize = getSize(A);
        int bSize = getSize(B);

        ListNode larger, smaller;
        if (aSize > bSize) {
            larger = A;
            smaller = B;
        } else {
            larger = B;
            smaller = A;
        }
        return addLists(larger, smaller);
    }

    public static ListNode addLists(ListNode larger, ListNode smaller) {
        ListNode node = null;
        ListNode head = null;
        boolean carry = false;
        int i=0;
        while(larger != null) {
            int smallerVal = 0;
            if (smaller != null) {
                smallerVal = smaller.val;
            }
            int sum = larger.val + smallerVal;
            if (carry) {
                sum++;
                carry = false;
            }
            if (sum > 9) {
                carry = true;
                sum = sum - 10;
            }
            if (i == 0) {
                node = new ListNode(sum);
                head = node;
            } else {
                ListNode current = new ListNode(sum);
                node.next = current;
                node = node.next;
            }
            larger = larger.next;
            if (smaller != null) {
                smaller = smaller.next;
            }
            i++;
        }
        if (carry) {
            ListNode finalNode = new ListNode(1);
            node.next = finalNode;
        }
        return head;
    }

    // my helper for add lists
    public static int getSize(ListNode A) {
        int count = 0;
        while(A != null) {
            count++;
            A = A.next;
        }
        return count;
    }*/

    static void printList(ListNode temp) {
        while(temp != null) {
            System.out.print(temp.val);
            if (temp.next != null) {
                System.out.print("-->");
            }
            temp = temp.next;
        }
    }
}
