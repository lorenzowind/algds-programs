public class TribeTree {
    private TreeNode firstWarrior;

    public TribeTree(Integer lands) { 
        this.firstWarrior = new TreeNode(lands); 
    }

    public String getFirstWarriorName() {
        return this.firstWarrior.getWarriorName();
    }

    public void setFirstWarriorName(String warriorName) {
        this.firstWarrior.setWarriorName(warriorName);
    }

    static class TreeNode {
        private Node firstChild;
        private String warriorName;
        private Integer lands;

        TreeNode(Integer lands) {
            this.lands = lands;
            this.firstChild = null;
        }

        TreeNode(String warriorName, Integer lands) {
            this.warriorName = warriorName;
            this.lands = lands;
            this.firstChild = null;
        }

        private String getWarriorName() {
            return this.warriorName;
        }

        public void setWarriorName(String warriorName) {
            this.warriorName = warriorName;
        }

        public Node getFirstChild() {
            return this.firstChild;
        }
    }

    private static class Node {
        private TreeNode child;
        private Node next;

        Node(TreeNode node) {
            this.child = node;
            this.next = null;
        }

        public TreeNode getChild() {
            return this.child;
        }
    }

    private Node appendHelper(Node node, TreeNode treeNode) {
        if (node == null)
            return new Node(treeNode);
            
        node.next = appendHelper(node.next, treeNode);
        
        return node;
    }

    private TreeNode findHelper(TreeNode treeNode, String warriorName) {
        if (treeNode == null)
            return null;

        if (treeNode.warriorName == warriorName)
            return treeNode;
        
        Node child = treeNode.getFirstChild();

        while (child != null) {
            TreeNode aux = findHelper(child.getChild(), warriorName);
            
            if (aux != null)
                return aux;

            child = child.next;
        }

        return null;
    }

    public void insert(String fatherName, String childName, Integer childLands) {
        TreeNode treeNode = findHelper(firstWarrior, fatherName);

        if (treeNode == null)
            return;
        
        treeNode.firstChild = appendHelper(
            treeNode.firstChild, 
            new TreeNode(childName, childLands)
        );
    }
}