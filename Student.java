
public class Student {
	private String Fname;
	private String Lname;
	private String major;
	
	protected int id;
	private int SemesterNb;

	Student left;
	Student right;

	CourseList coursesTaken = new CourseList("");

	public Student() {
		Fname = null;
		Lname = null;
		major = null;
		id = 000000000;
		SemesterNb = 0;

	}

	public Student(String Fn, String Ln, String major, int id, int SemNb) {
		Fname = Fn;
		Lname = Ln;
		this.major = major;
		this.id = id;
		SemesterNb = SemNb;

	}

	public String getFname() {
		return Fname;
	}

	public void setFname(String fname) {
		Fname = fname;
	}

	public String getLname() {
		return Lname;
	}

	public void setLname(String lname) {
		Lname = lname;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSemesterNb() {
		return SemesterNb;
	}

	public void setSemesterNb(int semesterNb) {
		SemesterNb = semesterNb;
	}
     

	public void display() {
		System.out.println("Student First name: " + getFname());
		System.out.println("Student Last name: " + getLname());
		System.out.println("Major: " + getMajor());
		System.out.println("Student ID: " + getId());
		System.out.println("Semester: " + getSemesterNb());
		System.out.println();
	}
	
	
	
	public CourseList canTakeCourse(Course c1) {
		CourseList ll = c1.prerequisite;

		CourseList crsList = new CourseList("");
		// don't have any prerequisite
		if (ll.isEmpty())
			return null;
		Node temp = ll.first;
		while (temp != null) {
			if (!coursesTaken.isFound(temp.crs)) {
				crsList.insertAtBack(temp.crs);
				
			}
			temp = temp.next;
		}
		return crsList;
	}
	public boolean canRegisterCourse(Course c){
		CourseList temp = canTakeCourse(c);
		if(temp == null){

			return true;

		}
		else if(temp.length() == 0) {

			return true;
		}
		System.out.println("These are the courses not registered!");
		temp.display();
		return false;
	}
public void registerCourse(Course c1){
	CourseList temp = canTakeCourse(c1);
	if(temp == null){
		coursesTaken.insertAtBack(c1);
		System.out.println(c1.name + " course is registered!");
	}
	else if(temp.length() == 0) {
		coursesTaken.insertAtBack(c1);
		System.out.println(c1.name + " course is registered!");
	}
	else{
	
	
		System.out.println(c1.name + " course is not registered");
		
		System.out.println("These are the courses not registered ");
		temp.display();
		
		
	}
	System.out.println("");
	
}

}
