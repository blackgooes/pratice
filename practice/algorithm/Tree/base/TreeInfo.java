package base; /**
 * 二叉树的前序、中序、后序遍历
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TreeInfo {
    List<Integer> qianxuNumList;
    List<Integer> zhongxuNumList;
    List<Integer> houxuNumList;
    List<Integer> preorderNumList;
    List<Integer> inorderNumList;
    List<Integer> postorderNumList;

    public TreeInfo() {
        qianxuNumList = new ArrayList<Integer>();
        zhongxuNumList = new ArrayList<Integer>();
        houxuNumList = new ArrayList<Integer>();
        preorderNumList = new ArrayList<Integer>();
        inorderNumList = new ArrayList<Integer>();
        postorderNumList = new ArrayList<Integer>();
    }

    // 用递归的方法进行先序遍历
    public void qianxuDigui(TreeNode treeNode) {
        qianxuNumList.add(treeNode.val);
        if (treeNode.left != null) {
            qianxuDigui(treeNode.left);
        }
        if (treeNode.right != null) {
            qianxuDigui(treeNode.right);
        }
    }

    // 用递归的方法进行中序遍历
    public void zhongxuDigui(TreeNode treeNode) {
        if (treeNode.left != null) {
            zhongxuDigui(treeNode.left);
        }
        zhongxuNumList.add(treeNode.val);
        if (treeNode.right != null) {
            zhongxuDigui(treeNode.right);
        }
    }

    // 用递归的方法进行后序遍历
    public void houxuDigui(TreeNode treeNode) {
        if (treeNode.left != null) {
            houxuDigui(treeNode.left);
        }
        if (treeNode.right != null) {
            houxuDigui(treeNode.right);
        }
        houxuNumList.add(treeNode.val);
    }

    // 用非递归的方法进行先序遍历
    public void qianxuFeiDigui(TreeNode treeNode) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (treeNode != null || !stack.isEmpty()) {
            while (treeNode != null) {
                qianxuNumList.add(treeNode.val);
                stack.push(treeNode);
                treeNode = treeNode.left;
            }
            if (!stack.isEmpty()) {
                treeNode = stack.pop();
                treeNode = treeNode.right;
            }
        }
    }

    // 用非递归的方法进行中序遍历
    public void zhongxuFeiDigui(TreeNode treeNode) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (treeNode != null || !stack.isEmpty()) {
            while (treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.left;
            }
            if (!stack.isEmpty()) {
                treeNode = stack.pop();
                zhongxuNumList.add(treeNode.val);
                treeNode = treeNode.right;
            }
        }
    }

    // 用非递归的方法进行后序遍历
    public void houxuFeiDigui(TreeNode treeNode) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (treeNode != null || !stack.isEmpty()) {
            while (treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.left;
            }
            boolean tag = true;
            TreeNode preNode = null;  // 前驱节点
            while (!stack.isEmpty() && tag == true) {
                treeNode = stack.peek();
                if (treeNode.right == preNode) { // 之前访问的为空节点或是栈顶节点的右子节点
                    treeNode = stack.pop();
                    houxuNumList.add(treeNode.val);
                    if (stack.isEmpty()) {
                        return;
                    } else {
                        preNode = treeNode;
                    }
                } else {
                    treeNode = treeNode.right;
                    tag = false;
                }
            }
        }
    }

    // 用非递归的方法进行先序遍历
    public void preorderTraversal(TreeNode treeNode) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (treeNode != null || !stack.isEmpty()) {
            // 遍历到第一个左下节点为空
            while (treeNode != null) {
                // 记录遍历的节点，入栈
                preorderNumList.add(treeNode.val);
                stack.push(treeNode);
                treeNode = treeNode.left;
            }
            // 要考虑到 左无子节点，有右节点的情况
            if (!stack.isEmpty()) {
                treeNode = stack.pop();
                treeNode = treeNode.right;
            }
        }
    }

    // 用非递归的方法进行中序遍历
    public void inorderTraversal(TreeNode treeNode) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (treeNode != null || !stack.isEmpty()) {
            // 遍历到第一个左下节点为空
            while (treeNode != null) {
                // 记录遍历的节点，入栈
                stack.push(treeNode);
                treeNode = treeNode.left;
            }
            if (!stack.isEmpty()) {
                treeNode = stack.pop();
                inorderNumList.add(treeNode.val);
                treeNode = treeNode.right;
            }
        }
    }
    /**
     *              1
     *          2           3
     *            5      6     7
     *          10
     *
     * @return
     */
    // postorderTraversal
    public void postorderTraversal(TreeNode treeNode) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        boolean flag = false;
        TreeNode preNode = null;
        while (treeNode != null || !stack.isEmpty()) {
            // 遍历到第一个左下节点为空
            while (treeNode != null) {
                // 记录遍历的节点，入栈
                stack.push(treeNode);
                treeNode = treeNode.left;
            }
            flag = false;
            if(!stack.isEmpty()) {
                treeNode = stack.peek();
                if(treeNode.right != null) {
                    flag = true;
                    treeNode = treeNode.right;
                }
            }
            if (!stack.isEmpty() && flag == false && treeNode!= null && treeNode.left == null && treeNode.right == null) {
                treeNode = stack.pop();
                postorderNumList.add(treeNode.val);
                treeNode = treeNode.left;
            }
        }
    }

    /**
     *              1
     *          2           3
     *       4    5      6     7
     *    8  9  10 11  12 13  14 15
     *
     * @return
     */
    // 构造二叉树，返回根节点
    public TreeNode treeSet() {
        TreeNode root = new TreeNode(1);
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(3);
//        TreeNode c = new TreeNode(4);
        TreeNode d = new TreeNode(5);
        TreeNode e = new TreeNode(6);
        TreeNode f = new TreeNode(7);
        TreeNode g = new TreeNode(8);
        TreeNode h = new TreeNode(9);
        TreeNode i = new TreeNode(9);
        TreeNode j = new TreeNode(10);
        TreeNode k = new TreeNode(11);
        TreeNode l = new TreeNode(12);
        TreeNode m = new TreeNode(13);
        TreeNode n = new TreeNode(14);
        TreeNode o = new TreeNode(15);


        root.left = a;
        root.right = b;
//        a.left = c;
        a.right = d;
        b.left = e;
        b.right = f;
        d.left = j;
        return root;
    }

    // 打印序列
    public void print(int type) {
        if (type == 1) {
            System.out.print("前序遍历：");
            for (Integer integer : this.qianxuNumList) {
                System.out.print(integer + "  ");
            }
            System.out.println();
        } else if (type == 2) {
            System.out.print("中序遍历：");
            for (Integer integer : this.zhongxuNumList) {
                System.out.print(integer + "  ");
            }
            System.out.println();
        } else if (type == 3) {
            System.out.print("后序遍历：");
            for (Integer integer : this.houxuNumList) {
                System.out.print(integer + "  ");
            }
            System.out.println();
        } else if (type == 4) {
            System.out.print("前序遍历：");
            for (Integer integer : this.preorderNumList) {
                System.out.print(integer + "  ");
            }
            System.out.println();
        }else if (type == 5) {
            System.out.print("中序遍历：");
            for (Integer integer : this.inorderNumList) {
                System.out.print(integer + "  ");
            }
            System.out.println();
        }else if (type == 6) {
            System.out.print("后序遍历2：");
            for (Integer integer : this.postorderNumList) {
                System.out.print(integer + "  ");
            }
            System.out.println();
        } else {
            return;
        }
    }

    public static void main(String[] args) {
        TreeInfo treeInfo = new TreeInfo();
        TreeNode root = treeInfo.treeSet();

        String a = "abcd";
        System.out.println(a.substring(1,2));
        System.out.println("-------递归---------");
        treeInfo.qianxuDigui(root); // 前序遍历
        treeInfo.print(1);
        treeInfo.zhongxuDigui(root); // 中序遍历
        treeInfo.print(2);
        treeInfo.houxuDigui(root); // 后序遍历
        treeInfo.print(3);

        System.out.println("------非递归--------");
        treeInfo.qianxuNumList.clear();
        treeInfo.zhongxuNumList.clear();
        treeInfo.houxuNumList.clear();

        treeInfo.qianxuFeiDigui(root); // 前序遍历
        treeInfo.print(1);
        treeInfo.zhongxuFeiDigui(root);
        treeInfo.print(2);
        treeInfo.houxuFeiDigui(root);
        treeInfo.print(3);
        treeInfo.preorderTraversal(root);
        treeInfo.print(4);
        treeInfo.inorderTraversal(root);
        treeInfo.print(5);
        treeInfo.postorderTraversal(root);
        treeInfo.print(6);
    }

}
