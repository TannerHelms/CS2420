package com.example.assign4_drawingtrees;

import android.text.style.IconMarginSpan;

import java.util.HashMap;

public class BinaryTree<E extends Comparable> {
    private TreeNode<E> root;

    private class TreeNode<E> {
        public E data;
        public TreeNode<E> previous;
        public TreeNode<E> left;
        public TreeNode<E> right;
        public TreeNode<E> middle;
        public Branch branch;

        public TreeNode(E data, Branch branch) {
            this.data = data;
            this.branch = branch;
        }
    }
    boolean insert(E value, Branch branch) {
            TreeNode<E> node = new TreeNode<>(value, branch);

            if (root == null) {
                root = node;
                return true;
            }

            TreeNode<E> parent = null;
            TreeNode<E> current = root;

            while (current != null) {
                if (value == current.data) {
                    return false;
                }
                parent = current;
                if (value.compareTo(current.data) < 0) {
                    current = current.left;
                } else {
                    current = current.right;
                }
            }

            if (value.compareTo(parent.data) < 0) {
                parent.left = node;
            } else {
                parent.right = node;
            }
            node.previous = parent;
            return true;
        }
    boolean insertMiddle(E value, Branch branch){
        TreeNode<E> node = new TreeNode<>(value, branch);

        if (root == null) {
            root = node;
            return true;
        }

        TreeNode<E> parent = null;
        TreeNode<E> current = root;

        while (current != null) {
            parent = current;
            current = current.middle;
        }
        parent.middle = node;
        node.previous = parent;
        return true;
    }

