class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    public TreeNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

public class Day {
    TreeNode root;

    public Day() {
        root = null;
    }

    // Insert a value into the BST
    public void insert(int value) {
        root = insertRec(root, value);
    }

    private TreeNode insertRec(TreeNode node, int value) {
        if (node == null) {
            return new TreeNode(value);
        }
        if (value < node.value) {
            node.left = insertRec(node.left, value);
        } else if (value > node.value) {
            node.right = insertRec(node.right, value);
        }
        return node;
    }

    // Search for a value in the BST
    public boolean search(int value) {
        return searchRec(root, value);
    }

    private boolean searchRec(TreeNode node, int value) {
        if (node == null) {
            return false;
        }
        if (value == node.value) {
            return true;
        }
        if (value < node.value) {
            return searchRec(node.left, value);
        }
        return searchRec(node.right, value);
    }

    // In-order traversal (Left, Root, Right)
    public void inOrder() {
        inOrderRec(root);
        System.out.println();
    }

    private void inOrderRec(TreeNode node) {
        if (node != null) {
            inOrderRec(node.left);
            System.out.print(node.value + " ");
            inOrderRec(node.right);
        }
    }

    // Pre-order traversal (Root, Left, Right)
    public void preOrder() {
        preOrderRec(root);
        System.out.println();
    }

    private void preOrderRec(TreeNode node) {
        if (node != null) {
            System.out.print(node.value + " ");
            preOrderRec(node.left);
            preOrderRec(node.right);
        }
    }

    // Post-order traversal (Left, Right, Root)
    public void postOrder() {
        postOrderRec(root);
        System.out.println();
    }

    private void postOrderRec(TreeNode node) {
        if (node != null) {
            postOrderRec(node.left);
            postOrderRec(node.right);
            System.out.print(node.value + " ");
        }
    }

    // Find minimum value
    public int findMin() {
        return findMinRec(root);
    }

    private int findMinRec(TreeNode node) {
        if (node.left == null) {
            return node.value;
        }
        return findMinRec(node.left);
    }

    // Find maximum value
    public int findMax() {
        return findMaxRec(root);
    }

    private int findMaxRec(TreeNode node) {
        if (node.right == null) {
            return node.value;
        }
        return findMaxRec(node.right);
    }

    public static void main(String[] args) {
        Day tree = new Day();

        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        tree.insert(40);
        tree.insert(60);
        tree.insert(80);

        System.out.print("In-order traversal: ");
        tree.inOrder();

        System.out.print("Pre-order traversal: ");
        tree.preOrder();

        System.out.print("Post-order traversal: ");
        tree.postOrder();

        System.out.println("Search 40: " + tree.search(40));
        System.out.println("Search 100: " + tree.search(100));

        System.out.println("Minimum value: " + tree.findMin());
        System.out.println("Maximum value: " + tree.findMax());
    }
}
