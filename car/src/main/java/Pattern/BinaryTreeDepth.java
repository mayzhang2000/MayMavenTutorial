package Pattern;

import java.util.*;

/**
 * Created by mayz985 on 2/21/17.
 */
public class BinaryTreeDepth {
    int value;
    BinaryTreeDepth left;
    BinaryTreeDepth right;

    BinaryTreeDepth() {

    }
    BinaryTreeDepth(int value, BinaryTreeDepth left, BinaryTreeDepth right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public static int sumOfLeftLeaves(BinaryTreeDepth root) {
        int total = 0;
        //while has children, get all left;
        List<BinaryTreeDepth> leftList = new ArrayList<>();

        collect(root, leftList);

        for(BinaryTreeDepth node: leftList) {
            total = total + node.value;
        }

        return total;
    }

    public static void collect(BinaryTreeDepth root, List<BinaryTreeDepth> leftList) {
        if(root != null) {
            if (root.left!= null) {
                //Need only leaf
                if (root.left.right == null && root.left.right == null)
                    leftList.add(root.left);
                //do this for its children.
                collect(root.left, leftList);
                collect(root.right, leftList);
            }
        }
    }
    public BinaryTreeDepth invertTree(BinaryTreeDepth root) {
        if ((root.left == null) && (root.right == null) ) {
            return root;
        }

        BinaryTreeDepth left = root.left;
        root.left = root.right;
        root.right = left;

        if (root.left != null) invertTree(root.left);
        if (root.right != null) invertTree(root.right);
        return root;

    }

    public boolean isSameTree(BinaryTreeDepth p, BinaryTreeDepth q) {
        //compare if the current node is the same, if not return
        //if same, compare the left and right
        if(p == null && q ==null) return true;
        if ((p == null && q!= null ) ||p!= null && q ==null) return false;
        if (p.value != q.value) return false;
        boolean isSame = (isSameTree(p.left, q.left) && isSameTree(q.right, p.right));
        return isSame;


    }

    public BinaryTreeDepth sortedArrayToBST(int[] nums) {

        if (nums.length <1) { return null;}

        int low = 0;
        int high = nums.length -1;
        int mid = (high + low)/2;

        BinaryTreeDepth treeNode = new BinaryTreeDepth();
        treeNode.value = nums[mid];
        treeNode.left = addLeaf(nums, 0, mid);
        treeNode.right = addLeaf(nums, mid, high);


        return treeNode;

    }

    public BinaryTreeDepth addLeaf(int[] nums, int low, int high) {

        if (high <= low) return null;

        int mid = (high + low)/2;

        BinaryTreeDepth treeNode = new BinaryTreeDepth();
        treeNode.value = mid;
        treeNode.left = addLeaf(nums, 0, mid);
        treeNode.right = addLeaf(nums, mid, high);
        return treeNode;
    }

    int total = 0;

    public int pathSum(BinaryTreeDepth root, int sum) {
        //as we traverse the tree, we need to keep a list of values that got it there
        //do math on the sums of itself; and the last fews continues; it match then ++;

        List<Integer> notesVisited = new ArrayList<>();
        traverseTheTree(root, notesVisited,  sum);

        return total;


    }

    private void traverseTheTree(BinaryTreeDepth root, List<Integer> notesVisited, int sum) {

        if (root != null) {
            notesVisited.add(root.value);
            countPath(notesVisited, sum);
            traverseTheTree(root.left, notesVisited, sum);
            traverseTheTree(root.right, notesVisited, sum);


        }
    }

    public void countPath(List<Integer> notesVisited, int sum) {
        //Count the number of times total consecutive backwards equals to sum

        int subSum = 0;
        for (int i = notesVisited.size() -1; i>=0; i--) {
            if (notesVisited.get(i) == sum) {
                total ++;
                break;
            }else {
                subSum = subSum + notesVisited.get(i);
                if (subSum == sum) {
                    total ++;
                    break;
                }
            }
        }

    }


    public BinaryTreeDepth lowestCommonAncestor(BinaryTreeDepth root, BinaryTreeDepth p, BinaryTreeDepth q) {
       if (root.value> p.value && root.value > q.value) {
           return lowestCommonAncestor(root.left, p, q);
       }else if (root.value <p.value && root.value < q.value) {
           return lowestCommonAncestor(root.right, p, q);
       }else {
           return root;
       }

    }

    public static void main(String[] args) {
        BinaryTreeDepth node9 = new BinaryTreeDepth(1, null, null);
        BinaryTreeDepth node8 = new BinaryTreeDepth(-2, null, null);
        BinaryTreeDepth node5 = new BinaryTreeDepth(5, null, null);
        BinaryTreeDepth node3 = new BinaryTreeDepth(3, null, node5);



    }

}
