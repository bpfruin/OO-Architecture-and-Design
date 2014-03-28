package Register;

//simple class to represent a course.
public class Course {
	
	private String courseName;
	private int capacity;
	private int enrolled;
	private int seatsLeft;
	
	public Course(String name){
		
		courseName = name;
		capacity = 50;
		enrolled = 0;
		seatsLeft = capacity;
		
	}
	
	//override toString so we can display course info
	public String toString(){
		String description = "Course: "+this.courseName+"   seatsLeft: "+this.seatsLeft+"   enrolled: "+this.enrolled;
		System.out.println(description);
		return description;
	}
	
	
	//This method represents the adding of a student to a course
	public void addStudent(){
		
		this.enrolled++;
		this.seatsLeft--;
		
	}

}
