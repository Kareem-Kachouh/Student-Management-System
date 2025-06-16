public class BSTStudent {
	Student root;

	public void display(){
		inorder(root);
	}
	public boolean isEmpty() {
		if(root==null)return true;
		 return	false;
	}
	public void inorder(Student root){
		if(root != null)
		{
			inorder(root.left);
			root.display();
			inorder(root.right);
		}
	}
	

	//this function return the node if found else returns null
	//if(search(33)!= null) found
	//else not found
	public Student search(int id){
		return searchUtil(root,id);
	}
	
	public boolean isFoundStudent(int key) {
		return search(key)!=null;
	}

	
	
	
	
	public Student searchUtil(Student root, int key){
		if(root != null){
			if(root.getId() == key){
				return root;
			}
			else if(root.getId() < key){
				return searchUtil(root.right,key);
			}
			return searchUtil(root.left,key);
		}
		return null;
	}
	
	public void insert(Student s){
		root = insertUtil(root,s);
	}
	
	Student insertUtil(Student root, Student s){
		if(root == null){
			root = s;
			return root;
		}
		if(s.getId() < root.getId())
			root.left = insertUtil(root.left,s);
		else if(s.getId() > root.getId())
		{
			root.right = insertUtil(root.right,s);
		}
		return root;
	}
	
	
	
	 public void deleteByID(int  key)
	   {
	       root=deleteNode(root,key); //calling deleteNode() method
	       
	   }
	    public  Student  deleteNode(Student root,int key)
	   {
	       if(root==null) 
	       return root;
	       if(key<root.getId())  //if value is less than current value
	           root.left=deleteNode(root.left,key);
	       else if(key>root.getId()) //if value if greater than current value
	           root.right=deleteNode(root.right,key);
	       else 
	       {
	       //if node having max one child
	       if(root.left==null)    
	           return root.right;
	       else if(root.right==null)
	           return root.left;
	       // if node having two children then get the inorder predecessor of node
	       root.id=minimumValue(root.left);
	       //delete the inorder predecessor
	        root.left=deleteNode(root.left,root.getId());  
	        }
	       return root;
	   }
	   //get minimum element in binary search tree
	   public int minimumValue(Student root)
	   {
	       int min;
	       for(min=root.getId();root.right!=null;root=root.right)
	       min=root.right.getId();
	       return min; 
	   }

}