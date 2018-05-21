package com.sblabs;

import java.util.Stack;
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
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(1);
        ListNode third = new ListNode(2);
        ListNode fourth = new ListNode(3);
        ListNode fifth = new ListNode(3);

        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;

        deleteDuplicates(first);

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
        /*ListNode result = null;
        ListNode prev = null;
        ListNode currA = A;
        ListNode currB = B;
        int count = 0;

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
        Stack<ListNode> reversed = addLists(larger, smaller);
        if (!reversed.isEmpty()) {
            result = reversed.pop();
            prev = result;
        }

        while(!reversed.isEmpty()) {
            ListNode node = reversed.pop();
            System.out.println(node.val);
            prev.next = node;
            prev = node;
        }
        System.out.println("\n");
        return result;*/
        //endregion myattempt
        ListNode lastNode = null;
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

        return newList;
    }

    // my helper for add lists
    public static Stack<ListNode> addLists(ListNode larger, ListNode smaller) {
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
    }

    // my helper for add lists
    public int getSize(ListNode A) {
        int count = 0;
        while(A != null) {
            count++;
            A = A.next;
        }
        return count;
    }
}
