
public class Empl{

	String name;
	int age;
	String job;
	int sal;
	Empl(){
		
	}
	Empl(String n,int a, String j,int s){
		name=n;
		age=a;
		job=j;
		sal=s;
	}   
	public void create() {
		new JdbcConnection(name,age,job,sal);
	}	
	public void raiseSalary() {
		new JdbcConnection().raiseSal();
	}

}