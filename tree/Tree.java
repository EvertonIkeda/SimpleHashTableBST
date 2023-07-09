package tree;

public class Tree {

    private Node root;

    public void insert(int key, Object value) {
        this.root = this.insert(this.root, key, value);
    }

    private Node insert(Node root, int key, Object value) {
        if (root == null) {
            Node node = new Node();
            node.setKey(key);
            node.setValue(value);
            return node;
        } else {
            if (key < root.getKey()) {
                root.setLeft(this.insert(root.getLeft(), key, value));
            } else if (key > root.getKey()) {
                root.setRight(this.insert(root.getRight(), key, value));
            }
            return root;
        }
    }
    
    public void remove(int key) {
        this.root = remove(this.root, key);
    }

    private Node remove(Node root, int key) {
        if (root == null) {
            return null;
        }

        if (key < root.getKey()) {
            root.setLeft(remove(root.getLeft(), key));
        } else if (key > root.getKey()) {
            root.setRight(remove(root.getRight(), key));
        } else {
            if (root.getLeft() == null) {
                return root.getRight();
            } else if (root.getRight() == null) {
                return root.getLeft();
            }

            Node next = root;
            Node nextChild = root.getRight();
            while (nextChild.getLeft() != null) {
                next = nextChild;
                nextChild = nextChild.getLeft();
            }

            if (next != root) {
                next.setLeft(nextChild.getRight());
                nextChild.setRight(root.getRight());
            }

            nextChild.setLeft(root.getLeft());
            return nextChild;
        }
        return root;
    }

    public Object get (int key) {
        return this.get(this.root, key);
    }

    private Object get(Node root, int key) {
        if (root != null) {
            if (key < root.getKey()) {
                return this.get(root.getLeft(), key);
            } else if (key > root.getKey()) {
                return this.get(root.getRight(), key);
            } else {
                return root.getValue();
            }
        } else {
            return null;
        }
    }

    private String print(Node root, int lvl) {
        String out = "";
        for (int i = 0; i < lvl; i++) {
            out += "\t";
        }
        out += root.getKey() + ": " + (root.getValue() != null ? root.getValue() : "null");
        out += "\n";
        out += (root.getLeft() != null ? print(root.getLeft(), lvl + 1) : "");
        out += (root.getRight() != null ? print(root.getRight(), lvl + 1) : "");
        return out;
    }

    @Override
    public String toString() {
        return this.print(this.root, 0);
    }

    public void preOrder() {
        preOrder(this.root);
    }

    public void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.getValue() + " ");
            preOrder(node.getLeft());
            preOrder(node.getRight());
        }
    }
    
    public void inOrder() {
    	inOrder(this.root);
    }
    
    public void inOrder(Node node) {
    	if (node != null) {
    		inOrder(node.getLeft());
    		System.out.print(node.getValue() + " ");
    		inOrder(node.getRight());    		
    	}
    }
    
    public void postOrder() {
    	postOrder(this.root);
    }
    
    public void postOrder(Node node) {
    	if (node != null) {
    		postOrder(node.getLeft());
    		postOrder(node.getRight());    		
    		System.out.print(node.getValue() + " ");
    	}
    }

    public boolean isEmpty() {
    	return false;
    }
    
    public static void main(String[] args) {
        Tree t = new Tree();
        t.insert(20, 20);
        t.insert(5, 5);
        t.insert(40, 40);
        t.insert(0, 0);
        t.insert(10, 10);
        t.insert(30, 30);
        t.insert(50, 50);
        
        System.out.print("\n Preorder: ");
        t.preOrder();
        System.out.print("\n Inorder: ");
        t.inOrder();
        System.out.print("\n Post order: ");
        t.postOrder();
        
        t.remove(0);
        System.out.print("\n Preorder: ");
        t.preOrder();
        t.remove(50);
        System.out.print("\n Preorder: ");
        t.preOrder();
        t.remove(5);
        System.out.print("\n Preorder: ");
        t.preOrder();
        t.remove(20);
        System.out.print("\n Preorder: ");
        t.preOrder();
    }

}