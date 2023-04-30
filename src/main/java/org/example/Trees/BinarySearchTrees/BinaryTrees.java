package org.example.Trees.BinarySearchTrees;

import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTrees {

    int index = -1;

    public TreeNode buildTree(int[] nodes) {

        index++;
        if (nodes[index] == -1) {
            return null;

        }

        TreeNode node = new TreeNode(nodes[index]);
        node.setLeftNode(buildTree(nodes));
        node.setRightNode(buildTree(nodes));

        return node;
    }

    public int diameterOfTree(TreeNode root){
        if(root==null){
            return 0;
        }
        int diameter1 = diameterOfTree(root.getLeftNode());
        int diameter2 = diameterOfTree(root.getRightNode());
        int diameter3 = this.heightOfTree(root.getRightNode())+this.heightOfTree(root.getLeftNode())+1;
        return Math.max(Math.max(diameter1,diameter2),diameter3);
    }

    public int heightOfTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = heightOfTree(root.getLeftNode());
        int righHeight = heightOfTree(root.getRightNode());

        return Math.max(leftHeight, righHeight) + 1;

    }

    public int totalNodes(TreeNode root) {

        if (root == null) {
            return 0;
        }
        int leftNodes = totalNodes(root.getLeftNode());
        int rightNodes = totalNodes(root.getRightNode());

        return leftNodes + rightNodes + 1;
    }


    public void levelOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.remove();
            if (currentNode == null) {
                System.out.println("");
                if (queue.isEmpty()) {
                    break;
                } else {
                    queue.add(null);
                }
            } else {
                System.out.print(currentNode.getData());
                if (currentNode.getLeftNode() != null) {
                    queue.add(currentNode.getLeftNode());
                }
                if (currentNode.getRightNode() != null) {
                    queue.add(currentNode.getRightNode());
                }
            }
        }

    }

    public void preOrderTraversal(TreeNode root) {

        if (root == null) {
            return;
        }
        System.out.print(root.getData() + ",");
        preOrderTraversal(root.getLeftNode());
        preOrderTraversal(root.getRightNode());
    }

    public void postOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrderTraversal(root.getLeftNode());
        postOrderTraversal(root.getRightNode());
        System.out.print(root.getData() + ",");
    }

    public void inOrderTraversal(TreeNode rootNode){
        if(rootNode==null){
            return;
        }
        inOrderTraversal(rootNode.getLeftNode());
        System.out.print(rootNode.getData()+",");
        inOrderTraversal(rootNode.getRightNode());
    }



    public boolean isIdentical(TreeNode rootNode, TreeNode subrootNode){
        if(subrootNode==null && rootNode==null){
            return true;
        }
        if(subrootNode==null|| rootNode==null){
            return false;
        }
        if(rootNode.getData()==subrootNode.getData()){
            return isIdentical(rootNode.getLeftNode(),subrootNode.getLeftNode())&&isIdentical(rootNode.getRightNode(),subrootNode.getRightNode());
        }

        return false;
    }

    public boolean lookForaNode(TreeNode node, int value) {
        boolean isFound = false;
        if (node == null) {
            System.out.println("not found");
            return false;
        }

        isFound=  lookForaNode(node.getLeftNode(), value);
        isFound= lookForaNode(node.getRightNode(), value);
        if (node.getData() == value) {
            isFound=true;
            return isFound;

        }
        return isFound;
    }

    public boolean isSubTree(TreeNode rootNode,TreeNode subroot){
        if(rootNode==null){
            return false;
        }
        if(subroot==null){
            return true;
        }
        System.out.println();
        if(rootNode.getData()==subroot.getData()){
            if(isIdentical(rootNode,subroot)) {
                return true;
            }
        }

        return isSubTree(rootNode.getLeftNode(),subroot)||isSubTree(rootNode.getRightNode(),subroot);
    }

    public static void main(String[] args) {
        System.out.println("binary trees....");
        BinaryTrees bt = new BinaryTrees();
        int[] nodes = {1,2,4,6,-1,7,-1, -1, -1, 5,8,-1,9,-1, -1, -1, 3, 10,-1,-1, 6, -1, -1};
        int[] subnodes = {3,10,-1,-1,6,-1,-1};
        TreeNode rootNode = bt.buildTree(nodes);
        bt.index=-1;
        TreeNode subrootNode = bt.buildTree(subnodes);
        System.out.println("root node :" + rootNode.getData());
        System.out.println("sub treee+=======");
        bt.levelOrderTraversal(subrootNode);
        System.out.println("Main tree======");
        bt.inOrderTraversal(rootNode);
       /* bt.preOrderTraversal(rootNode);
        System.out.println();
        bt.postOrderTraversal(rootNode);
        System.out.println();
        int height = bt.heightOfTree(rootNode);
        System.out.println(height);

        int totalNodes = bt.totalNodes(rootNode);
        System.out.println(totalNodes);
        System.out.println("the diameter of the tree is :");
        int diam=bt.diameterOfTree(rootNode);
        System.out.print(diam);*/

     /*  boolean isSubtree= bt.isSubTree(rootNode,subrootNode);
        System.out.println(isSubtree);*/


        System.out.println(bt.lookForaNode(subrootNode,10));
    }
}
