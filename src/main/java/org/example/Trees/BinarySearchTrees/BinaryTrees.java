package org.example.Trees.BinarySearchTrees;

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


    public static void main(String[] args) {
        System.out.println("binary trees....");
        BinaryTrees bt = new BinaryTrees();
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        TreeNode rootNode = bt.buildTree(nodes);
        System.out.println("root node :" + rootNode.getData());
        bt.levelOrderTraversal(rootNode);
        bt.preOrderTraversal(rootNode);
        System.out.println();
        bt.postOrderTraversal(rootNode);
        System.out.println();
        int height = bt.heightOfTree(rootNode);
        System.out.println(height);

        int totalNodes = bt.totalNodes(rootNode);
        System.out.println(totalNodes);
    }
}
