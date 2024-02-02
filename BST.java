class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class BST {

    public static Node insert(Node root, int val) { // time complexity O(h) where h is the height
        if (root == null) {
            root = new Node(val);
            return root; // for condition the root is return to main func in other cases it is back
                         // tracked
        }
        if (root.data > val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }
        return root; // root will be returned after back tracking
    }

    public static void Inorder(Node root) {
        if (root == null) {
            return;
        }

        Inorder(root.left);
        System.out.print(root.data + " ");
        Inorder(root.right);

    }

    public static boolean search(Node root, int key) { // O(h)
        if(root == null){
            return false;
        }
        
        if (root.data == key) {
            return true;
        }

        if (root.data > key) {
            return search(root.left, key);
        } else if(root.data < key){
            return search(root.right, key);
        }
        return false;
   
    }

    public static Node delete(Node root, int val){
        if(root.data > val){
            root.left = delete(root.left, val);
        }
        else if(root.data < val){
            root.right = delete(root.right,val);
        }
        else{
            // when root.data == val

            if(root.left == null && root.right == null){ // 1 case for leaf node
                return null;
            }


            else if(root.right == null){ // second case node having 1 child
                return root.left;
            }
            else if(root.left == null){
                return root.right;
            }

            Node IS = InorderSuccessor(root.right); // Node having 2 childs
            root.data = IS.data;
            root.right = delete(root.right,IS.data);

        }

        return root;

    }

    public static Node InorderSuccessor(Node root) {
        while(root.left != null){
            root = root.left;
        }return root;
    }



    public static void main(String[] args) {
        int arr[] = {8,5,3,1,4,6,10,11,14};
        Node root = null;

        for (int i = 0; i < arr.length; i++) {
            root = insert(root, arr[i]);
        }

        Inorder(root); // gives a sorted order
        System.out.println();

      
        if (search(root,10 )) {
            System.out.println("this value is present in this tree");
        }
        else{
            System.out.println("This value is not present in this tree");
        }

        delete(root,10);
        System.out.println("after deleting a element");
        Inorder(root);

    
    
    
    }
}
