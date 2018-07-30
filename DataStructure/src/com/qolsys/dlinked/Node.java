package com.qolsys.dlinked;

public class Node {

	public Node  previous;
	
	
	private Integer data;
	
	public  Node next;

	public Node(Node previous, Integer data, Node next) {
		super();
		this.previous = previous;
		this.data = data;
		this.next = next;
	}

	public Node(Integer data) {
		super();
		this.data = data;
	}

	
	public int data() {
		
		return data;
	}



	
	
}//class


