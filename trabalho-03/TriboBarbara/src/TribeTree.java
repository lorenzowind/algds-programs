public class TribeTree {
    private TreeNode firstWarrior;
    private TreeNode warriorWithMoreLands;

    public TribeTree(String warriorName, int lands) {
        this.firstWarrior = new TreeNode(warriorName, lands);
    }

    static class TreeNode {
        private Node firstChild;
        private String warriorName;
        private int lands;

        TreeNode() {
            this.lands = 0;
        }

        TreeNode(String warriorName, int lands) {
            this.warriorName = warriorName;
            this.lands = lands;
        }

        public void setWarriorName(String warriorName) {
            this.warriorName = warriorName;
        }

        public Node getFirstChild() {
            return this.firstChild;
        }

        public String getWarriorName() {
            return this.warriorName;
        }

        public int getLands() {
            return this.lands;
        }
    }

    private static class Node {
        private TreeNode child;
        private Node next;

        Node(TreeNode node) {
            this.child = node;
            this.next = null;
        }
    }
    
    public TreeNode getFirstWarrior() {
        return this.firstWarrior;
    }

    public TreeNode getWarriorWithMoreLands() {
        if (this.firstWarrior == null)
            return null;
            
        this.warriorWithMoreLands = new TreeNode();

        calculateLandsHelper(this.firstWarrior, 0);

        return this.warriorWithMoreLands;
    }

    private void calculateLandsHelper(TreeNode treeNode, int fatherChildren) {
        Node currentChild = treeNode.getFirstChild();
        int numberOfChildren = 0;
        
        while (currentChild != null) {
            int totalLands = fatherChildren != 0 
                ? (treeNode.lands / fatherChildren) + currentChild.child.lands
                : currentChild.child.lands;

            if (totalLands > this.warriorWithMoreLands.lands) {
                warriorWithMoreLands = currentChild.child;
            }

            numberOfChildren++;
            currentChild = currentChild.next;
        }

        currentChild = treeNode.getFirstChild();

        while (currentChild != null) {
            calculateLandsHelper(currentChild.child, numberOfChildren);

            currentChild = currentChild.next;
        }
    }

    private Node appendHelper(Node node, TreeNode treeNode) {
        if (node == null)
            return new Node(treeNode);

        node.next = appendHelper(node.next, treeNode);

        return node;
    }

    public TreeNode findHelper(TreeNode treeNode, String warriorName) {
        if (treeNode == null)
            return null;

        if (
            treeNode.warriorName != null && 
            treeNode.warriorName.equals(warriorName)
        ) {
            return treeNode;
        }

        Node currentChild = treeNode.getFirstChild();

        while (currentChild != null) {
            TreeNode aux = findHelper(currentChild.child, warriorName);

            if (aux != null)
                return aux;

            currentChild = currentChild.next;
        }

        return null;
    }

    public void insert(
        String fatherName, 
        String childName, 
        int childLands
    ) {
        TreeNode treeNode = findHelper(this.firstWarrior, fatherName);
        
        if (treeNode != null) 
            treeNode.firstChild = appendHelper(
                treeNode.firstChild, 
                new TreeNode(childName, childLands)
            );
    }
}