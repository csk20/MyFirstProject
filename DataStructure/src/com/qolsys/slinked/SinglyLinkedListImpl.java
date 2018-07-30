package com.qolsys.slinked;



public class SinglyLinkedListImpl<T> {

	
	private Node<T> head;
	
	public void add(T element) {
		
		Node<T> nd= new Node<>();
		nd.setValue(element);
		System.out.println("adding element to list = "+element);
		Node<T> temp= head;
		while(true) {
			if(temp==null) {
				head=nd;
				break;
			}else if (temp.getNextRef()==null) {
				temp.setNextRef(nd);
				break;
			}else {
				temp=temp.getNextRef();
			}	
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
			 next=current.getNextRef();
			 current.setNextRef(previous);
			 previous=current;
			 current=next;
			 
		 }//while
		
		head= previous;
	}//reverse



	@Override
	public String toString() {
		return "SinglyLinkedListImpl [head=" + head + "]";
	}
	
	
	
}
