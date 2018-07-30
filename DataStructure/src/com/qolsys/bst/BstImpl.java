package com.qolsys.bst;

public class BstImpl {

	private BstNode root;

	public boolean isEmpty() {

		return (this.root == null);
	}

	public void insert(Integer data) {
		if (root == null) {
			this.root = new BstNode(data);
			System.out.println("data inserted " + data);
			return;
		} // if

		insertNode(this.root, data);
		System.out.println("data inserted " + data);
	}// insert

	
	
	
	
	public BstNode  insertNode(BstNode root,Integer data) {
            	 BstNode tmpNode = null;
            	 
            	 if(root.getData()>=data)
            		 
            		 if(root.getLeft()==null) {
            			 root.setLeft(new BstNode(data));
            	 System.out.println(" left");
            	  return root.getLeft();
            		 }else {
            			 System.out.println(" left");
						tmpNode=root.getLeft();
					}
            	
            	 else {
					if(root.getRight()==null) {
						root.setRight(new BstNode(data));
						System.out.println(" right");
						return root.getRight();
					}
						
						else {
							System.out.println(" right");
							tmpNode= root.getRight();
						}	
				 
				}
            	 return insertNode(tmpNode, data);
            }

}// class
