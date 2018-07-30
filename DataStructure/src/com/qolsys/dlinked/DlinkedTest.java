package com.qolsys.dlinked;

public class DlinkedTest {

	public static void main(String[] args) {
		
		
	
DlinkedImpl dl= new DlinkedImpl();

/*
for (int i = 0; i < 7; i++) {
	dl.addFront(i);
}



dl.printList();
System.out.println();
System.out.println(dl.size());


for (int i = 7; i < 17; i++) {
	dl.addLast(i);
}
System.out.println();
dl.printList();
System.out.println();
System.out.println(dl.size());


for (int i = 0; i < 2; i++) {
	dl.removeFront();
}
dl.printList();
System.out.println();
System.out.println(dl.size());


for (int i = 0; i < 2; i++) {
	dl.removeLast();
}
dl.printList();
System.out.println();
System.out.println(dl.size());
*/
dl.addFront(22);
dl.addAt(999, 1);
//dl.addAt(999, 2);
dl.printList();
System.out.println();
System.out.println(dl.size());



dl.removeAt(2);

dl.printList();
System.out.println();
System.out.println(dl.size());

	}
	
}
