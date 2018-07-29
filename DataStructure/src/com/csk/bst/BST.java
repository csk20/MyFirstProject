package com.csk.bst;

public class BST {

	public Node root;

	public BST() {
		root = null;
	}

	public int visit() {
		
		return root.getData();
	}
	
	public void add(int value) {
		root = add(root, value);
	}

	public Node add(Node root,int data) {
		
		if(root==null)		
			root= new Node(data);
		
		else if(root.getData()>=data)
			root.leftChild= add(root.leftChild,data);
		else if (root.getData()<data) 
			root.rightChild=add(root.rightChild,data);
				
		return root;
	}
}
