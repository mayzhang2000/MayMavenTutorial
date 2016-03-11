/**
 * Created by mayz985 on 3/11/16.
 */
public class BinaryTree {

    int value;
    BinaryTree left;
    BinaryTree right;

    BinaryTree(int value, BinaryTree left, BinaryTree right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public static void main(String[] args) {
        BinaryTree tree11 = new BinaryTree(1, null, null);
        BinaryTree tree12 = new BinaryTree(1, null, null);

        BinaryTree tree21 = new BinaryTree(2, tree11, tree12);

        BinaryTree tree13 = new BinaryTree(1, null, null);
        BinaryTree tree14 = new BinaryTree(1, null, null);

        BinaryTree tree22 = new BinaryTree(2, tree13, tree14);

        BinaryTree tree31 = new BinaryTree(4, tree21, null);


        System.out.println(isBalanced(tree31));
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
}
