package com.qolsys.bst;

public class BstTest {

	public static void main(String[] args) {
		

		BstImpl bl=new BstImpl();
		bl.insert(30);
		System.out.println(bl);
		
		bl.insert(80);
		
		System.out.println(bl);
		bl.insert(30);
		System.out.println(bl);
		bl.insert(40);
		System.out.println(bl);
		
		bl.insert(10);
		
		System.out.println(bl);
		bl.insert(50);
		System.out.println(bl);
	}

}
