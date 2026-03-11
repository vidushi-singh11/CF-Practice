import java.util.*;
public class treepractice {

    Scanner sc = new Scanner(System.in);

    // Constructors 
    static class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    // Build Tree

    Node buildfxn() {
        int val = sc.nextInt();
        if (val == -1) {
            return null;
        }
        Node root = new Node(val);
        root.left = buildfxn();
        root.right = buildfxn();
        return root;
    }

    // Traversals

    // inorder
    void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    // preorder
    void preorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // postorder
    void postorder(Node root) {
        if (root == null) {
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }
    public static void main(String[] args) {
     treepractice tree = new treepractice();
        System.out.println("Enter nodes:");
        Node root = tree.buildfxn();

        System.out.print("Preorder: ");
        tree.preorder(root);

        System.out.println();

        System.out.print("Inorder: ");
        tree.inorder(root);

        System.out.println();

        System.out.print("Postorder: ");
        tree.postorder(root);
    }

}