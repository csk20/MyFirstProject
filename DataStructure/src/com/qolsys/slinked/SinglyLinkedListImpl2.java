package com.qolsys.slinked;



public class SinglyLinkedListImpl2<T> {

	
	public Node<T> head;
	
	
	
public SinglyLinkedListImpl2() {
				head = null;
	}

	public void add(T element) {
		if(head==null)
			head= new Node(element,null);
		else {
	//	Node< T>  temp =head;
		
		
		Node<T> newNode= new Node(element,head);
		    
		head=newNode;
		}
		
		
	}
	
	
	
	public void print() {
		Node< T>  temp =head;
		while(temp!=null) {
			System.out.println(temp.getValue());
			temp=temp.nextRef;
			
		}
	}
	
	


	public void  traverse() {
	 Node<T> temp=head;
		
		while(true) {
			if(temp==null) break;
			temp=temp.getNextRef();
		}//while
	}//traverse
	
	
	public void  reverse() {
		 Node<T> previous=null;
		 Node<T> current=head;
		 Node<T> next=null;
		 
		 while(current!=null) {
			 next=current.nextRef;
			 current.nextRef=previous;
			 previous=current;
			 current=next;
			 
		 }//while
		
		head= previous;
	}//reverse


	

		
	

	@Override
	public String toString() {
		return "SinglyLinkedListImpl2 [head=" + head + "]";
	}
	
	
	
}
