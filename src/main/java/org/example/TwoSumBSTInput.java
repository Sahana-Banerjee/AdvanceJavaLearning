package org.example;

import java.util.ArrayList;
import java.util.List;

public class TwoSumBSTInput {
    public static int c = 0;
    //Definition for a binary tree node.
      public static final class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }


    static List<Integer> bl = new ArrayList<>();
    public static boolean findTarget(TreeNode root, int k) {

        createList(root, k);
        if(c>=1)
            return true;

        return false;

    }

    public static void createList(TreeNode root,int k){
        if(root != null){
            int compl = k - root.val;

            if(bl.contains(compl)){
                c++;
                //return true;
            }

            if(c == 0){
                bl.add(root.val);
                System.out.println(root.val);
                createList(root.left, k);
                createList(root.right, k);
            }

        }
    }

    public static void main(String[] args) {
        TreeNode n = new TreeNode();
        //[5,3,6,2,4,null,7]
        n.val = 5;
        n.left = new TreeNode(3);

        n.right = new TreeNode(6);
        n.left.left = new TreeNode(2);
        n.left.right =new TreeNode(4);
        n.right.left = null;
        n.right.right = new TreeNode(7);;
        System.out.println(findTarget(n, 9));
    }
}
