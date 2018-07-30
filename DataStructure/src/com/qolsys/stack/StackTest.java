package com.qolsys.stack;

public class StackTest {

	public static void main(String[] args) throws Exception {
		

		MyGenericStack<Integer> st= new MyGenericStack<>(10);
		
		for (int i = 0; i < 2; i++) {
			
			st.push(i);
			System.out.print(st.peek()+" ");
		}

		int x= st.size();
		System.out.println(st.size()+"  oooooooo");
		
		
		for (int i = 0; i < x; i++) {
			
			System.out.println(st.pop());
		}
		

	
	MyGenericStack<Person> st1= new MyGenericStack<>(10);
	
	Person p1= new Person(2,"name1");
	Person p2= new Person(4,"name4");
	st1.push(p1);st1.push(p2);
	System.out.print(st1.peek()+" ");
	System.out.println(st1.pop());
	System.out.print(st1.peek()+" ");
	System.out.println(st1.pop());
	System.out.print(st1.peek()+" ");
	System.out.println(st1.pop());

	
	}
	
}

