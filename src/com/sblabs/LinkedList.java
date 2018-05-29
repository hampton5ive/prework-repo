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

    public static ListNode addTwoNumbers(ListNode A, ListNode B) {
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
        /*if (!reversed.isEmpty()) {
            result = reversed.pop();
            prev = result;
        }
        System.out.println(prev.val);
        while(!reversed.isEmpty()) {
            ListNode node = reversed.pop();
            prev.next = node;
            prev = node;
        }
        return result;*/

        //endregion myattempt
        /*ListNode lastNode = null;
        ListNode newList = null;
        int carry  =0;
        int addendum = 0;
        while(A!=null || B!=null){

            int total = carry;
            if(A!=null){
                total+=A.val;
            }
            if(B!=null){
                total+=B.val;
            }

            addendum = total%10;
            carry = total/10;
            if(lastNode==null){
                lastNode =  new ListNode(addendum);
                newList = lastNode;
            }else{
                lastNode.next = new ListNode(addendum);
                lastNode = lastNode.next;

            }
            if(A!=null)
                A = A.next;

            if(B!=null)
                B = B.next;
        }
        if(carry>0)
            lastNode.next = new ListNode(carry);

        return newList;*/
    }

    // my helper for add lists
    /*public static Stack<ListNode> addLists(ListNode larger, ListNode smaller) {
        Stack<ListNode> reversedResult = new Stack<ListNode>();
        boolean carry = false;
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
            reversedResult.push(new ListNode(sum));
            larger = larger.next;
            if (smaller != null) {
                smaller = smaller.next;
            }
        }
        if (carry) {
            reversedResult.push(new ListNode(1));
        }
        return reversedResult;
    }*/

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
    }

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
