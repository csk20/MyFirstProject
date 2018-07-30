package com.qolsys.dlinked;

public class DlinkedImpl {

	private Node head;
	private int size;

	public void addFront(Integer x) {

		if (head == null)
			head = new Node(null, x, null);
		else {
			Node newNode = new Node(null, x, head);
			head.previous = newNode;
			head = newNode;

		}
		size++;
	}// addFront

	
	
	public void removeFront() {

		if (head == null)
			return;

		head = head.next;
		head.previous = null;

		size--;
	}// removeFront

	
	
	public void addAt(int x,int  index) {
		

		if (head == null)			return;

		if(index<1 || index > size) return;
		
		Node current= head;
		int i=1;
		while(i <index) {
			current= current.next;
			i++;
		}
		
		if(current.previous==null) {
			Node newNode=new Node(null, x,current);
			current.previous=newNode;
			head=newNode;
		}else {
		
		Node newNode=new Node(current.previous, x,current);
	
		current.previous.next=newNode;
		current.previous=newNode;
		
		}
		size ++;
		
	}
	
	
public void removeAt(int  index) {
		

		if (head == null)			return;

		if(index<1 || index > size) return;
		
		Node current= head;
		int i=1;
		while(i <index) {
			current= current.next;
			i++;
		}
		
		
		
		 if (current.next==null) {
			 
			 if(current.previous==null) {
				 head=null;
				 current=head;
				 size--;
				 return;
				 
			 }
			current.previous.next=null;
		
			
		}
		 else	if(current.previous==null) {
			
			 if(current.next==null) {
				 head=null;
				 current=head;
				 return;
				 
			 }
			
			current= current.next;
			current.previous=null;
			head=current;
			
		}
//			else if (current.next==null) {
//				current.previous.next=null;
//				
//			}
		else {

	
		current.previous.next=current.next;
		current.next.previous= current.previous;
		
		}
		size --;
		
	}
	
	
	
	public void addLast(Integer x) {

		if (head == null)
			head = new Node(null, x, null);
		else {

			Node current = head;
			while (current.next != null) {
				current = current.next;
			}
			Node newNode = new Node(current, x, null);
			current.next = newNode;

		}
		size++;
	}// addLast

	
	
	
	
	public void removeLast() {

		if (head == null)
			return;
		
		if (head.next== null) {
			head=null;
			size--;
			return;
		}

			Node current = head;
			while (current.next.next != null) {
				current = current.next;
			}
			
			current.next = null;
		    size--;
	}//removeLast

	
	
	public void printList() {
		Node current = head;
		while (current != null) {
			System.out.print(current.data()+"\t");
			current = current.next;

		}

	}

	public int size() {

		return size;

	}

}// class
