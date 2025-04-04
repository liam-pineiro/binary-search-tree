package classAssignments;

import java.util.Scanner;

import binaryTree.BTNode;

public class BinarySearchTree {
	public static void main(String[] args) {
		BTNode<Integer> tree = buildTree();
		
		System.out.println("Enter an int to search for in the tree: ");
		Scanner userInput = new Scanner(System.in);
		int input = userInput.nextInt();
		
		String result = inOrderTraversal(tree);
		
		findTarget(result, input, tree);
	}
	
	public static BTNode<Integer> buildTree(){
		BTNode<Integer> root;
		BTNode<Integer> child;
		   
		root = new BTNode<Integer>(8, null, null);
		
		child = new BTNode<Integer>(3, null, null);
		child.setLeft(new BTNode<Integer>(1, null, null));
		child.setRight(new BTNode<Integer>(6, null, null));
		child.getRight().setLeft(new BTNode<Integer>(4, null, null));
		child.getRight().setRight(new BTNode<Integer>(7, null, null));
		root.setLeft(child);
		
		child = new BTNode<Integer>(10, null, null);
		child.setRight(new BTNode<Integer>(14, null, null));
		child.getRight().setLeft(new BTNode<Integer>(13, null, null));
		root.setRight(child);
		
		return root;
	}
	
	public static void findTarget(String result, int target, BTNode<Integer> tree) {
		String placeholder = "";
		int count = 0;
		for(int i = 0; i < result.length(); i++) {
			placeholder += result.charAt(i);
			if(!(placeholder.equals(" "))) {
				if(result.charAt(i+1) != ' ') {
					placeholder += result.charAt(i+1);
					i++;
				}
				if(Integer.parseInt(placeholder) == target) {
					System.out.println("Target Found!");
				}
				else {
					count++;
				}
			}
			placeholder = "";
		}
		if(count == 9) {
			System.out.println("Target not found");
			System.out.println("Next lowest: " + setLower(tree, target));
			System.out.println("Next highest: " + setHigher(tree, target));	
		}
	}
	
	public static String inOrderTraversal(BTNode<Integer>  root) {
	        return inOrderTraversalHelper(root).trim();
	}

	private static String inOrderTraversalHelper(BTNode<Integer>  root) {
		if (root == null) {
			return "";
		}

		String left = inOrderTraversalHelper(root.getLeft());
	    String current = root.getData() + " ";
	    String right = inOrderTraversalHelper(root.getRight());

	       
	    return left + current + right;
	}
	
	public static int setLower(BTNode<Integer> tree, int target) {
		int lower = 0;
		
		while(tree != null) {
			if(tree.getData() < target) {
				lower = tree.getData();
				tree = tree.getRight();
			}
			else {
				tree = tree.getLeft();
			}
		}
		return lower;
	}
	
	public static int setHigher(BTNode<Integer> tree, int target) {
		int higher = 0;
		
		while(tree != null) {
			if(tree.getData() > target) {
				higher = tree.getData();
				tree = tree.getLeft();
			}
			else {
				tree = tree.getRight();
			}
		}
		return higher;
	}
	
}
