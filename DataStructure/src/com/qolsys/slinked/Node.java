package com.qolsys.slinked;

public class Node<T> implements Comparable<T> {

	
	private T value;
	public Node<T> nextRef;
	
	
	public Node(T value, Node<T> nextRef) {
		super();
		this.value = value;
		this.nextRef = nextRef;
	}


	public T getValue() {
		return value;
	}

	
	public Node() {
	
		nextRef = null;
	}

	public Node(T value) {
		super();
		this.value = value;
		this.nextRef = null;
	}


	public void setValue(T value) {
		this.value = value;
	}


	public Node<T> getNextRef() {
		return nextRef;
	}


	public void setNextRef(Node<T> nextRef) {
		this.nextRef = nextRef;
	}


	@Override
	public int compareTo(T o) {
	
if(o==this.value)
		return 0;


else {
	 return 1;
}
	}


	@Override
	public String toString() {
		return "Node [value=" + value + ", nextRef=" + nextRef + "]";
	}

}
