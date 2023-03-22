//{ Driver Code Starts
//Initial Template for Java


import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Node {
	int data;
	Node left;
	Node right;

	Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}

class GfG {

	static Node buildTree(String str) {

		if (str.length() == 0 || str.charAt(0) == 'N') {
			return null;
		}

		String ip[] = str.split(" ");
		// Create the root of the tree
		Node root = new Node(Integer.parseInt(ip[0]));
		// Push the root to the queue

		Queue<Node> queue = new LinkedList<>();

		queue.add(root);
		// Starting from the second element

		int i = 1;
		while (queue.size() > 0 && i < ip.length) {

			// Get and remove the front of the queue
			Node currNode = queue.peek();
			queue.remove();

			// Get the current node's value from the string
			String currVal = ip[i];

			// If the left child is not null
			if (!currVal.equals("N")) {

				// Create the left child for the current node
				currNode.left = new Node(Integer.parseInt(currVal));
				// Push it to the queue
				queue.add(currNode.left);
			}

			// For the right child
			i++;
			if (i >= ip.length)
				break;

			currVal = ip[i];

			// If the right child is not null
			if (!currVal.equals("N")) {

				// Create the right child for the current node
				currNode.right = new Node(Integer.parseInt(currVal));

				// Push it to the queue
				queue.add(currNode.right);
			}
			i++;
		}

		return root;
	}

	static void printInorder(Node root) {
		if (root == null)
			return;

		printInorder(root.left);
		System.out.print(root.data + " ");

		printInorder(root.right);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		while (t > 0) {
			String s = br.readLine();
			int target = Integer.parseInt(br.readLine());
			Node root = buildTree(s);

			Solution g = new Solution();
			System.out.println(g.minTime(root, target));
			t--;

		}
	}
}



// } Driver Code Ends


//User function Template for Java

class Solution
{
    /*class Node {
    	int data;
    	Node left;
    	Node right;
    
    	Node(int data) {
    		this.data = data;
    		left = null;
    		right = null;
    	}
    }*/
    
    static HashMap<Node, Node> childToParent;
    static HashSet<Node> visited;
    
    public static int minTime(Node root, int target) 
    {
        // Your code goes here
        childToParent = new HashMap<>();
        visited = new HashSet<>();
        Node targetNode = findNode(root, target);
        mapParent(root);
        return burn(targetNode, 0);
    }
    
    private static int burn(Node node, int time) {
        if (node == null) return time-1;
        if (visited.contains(node)) return time-1;
        visited.add(node);
        int left = burn(node.left, time+1);
        int right = burn(node.right, time+1);
        int parent = burn(childToParent.get(node), time+1);
        return Math.max(parent, Math.max(left, right));
    }
    
    private static void mapParent(Node node) {
        if (node == null) return;
        if (node.left != null) childToParent.put(node.left, node);
        if (node.right != null) childToParent.put(node.right, node);
        mapParent(node.left);
        mapParent(node.right);
    }
    
    private static Node findNode(Node root, int target) {
        if (root == null) return null;
        if (root.data == target) return root;
        
        Node left = findNode(root.left, target);
        Node right = findNode(root.right, target);
        
        if (left != null) return left;
        else return right;
    }
}