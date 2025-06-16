
public class Course { 
	String name;
	String code;

	CourseList prerequisite = new CourseList("name");
	
	
	Course(String name){
		this.name = name;

	}
	Course(String name,String code){
		this.name=name;
		this.code=code;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	
	public void addPrerequisite(Course c1){

		prerequisite.insertAtBack(c1);
		prerequisite.addList(c1.prerequisite);
		
	}

	
	public void displayPrerequisites(){
		prerequisite.display();
	}

	
	

}
    