    boolean insertOnStem(E stemNumber, E branchNumber, int branchLength, int branchAngle, HashMap<String, Integer> drawParams){
        TreeNode<E> stem = searchStem(stemNumber);

        TreeNode<E> parent = null;
        TreeNode<E> current = stem;

        while (current != null) {
            if (branchNumber == current.data) {
                return false;
            }
            parent = current;
            if (branchNumber.compareTo(current.data) < 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

//        Branch newBranch = new Branch(getMiddle(parent.branch.startX, parent.branch.endX), getMiddle(parent.branch.startY,
//                parent.branch.endY), getMiddle(parent.branch.startX, parent.branch.endX) + 100, getMiddle(parent.branch.startY,
//                parent.branch.endY), drawParams, Branch.BranchType.BRANCH);
//        Branch newBranch = new Branch(getMiddle(parent.branch.startX, parent.branch.endX), getMiddle(parent.branch.startY,
//                parent.branch.endY), getMiddle(parent.branch.startX, parent.branch.startY) + 50, getMiddle(parent.branch.startY,
//                parent.branch.endY) - 100, drawParams, Branch.BranchType.BRANCH);
//        Branch newBranch = new Branch(getMiddle(parent.branch.startX, parent.branch.endX), getMiddle(parent.branch.startY,
//                parent.branch.endY), (float) (1.5 * (float) (getMiddle(parent.branch.startX, parent.branch.endX) - (25 * Math.cos(30)))),
//                (float) (1.5 * (float) (getMiddle(parent.branch.startY, parent.branch.endY) - (25 * Math.sin(30)))), drawParams, Branch.BranchType.BRANCH);
 //       parent.right = new TreeNode<>(branchNumber, newBranch);

        if (parent.data.compareTo(branchNumber) < 0) {
            Branch newBranch = new Branch(getMiddle(parent.branch.startX, parent.branch.endX), getMiddle(parent.branch.startY,
                    parent.branch.endY), (float) (getMiddle(parent.branch.startX, parent.branch.endX) + (branchLength * Math.cos(branchAngle))), (float) (getMiddle(parent.branch.startY,
                                        parent.branch.endY) - (branchLength * Math.sin(branchAngle))), drawParams, Branch.BranchType.BRANCH);
            TreeNode<E> tmpTreeNode = new TreeNode<>(branchNumber, newBranch);
            tmpTreeNode.previous = parent;
            parent.right = tmpTreeNode;
        } else {
            Branch newBranch = new Branch(getMiddle(parent.branch.startX, parent.branch.endX), getMiddle(parent.branch.startY,
                    parent.branch.endY), (float) (getMiddle(parent.branch.startX, parent.branch.endX) - (branchLength * Math.cos(branchAngle))), (float) (getMiddle(parent.branch.startY,
                                        parent.branch.endY) - (branchLength * Math.sin(branchAngle))), drawParams, Branch.BranchType.BRANCH);
            TreeNode<E> tmpTreeNode = new TreeNode<>(branchNumber, newBranch);
            tmpTreeNode.previous = parent;
            parent.left = tmpTreeNode;
        }
        return true;
    }
    private float getMiddle(float start, float end){
        return (start + end) / 2;
    }

    boolean remove(E value) {
        TreeNode<E> parent = null;
        TreeNode<E> node = root;

        boolean done = false;
        while (!done) {
            if (node == null) {
                return false;
            }
            else if (value.compareTo(node.data) < 0) {
                parent = node;
                node = node.left;
            }
            else if (value.compareTo(node.data) > 0) {
                parent = node;
                node = node.right;
            }
            else {
                done = true;
            }
        }

        // Case for no left child
        if (node.left == null) {
            // Special case for root node
            if (parent == null) {
                root = node.right;
            }
            else { // General case for no left child
                if (value.compareTo(parent.data) < 0) {
                    parent.left = node.right;
                }
                else {
                    parent.right = node.right;
                }
            }
        }
        else { // Case for there IS a left child
            TreeNode<E> parentOfRightMost = node;
            TreeNode<E> rightMost = node.left;
            while (rightMost.right != null) {
                parentOfRightMost = rightMost;
                rightMost = rightMost.right;
            }
            node.data = rightMost.data;
            if (parentOfRightMost.right == rightMost) {
                parentOfRightMost.right = rightMost.left;
            }
            else {
                parentOfRightMost.left = rightMost.left;
            }
        }
        return true;
    }
    Branch search(E value){
        TreeNode<E> current = root;
        while(current != null) {
            Branch result = searchForValue(value, current);
            if (result != null) {
                return result;
            }
            if (current.data == value){
                return current.branch;
            }
            current = current.middle;
        }
        return null;
    }
    Branch searchForValue(E value, TreeNode<E> stemBranch) {
        TreeNode<E> current = stemBranch;
        while (current != null) {
            if (value.compareTo(current.data) == 0) {
                return current.branch;
            } else if (value.compareTo(current.data) < 0) {
                current = current.left;
            } else if (value.compareTo(current.data) > 0) {
                current = current.right;
            }
        }
        return null;
    }
    private TreeNode<E> searchStem(E value){
        TreeNode<E> current = root;
        while (current != null) {
            if (current.data.compareTo(value) == 0) {
                return current;
            }
            current = current.middle;
        }
        return null;
    }
    int numberNodes() {
        return numberNodes(root);
    }
    private int numberNodes(TreeNode<E> current) {
        if (current == null) {
            return 0;
        }
        int temp = 1;
        if (current.left != null) {
            temp += numberNodes(current.left);
        }
        if (current.right != null) {
            temp += numberNodes(current.right);
        }
        return temp;

    }
    int numberLeafNodes() {
        return numberLeafNodes(root);
    }
    private int numberLeafNodes(TreeNode<E> current) {
        if (current == null) {
            return 0;
        }
        int temp = 0;
        if (current.left == null && current.right == null) {
            temp = 1;
        }
        if (current.left != null) {
            temp += numberLeafNodes(current.left);
        }
        if (current.right != null) {
            temp += numberLeafNodes(current.right);
        }
        return temp;

    }
    int[] getTreeNodes() {
        int[] tmpArr = new int[]{};
        return inOrderTraversal(root, tmpArr);
    }
    int[] inOrderTraversal(TreeNode<E> current, int[] tmpArr) {
        if (current == null) {
            return tmpArr;
        }
        inOrderTraversal(current.left, tmpArr);
        tmpArr[Integer.parseInt(current.data.toString())] = Integer.parseInt(current.data.toString());
        inOrderTraversal(current.right, tmpArr);
        return tmpArr;
    }
    int height() {
        return height(root) - 1;
    }
    int height(TreeNode<E> current) {
        if (current == null) {
            return 0;
        }
        int leftHeight = height(current.left);
        int rightHeight = height(current.right);
        if (leftHeight > rightHeight) {
            return leftHeight + 1;
        } else {
            return rightHeight + 1;
        }
    }
}
