package com.csk.bst;

public class Node {
	
	public Node leftChild;
	 private int data;
	 
	 public Node rightChild;
	 
	 
	public Node(Node leftChild, int data, Node rightChild) {
		super();
		this.leftChild = leftChild;
		this.data = data;
		this.rightChild = rightChild;
	}
	
	
	public Node(int data) {
		super();
		leftChild=rightChild=null;
		this.data = data;
	}


	public Node() {
		super();
		leftChild=rightChild=null;
		data = 0;
	}


	public void setData(int data) {
		this.data = data;
	}


	public int getData() {
		return data;
	}

	
	
}
