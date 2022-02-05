
public class IdenticalTrees {
	static class Node {
		int data;
		Node left, right;
		public Node(int data) {
			this.data = data;
			this.left = this.right = null;
		}
	};
	
	public boolean identicalTreeCheck(Node tree1, Node tree2) {
		if(tree1 == null && tree2 == null) {
			return true;
		}
		return (tree1.data == tree2.data && identicalTreeCheck(tree1.left, tree2.left) && identicalTreeCheck(tree1.right, tree2.right));
	}

	
	public static void main(String args[]) {
		Node node1 = new Node(10);
		node1.left = new Node(3);
		node1.right = new Node(6);
		node1.left.left = new Node(7);
		
		Node node2 = new Node(10);
		node2.left = new Node(3);
		node2.right = new Node(6);
		node2.left.left = new Node(7);
		IdenticalTrees fc = new IdenticalTrees();
		System.out.println(fc.identicalTreeCheck(node1, node2)?"Both the tree are identical":"Both the tree are Not identical");
	}
}
