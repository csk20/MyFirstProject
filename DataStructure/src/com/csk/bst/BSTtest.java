package com.csk.bst;

public class BSTtest {

	public static void main(String[] args) {
		
		BST b= new BST();
		b.add(7);
		b.add(1);
		b.add(0);
		b.add(3);
		b.add(2);
		
		b.add(5);
		b.add(4);
		b.add(6);
		b.add(9);
		b.add(8);

		b.add(10);
		
		System.out.print("pre order =");
		
		BSToperation.preOrder(b.root);
		System.out.println();
		System.out.print("in order =");
		BSToperation.inOrder(b.root);
		System.out.println();
		System.out.print("post order =");
		BSToperation.postOrder(b.root);
	}

}
