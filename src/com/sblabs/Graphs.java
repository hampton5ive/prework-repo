package com.sblabs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
public class Graphs {

    public static void main(String[] args) {
        TreeNode A = new TreeNode(3);
        TreeNode nine = new TreeNode(9);
        TreeNode twenty = new TreeNode(20);
        TreeNode fifteen = new TreeNode(15);
        TreeNode seven = new TreeNode(7);
        A.left= nine;
        A.right = twenty;
        twenty.left = fifteen;
        twenty.right = seven;
        int[][] result = levelOrder(A);
        boolean resultBool = true;
    }

    static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    static class ListNode {
      public int val;
      public ListNode next;
      ListNode(int x) { val = x; next = null; }
    }

    public static int[][] levelOrder(TreeNode A) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        int[][] result = new int[0][0];
        if (A == null) return result;

        int numLevels = 0;
        q.add(A);
        ArrayList<ArrayList<Integer>> listOfPaths = new ArrayList<ArrayList<Integer>>();
        while(!q.isEmpty()) {
            int s = q.size();
            ArrayList<Integer> nodes = new ArrayList<Integer>();
            for(int i=0; i < s; i++) {
                TreeNode n = q.poll();
                nodes.add(n.val);
                if (n.left != null) {
                    q.add(n.left);
                }
                if (n.right != null) {
                    q.add(n.right);
                }
            }
            listOfPaths.add(nodes);
        }

        return toIntArr(listOfPaths);
    }

    public static int[][] toIntArr(ArrayList<ArrayList<Integer>> listOfPaths) {
        int[][] lol = new int[listOfPaths.size()][];
        for(int i=0; i < listOfPaths.size(); i++) {
            int currSize = listOfPaths.get(i).size();
            lol[i] = new int[currSize];
            for (int j=0; j < currSize; j++) {
                lol[i][j] = listOfPaths.get(i).get(j);
            }
        }
        return lol;
    }

    public static TreeNode sortedListToBST(ListNode a) {
        ArrayList<Integer> num = new ArrayList<Integer>();

        while(a!=null)
        {
            num.add(a.val);
            a=a.next;
        }

        return construct(num,0, num.size()-1);
    }

    public static TreeNode construct(ArrayList<Integer> num,int s, int e)
    {
        if(s>e)
            return null;
        int mid = s+(e-s)/2;
        TreeNode node = new TreeNode(num.get(mid));
        node.left = construct(num,s,mid-1);
        node.right= construct(num,mid+1,e);
        return node;
    }

    // How many min numbers from fibonacci are needed to sum to A?
    public int fibsum(int A) {
        List<Integer> fib = new ArrayList<Integer>();
        fib.add(1);
        fib.add(1);
        while (fib.get(fib.size() - 1) < A) {
            fib.add(fib.get(fib.size() - 1)
                    + fib.get(fib.size() - 2));
        }

        int ans = 0;
        int index = fib.size() - 1;
        while (A > 0) {
            if (A >= fib.get(index)) {
                ans += A / fib.get(index);
                A %= fib.get(index);
            }
            index--;
        }

        return ans;
    }

    // flatten list of strings into matrix
    // iterate matrix.  if i encounter a X whose coordinates dont exist in a hashset,
    // call buildshape to add coordinates to the hashset.  each initial call to buildShape
    // is a different shape
    /*HashSet<String> shapePts = new HashSet<String>();
    char[][] matrix;
    public int black(String[] A) {
        matrix = new char[A.length][];
        for (int i=0; i < A.length; i++) {
            String row = A[i];
            char[] rowCols = row.toCharArray();
            matrix[i] = new char[rowCols.length];
            for (int j=0; j < rowCols.length; j++) {
                matrix[i][j] = rowCols[j];
            }
        }

        int num = 0;
        for (int row=0; row < matrix.length; row++) {
            for (int col=0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'X') {
                    String coordinates = row + ", " + col;
                    if (!shapePts.contains(coordinates)) {

                        num++;
                        shapePts.add(coordinates);
                        buildShape(row, col);
                    }
                }
            }
        }
        return num-1;
    }

    // if this is called the first time, there is a new shape being created
    public void buildShape(int i, int j) {
        // left of [i][j], [i][j-1]
        int left = j-1;
        if (left < 0)
            return;
        // top [i-1][j]
        int top = i-1;
        if (top < 0)
            return;
        // right [i][j+1]
        int right = j+1;
        if (right > matrix[i].length-1)
            return;
        // bottom [i+1][j]
        int bottom = i+1;
        if (bottom > matrix.length-1)
            return;

        recursiveHelper(i, left);
        recursiveHelper(top, j);
        recursiveHelper(i, right);
        recursiveHelper(bottom, j);

    }

    public void recursiveHelper(int i, int j) {
        String pt = i + ", " + j;
        if (!shapePts.contains(pt) && matrix[i][j] == 'X') {
            shapePts.add(pt);
            buildShape(i, j);
        }
    }*/
    public int black(ArrayList<String> A)
    {
        int m=A.size();
        int n=A.get(0).length();
        if(m==0)
            return 0;
        int count=0;
        boolean[][]visited=new boolean[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                visited[i][j]=false;
            }
        }
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(A.get(i).charAt(j)=='X' && visited[i][j]==false)
                {
                    dfs(A,i,j,m,n,visited);
                    count++;
                }
            }
        }
        return count;
    }
    public void dfs(ArrayList<String>A,int i,int j,int m,int n,boolean[][]visited)
    {
        if(i<0 || j<0 || i>=m || j>=n)
            return ;
        if(A.get(i).charAt(j)=='O' || visited[i][j])
            return;
        visited[i][j]=true;
        dfs(A,i+1,j,m,n,visited);
        dfs(A,i,j+1,m,n,visited);
        dfs(A,i-1,j,m,n,visited);
        dfs(A,i,j-1,m,n,visited);
    }

    public int[] stepnum(int a, int b) {

        ArrayList<Integer> ans = new ArrayList<Integer>();
        if(a <= 0 && b >= 0){
            ans.add(0);
        }

        for(int i = 1; i <= 9; i++){
            findRoutes(ans, a, b, i, i);
        }

        Collections.sort(ans);
        int[] arr = new int[ans.size()];
        for (int i=0; i < ans.size(); i++) {
            arr[i] = ans.get(i);
        }
        return arr;
    }

    public void findRoutes(ArrayList<Integer> ans, int a, int b, int start, int curr){

        if(curr <= b){
            if(curr >= a){
                ans.add(curr);
            }
            if(start != 0){
                findRoutes(ans, a, b, start - 1, curr * 10 + start - 1);
            }
            if(start != 9){
                findRoutes(ans, a, b, start + 1, curr * 10 + start + 1);
            }
        }
    }
}
