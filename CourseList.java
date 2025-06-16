
public class CourseList {
	Node first;
	String name;
	int size = 0;
	CourseList(String name){
		this.name = name;
	}
	public boolean isEmpty(){
		return first == null;
	}
	

	public boolean isFound(Course c1){
		Node p = new Node(c1);
		Node temp = first;
		
		while(temp != null){
			if(temp.crs == c1){
				return true;
			}
			temp = temp.next;
		}
		return false;
	}
	
	

	
public void removeCourse(Course c1) {
	if(isEmpty())return;
	Node temp = first;
	Node prev = first;
	if( temp.crs == c1) {
		
		deleteFromFront();
		return;
	}
	while(temp !=null) {
		
		if(temp.crs == c1) {
			prev.next = temp.next;
			return;
		}
		
		prev = temp;
		temp = temp.next;
		
		
	}
	
}

	
	public void addList(CourseList ll){
		if(ll.isEmpty()) return;
		Node temp = ll.first;
		while(temp != null){
			insertAtBack(temp.crs);
			temp = temp.next;
		}
	}
	public void insertAtBack(Course c1){
		Node p = new Node(c1);
		
		Node current = first;
		
		if(isEmpty()){
			first = p;
			return;
		}
		
		while(current.next != null) {
			if(current == p) return;
			current = current.next;
		}
		
		current.next = p;
		
		
		//1 7 6 5
		
		//insert 4	//1 7 6 5 4
		//insert 7 // 1 7 6 5 4  !!!7 is not inserted
		
	}
	public void deleteFromFront(){
		if(isEmpty()) return;
		first = first.next;
		
		return;
	}
	
	public int length() {
		int counter=0;
		Node current=first;
		while(current!=null) {
			counter++;
			current=current.next;
		}
		return counter;
	}
	public void display(){
		Node temp = first;
		boolean flag = true;
		while(temp != null){
			System.out.println(temp.crs.name + " ");
			temp = temp.next;
			flag = false;
		}
		System.out.println();
		if(flag)
		System.out.println("No prerequisites");
	}
	
	
	
}


