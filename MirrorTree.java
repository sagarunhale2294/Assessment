
public class MirrorTree {
	static class Node {
		int data;
		Node left, right;
		public Node(int data) {
			this.data = data;
			this.left = this.right = null;
		}
	};
	
	static int sum = 0, multiplier = 1;
	static StringBuffer leaves = new StringBuffer("");
	
	public Node mirror(Node node) {
		if(node == null) {
			return node;
		}
		Node left = mirror(node.left);
		Node right = mirror(node.right);
		
		node.left = right;
		node.right = left;
		return node;
	}
	
	public void inorder(Node node) {
		if(node == null)
			return;
		inorder(node.left);
		System.out.print(" " + node.data);
		inorder(node.right);
	}
	
	public void calculateSum(Node root) {
		if(root == null)
			return;
		if(root.left!=null){
			leaves.append(root.left.data + "+");
			sum = sum + root.left.data;
		}
		if(root.right!=null){
			leaves.append(root.right.data + "+");
			sum = sum + root.right.data;
		}
		calculateSum(root.left);
		calculateSum(root.right);
	}
	
	public void calculateSumOfLeaves(Node root) {
		sum = 0;
		calculateSum(root);
		System.out.println("The sum is " + leaves.toString().substring(0, leaves.toString().lastIndexOf("+"))+"=" + sum);
	}
	
	public void multiplicationOfOnlyChild(Node root) {
		multiplier = 1;
		leaves = new StringBuffer("");
		calculateMultiplication(root);
		System.out.println("The Multiplication of only child's is " + leaves.toString().substring(0, leaves.toString().lastIndexOf("*")) + "=" + multiplier);
	}

	private void calculateMultiplication(Node root) {
		if(root == null) {
			return;
		}
		if(root.left == null && root.right == null) {
			multiplier = multiplier * root.data;
			leaves.append(root.data + "*");
		}
		calculateMultiplication(root.left);
		calculateMultiplication(root.right);
	}

	public static void main(String[] args) {
		Node tree1 = new Node(9);
		tree1.left = new Node(6);
		tree1.right = new Node(3);
		tree1.right.left = new Node(2);
		tree1.right.right = new Node(7);
		tree1.right.left.left = new Node(3);
		tree1.right.left.right = new Node(5);
		
		MirrorTree mirrorTree = new MirrorTree();
		//mirrorTree.inorder(tree1);
		Node mirror = mirrorTree.mirror(tree1);
		// mirrorTree.inorder(mirror);
		System.out.println("Expected Sum and Multiplication");
		mirrorTree.calculateSumOfLeaves(mirror);
		mirrorTree.multiplicationOfOnlyChild(mirror);

	}

}
