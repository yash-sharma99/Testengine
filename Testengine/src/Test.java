import java.util.ArrayList;

class Student {

//	void setVisible(){

	//	System.out.println("Student Visible");	

		//}

	int id ;

	String name;

	String address;

	//static{

		//System.out.println("Student Class Loaded...");

//	}

	Student(){

		System.out.println("Student Cons Call");

		id = 1001;

		name = "Ram";

		address= "Delhi";

	}

}



public class Test {
	

	public static void main(String[] args) {
		
	
		Student ram = new Student();

	ArrayList<String> list = new ArrayList<>();

list.add("ram");
	System.out.println(list);

	//list.add("ramesh");

	//list.add("shyam");

//		System.out.println(list.toString());

//		System.out.println(ram.toString());

		
		
		
		
		// TODO Auto-generated method stub

	}

}
