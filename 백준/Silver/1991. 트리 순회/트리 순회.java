
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{

	public static class Node {

		char root;
		Node left, right;

		public Node(char root, Node left, Node right) {
			this.root = root;
			this.left = left;
			this.right = right;
		}

		@Override
		public String toString() {
			return "Node [root=" + root + ", left=" + left + ", right=" + right + "]";
		}

	}

	static char[][] input;
	static StringBuilder sb1;
	static StringBuilder sb2;
	static StringBuilder sb3;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		input = new char[N][2];

		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			String root = st.nextToken();
			String left = st.nextToken();
			String right = st.nextToken();
			input[root.charAt(0) - 'A'][0] = left.charAt(0);
			input[root.charAt(0) - 'A'][1] = right.charAt(0);
		}
		Node nodeA = setNode('A');
		preOrder(nodeA);
		System.out.println();
		inOrder(nodeA);
		System.out.println();
		postOrder(nodeA);
		System.out.println();

	}

	private static Node setNode(char root) {
		// TODO Auto-generated method stub
		int num = root - 'A';
		char left = input[num][0];
		char right = input[num][1];
		if (left == '.' && right == '.') {
			return new Node(root, null, null);
		} else if (left == '.') {
			return new Node(root, null, setNode(right));
		} else if (right == '.') {
			return new Node(root, setNode(left), null);
		} else {
			return new Node(root, setNode(left), setNode(right));
		}
	}
	public static void preOrder(Node node) {
		if(node ==null) return;
		System.out.print(node.root);
		preOrder(node.left);
		preOrder(node.right);
	}
	
	public static void inOrder(Node node) {
		if(node ==null) return;
		inOrder(node.left);
		System.out.print(node.root);
		inOrder(node.right);
	}
	
	public static void postOrder(Node node) {
		if(node ==null) return;
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.root);
	}

}
