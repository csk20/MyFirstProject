package com.csk.bst;

public class BSToperation {
	
	public static void preOrder(Node root) {
		
		if(root==null)  return;
		System.out.print(root.getData()+" ");
		
		preOrder(root.leftChild);
		preOrder(root.rightChild);
	}

	
	public static void inOrder(Node root) {
		
		if(root==null)  return;
		
		inOrder(root.leftChild);
		System.out.print(root.getData()+" ");
		
		
		inOrder(root.rightChild);
	}


	
public static void postOrder(Node root) {
		
		if(root==null)  return;
		
		postOrder(root.leftChild);
		postOrder(root.rightChild);
		System.out.print(root.getData()+" ");
	}


}
