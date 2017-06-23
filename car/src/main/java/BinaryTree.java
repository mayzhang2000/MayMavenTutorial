import java.util.*;
import java.util.stream.Stream;

/**
 * Created by mayz985 on 3/11/16.
 */
public class BinaryTree {

    int value;
    BinaryTree left;
    BinaryTree right;
    BinaryTree() {}


    BinaryTree(int value, BinaryTree left, BinaryTree right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public static void main(String[] args) {


       BinaryTree tree31 = new BinaryTree(285, null, null);
       BinaryTree tree32 = new BinaryTree(678, null, null);
       BinaryTree tree21 = new BinaryTree(277, null, tree31);
       BinaryTree tree22 = new BinaryTree(504, null, tree32);



        BinaryTree tree1 = new BinaryTree(334, tree21, tree22);





        System.out.println(getMinimumDifference(tree1));

    }

    public static Integer minValue = Integer.MAX_VALUE;
    public static int getMinimumDifference(BinaryTree root) {
        //Take one node, then compare with the all nodes.
        calculate(root, root);
        if (root.left != null) getMinimumDifference(root.left);
        if (root.right != null) getMinimumDifference(root.right);

        return minValue;




    }


    public static void calculate(BinaryTree root1, BinaryTree root) {
        if (root1 == null || root == null) return;

        if (root1 != root) {
            int diff = Math.abs(root1.value - root.value);
            minValue = Math.min(minValue, diff);
        }
        if (root.left != null) calculate(root1, root.left);
        if (root.right!= null) calculate (root1, root.right);
    }


    public static int min = Integer.MAX_VALUE;
    public static int minDepth(BinaryTree root) {
        int depth = 0;
        if (root == null) return 0;
         minDepthHelper(root, 0);
         return min;

    }

    public static void minDepthHelper(BinaryTree root, int depth) {

        depth++;
        if (root.left == null && root.right == null) {
            if (min > depth) min = depth;
        }

        if (root.left != null) {
            minDepthHelper(root.left, depth);
        }
        if (root.right != null) {
            minDepthHelper(root.right, depth);
        }
    }

    int max = 0;


    public int helper(BinaryTree root) {


        if (root == null) {
            return 0;
        }else {

            int left =helper(root.left);
            int right = helper(root.right );
            max = Math.max(max, left + right);
            return Math.max(left, right) +1;

        }


    }


    public static boolean isSubtree(BinaryTree s, BinaryTree t) {
        if (s == null && t == null) return true;
        if (s == null && t != null) return false;
        if (s!= null && t == null) return false;

        //First find that node
        BinaryTree foundNode = foundNodeHelper(s, t);
        if (foundNode == null) return false;

        //Second make sure that node and all children are the same


        return matchNodeHelper(foundNode, t);
    }

    public static boolean matchNodeHelper(BinaryTree s, BinaryTree t) {
        if (s == null && t == null) return true;
        if (s == null && t != null) return false;
        if (s!= null && t == null) return false;

        if (s.value != t.value ) {
            return false;
        }
        if (matchNodeHelper(s.left, t.left) && matchNodeHelper(s.right, t.right)) {
            return true;
        }
        return false;
    }
    public static BinaryTree foundNodeHelper(BinaryTree s, BinaryTree t) {
        if (s == null && t == null) return null;
        if (s == null && t != null) return null;
        if (s!= null && t == null) return null;

        BinaryTree foundNode = null;
        if (s.value == t.value) {
            foundNode = s;
            return foundNode;
        }else {
            foundNode = foundNodeHelper(s.left, t);
            if (foundNode != null) return foundNode;
            foundNode = foundNodeHelper(s.right, t);
        }

        return foundNode;
    }

    int maxDepth(BinaryTree root) {
        int depth = 0;


        return maxDepthHelper(root, 0);
    }

    public int maxDepthHelper(BinaryTree root, int depth) {
        if (root == null )return depth;
        depth ++;
        if (root.left != null || root.right != null) {
           return Math.max(maxDepthHelper(root.left, depth), maxDepthHelper(root.right, depth));

        }else {
            return depth;
        }
    }
    public static void getNodes (BinaryTree root, List<BinaryTree> nodes) {
        if (root != null) {
            nodes.add(root);
            getNodes(root.left, nodes);
            getNodes(root.right, nodes);
        }
    }

    public static int findPath(BinaryTree node1, BinaryTree node2, int path) {
        if (node1 == node2) return path;
        path ++;
        if (node1.left == null && node2.right == null) return 0;
        if (node1.left != null) {
            path = findPath(node1.left, node2, path);
            if (path != 0) return path;
        }
        if (node2.right != null) {
            path = findPath(node1.right, node2, path);
            if (path != 0) return path;
        }


        return path;

    }

    public static boolean isBalanced1(BinaryTree root) {
        //find the hight of left sub tree and hight of right sub tree.
        if (root == null) return true;

        if (root.left == null && root.right == null) {
            return true;
        }

        //get root.left level

        if (getLevel(root) == -1) {
            return false;
        }
        return true;
    }
    public static int getLevel(BinaryTree root ) {
        if (root == null) return 0;

        int left = getLevel(root.left);
        if (left == -1) return -1;

        int right = getLevel(root.right);
        if (right == -1) return -1;

        int gap = left - right;
        if (gap <0) gap = (-1) * gap;
        if (gap >1) return -1;

        int level = Math.max(left, right) +1;


        return level;

    }





    public boolean hasPathSum(BinaryTree root, int sum) {
        if (root == null) {
            if (sum == 0) {
                return true;
            }else {
                return false;
            }
        }

        return pathSumHelper(root, sum, 0);


    }

    public boolean pathSumHelper(BinaryTree root, int sum, int total) {
        boolean status = false;
        if (root != null) {
            total = total + root.value;
            if (root.left == null && root.right == null) {
                if (total == sum) {
                    return true;
                }
            }
            if (root.left != null) {
                status = pathSumHelper(root.left, sum, total);
                if (status == true) return true;
            }

            if (root.right != null) {
                status = pathSumHelper(root.right, sum, total);
                if (status == true) return true;
            }

        }
        return false;
    }


    public static int findTilt(BinaryTree root) {

        return findTiltHelper(root, 0);

    }

    public static int findTiltHelper(BinaryTree root, int total) {
        total = tiltNode(root) + total;
        if (root.left != null) {
            total = findTiltHelper(root.left, total);

        }
        if (root.right != null) {
            total = findTiltHelper(root.right, total);
        }
        return total;
    }

    public static int tiltNode(BinaryTree root) {

        if (root == null) return 0;
        //sum of its left
        int left = getTotal(root.left, 0);
        int right = getTotal(root.right, 0);

        int gap = left - right;
        if (gap <0) gap = (-1) * gap;

        return gap;
    }

    public static int getTotal (BinaryTree current, int total) {
        if (current != null) {
            total = total + current.value;
            total = getTotal(current.left, total);
            total = getTotal(current.right, total);

        }
        return total;
    }
    public static BinaryTree sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        //find middle, then find left and right.

        int low = 0;
        int high = nums.length -1;
        int mid = (high -low) /2;

        BinaryTree root = helper(nums, low, high);

        return root;

    }

