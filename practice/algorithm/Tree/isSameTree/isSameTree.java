//package isSameTree;
//
//import base.TreeNode;
//
///**
// * Definition for a binary tree node.
// * public class base.TreeNode {
// *     int val;
// *     base.TreeNode left;
// *     base.TreeNode right;
// *     base.TreeNode() {}
// *     base.TreeNode(int val) { this.val = val; }
// *     base.TreeNode(int val, base.TreeNode left, base.TreeNode right) {
// *         this.val = val;
// *         this.left = left;
// *         this.right = right;
// *     }
// * }
// */
//class Solution {
//    public boolean isSameTree(TreeNode p, TreeNode q) {
//        if(p == null && q == null) {
//            return true;
//        }
//        if(q == null || p == null) {
//            return false;
//        }
//        if(q.val != p.val){
//            return false;
//        }
//        return false;
//    }
//
//}
