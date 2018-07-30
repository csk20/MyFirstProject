package com.qolsys.stack;

public class MyGenericStack<T extends Object> {

	private int sSize;
	private T[] sArray;
	private int top;
	
	
	
	public MyGenericStack() {
	
		sSize = 20;
		sArray =  (T[]) new Object[sSize];
		top = -1;
	}//const

	
	@SuppressWarnings("unchecked")
	public MyGenericStack(int sSize) {
		super();
		this.sSize = sSize;
		sArray =  (T[]) new Object[sSize];
		top = -1;
	}//const



	
	public void push(T entry)  {
		if(this.isFull())
			this.increaseSize();
		top++;
		this.sArray[top]=entry;
		
	}//push
	
	
	
public T pop()  throws Exception{
	
	if(this.isEmpty())
		throw new Exception(" nothing to pop ");
		
		
	T entry=this.sArray[top];
	top--;
	return entry;
}//pop


             public boolean isEmpty() {
            	return (top ==-1)  ; 
             }//isEmpty
             
             
             public boolean isFull() {
             	return (top ==sSize-1)  ; 
              }//isfull
                

             
         
          
          
          public T peek()  throws Exception {
        	  if(!isEmpty())
        	  return sArray[top];
        	  else
        		  throw new Exception("  nothing in stack");
          }

          
          
       public void  increaseSize(){
        	  int newSize=2* sSize;
        	  
        	  T[] newStack= (T[]) new Object[newSize];
        	  for (int i = 0; i < sArray.length; i++) {
				newStack[i]=this.sArray[i];
        	  }
        	  
        	 this. sArray=newStack;
		this.sSize=newSize;
        	  
          }
          
       public   int size() {
      	 return this.top+1;
       }
          
}//class
