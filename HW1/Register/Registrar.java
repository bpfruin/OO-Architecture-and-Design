package Register;

import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.Random;



public class Registrar {
	
	private ArrayList<Course> courses = new ArrayList<Course>();
	
	//from Mark Shacklette's in class example
	protected Registrar(){}
	
	public static Registrar getInstance(){
		if (instance == null){
			//took out synchronized part
			instance = new Registrar();
		}
		return instance;
	}
	
	
	private static Registrar instance = null;
	
	//From Mark Shacklette's in class example
	public static void main(String[] args){
		Registrar r1, r2;
		
		
		//r1 = Registrar.getInstance();
		r1 = new Registrar();
		r1.aMethod();
//		r2 = Registrar.getInstance();
		r2 = new Registrar();
		r2.aMethod();
		if(r1.equals(r2)){
			System.out.println("Awesome! You've got a Singleton. r1 and r2 are equal");
		} else {
			System.out.println("Uh oh. r1 and r2 are not equal.  Not a Singleton!");
		}
		
	}
	
	//This method adds some courses to the courses ArrayList
	public void initSystem(){
		
		courses.add(new Course("english"));
		courses.add(new Course("science"));
		courses.add(new Course("history"));
		courses.add(new Course("math"));
		courses.add(new Course("spanish"));
		
	}
	
	//This method calls initSystem if it needs to, then iterates over the list, adding a random
	//number of students to the courses as it loops through. It calls the toString method before
	//and after adding students so the user can see the change.
	public void aMethod(){
		System.out.println("Calling aMethod of Registrar");
		//we only want to initialize the courses once so we use an "if" to check if they already have been
		if (courses.size()<=0){
			initSystem();
		}
		for (int i = 0; i<courses.size(); i++){
			System.out.println("BEFORE ENROLLING STUDENTS");
			courses.get(i).toString();
			int randomNum = (int)(Math.random()*25);
			for (int j = 0; j<randomNum; j++){
				courses.get(i).addStudent();
			}
			System.out.println("AFTER ENROLLING STUDENTS");
			courses.get(i).toString();
		}

		
	}
}
