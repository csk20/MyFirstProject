package com.qolsys.slinked;




public class SingleLTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SinglyLinkedListImpl2<Number>  sl= new SinglyLinkedListImpl2<>();
		for (int i = 0; i < 4; i++) {
			sl.add(i+4);
			sl.add(i);
		}
		
		
		sl.print();

		sl.traverse();
		System.out.println(sl.toString() );
		sl.reverse();
		System.out.println(sl.toString() );
/*		
		sl.reverse();
		sl.traverse();
		System.out.println(sl.toString());*/
	}

}