    public static BinaryTree  helper(int[] nums,int low, int high ) {
        if (high <low ) return null;

        int mid = low + (high -low) /2;
        BinaryTree root = new BinaryTree();
        root.value = nums[mid];
        root.left = helper(nums, low, mid-1);
        root.right = helper(nums, mid+1, high);
        return root;


    }

    public static int  getOccurance(BinaryTree root, Map<Integer, Integer> occuranceMap, int max) {
        if (root == null) {
            return max;
        }
        int newOccurance = occuranceMap.getOrDefault(root.value, 0) +1;
        int newMax = Math.max(max, newOccurance);
        occuranceMap.put(root.value, newOccurance);
        newMax = getOccurance(root.left, occuranceMap, newMax);
        newMax = getOccurance(root.right, occuranceMap, newMax);

        return newMax;


    }

    public static int[] findMode(BinaryTree root) {
        Map<Integer, Integer> occuranceMap = new HashMap<>();
        int max = 0;
        //go through the tree and putthe value and its occurances into a map, also collect max.
       int newMax =  getOccurance(root, occuranceMap, max);

        //Get keys from the map whose occurance is max,
        List<Integer> modeList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry: occuranceMap.entrySet()) {
            if (entry.getValue() == newMax) {
                modeList.add(entry.getKey());
            }

        }
        //return as array
        int[] mode = new int[modeList.size()];
        for (int i = 0; i< modeList.size(); i++) {
            mode[i] = modeList.get(i);
        }
        return mode;

    }

    public static boolean isBalanced(BinaryTree tree) {
        boolean balanced = true;
        if (tree.left != null) {
            if(tree.right == null) {
                balanced = false;
                return balanced;
            }else {
                if (tree.left.value != tree.right.value) {
                    balanced = false;
                    return balanced;
                }
            }

            if (!isBalanced(tree.left)) {
                balanced = false;
                return balanced;
            }

        }

        if (tree.right != null) {
            if(tree.left == null) {
                balanced = false;
                return balanced;
            }else {
                if (tree.left.value != tree.right.value) {
                    balanced = false;
                    return balanced;
                }
            }

            if (!isBalanced(tree.right)) {
                balanced = false;
                return balanced;
            }

        }



        return balanced;

    }

    public List<List<Integer>> levelOrderBottom(BinaryTree root) {
        //go through the tree, and add its value, and level to a map

        Map<Integer, List<Integer>> levelMap = new HashMap<>();
        int level = 0;
        traverseTree(root, levelMap, level);

        //now let's get the results

        //get max level;
        int max = 0;
        for(Integer i: levelMap.keySet()) {
            if (i> max) max = i;
        }

        List<List<Integer>> results = new ArrayList<>();
        for (Integer treeLevel = max; treeLevel >=0; treeLevel --) {
            if (levelMap.get(treeLevel) != null) {
                results.add(levelMap.get(treeLevel));
            }
        }

        return results;





    }

    private void traverseTree(BinaryTree root, Map<Integer, List<Integer>> levelMap, int level) {

        if (root != null) {
            if (levelMap.get(level) == null) {
                //First one
                List<Integer> notesList = new ArrayList<>();
                notesList.add(root.value);
                levelMap.put(level, notesList);
            }else {
                List<Integer> notesList = levelMap.get(level);
                notesList.add(root.value);
                levelMap.put(level, notesList);
            }
            int nextLevel = level +1;
            traverseTree(root.left, levelMap, nextLevel );
            traverseTree(root.right, levelMap, nextLevel );

        }
    }

    public static boolean isSymmetric(BinaryTree root) {
        boolean bSymmetric = true;
        if (root == null) return true;
        return helper(root.left, root.right);


    }

    public static boolean helper(BinaryTree note1, BinaryTree note2) {
        if (note1 == null ) {
            if (note2 != null){
                return false;
            }else {
                return true;
            }
        }

        if (note2 == null) {
            if (note1 != null) return false;
        }

        if (note1.value != note2.value) {
            return false;
        }

        return (helper(note1.left, note2.right) && helper(note1.right, note2.left));

    }

    public List<String> binaryTreePaths(BinaryTree root) {

        if (root == null) return null;
        List<String> results = new ArrayList<>();

        secondLayer(root, results, "");

        return results;


    }

    private void secondLayer(BinaryTree root, List<String> results, String path) {
        if (root!= null) {
            String subString = path.equals("") ? String.valueOf(root.value): path + ", " + root.value;
            if (root.left == null && root.right == null) {
                results.add(subString);
            }else {
                secondLayer(root.left, results, subString);
                secondLayer(root.right, results, subString);
            }
        }
    }


}
