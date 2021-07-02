
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Logger;

public class Service {
	Logger logger = Logger.getLogger(Service.class.getName());
	
Service(){
		
	}
	Service(Statement st){
		try{st.executeUpdate("update employee set salary=salary+(salary*10)");
	}catch(Exception e) {
		e.printStackTrace();
	}
  }
	public void display(Statement st) {
		try {
			ResultSet rs=st.executeQuery("Select * from employee;");
			while(rs.next()) {
				
           	  logger.info("    EmpId : "+rs.getInt(1)+" \n Name : "+rs.getString(2)+" \n Age : "+rs.getInt("age")+" \n Designation : "+rs.getString("designation")+" \n Salary :"+rs.getInt("salary"));
           	 
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void displayByDesignation(Statement st, int desig) {
		String job=null;
	        if(desig==1) job="Manager";
	        if(desig==2) job="Programmer";
	        if(desig==3) job="Clerk";
	       try { ResultSet rs=st.executeQuery("select * from employee where designation = '"+job+"'");
	       while(rs.next()) {
				 
         	  logger.info("    EmpId : "+rs.getInt(1)+" \n Name : "+rs.getString(2)+" \n Age : "+rs.getInt("age")+" \n Designation : "+rs.getString("designation")+" \n Salary :"+rs.getInt("salary"));
         	 
			}
	}catch(Exception e ) {
		e.printStackTrace();
	}
	}
	public void raiseByID(int id, Statement st) {
		    try {
		    	st.executeUpdate("update employee set salary=salary+(salary*10) where id="+id);
		    }catch(Exception e) {
		    	e.printStackTrace();
		    }
		
	}
	public void deleteById(Statement st, int id) {
	       try {
	    	   st.executeUpdate("delete from employee where id="+id);
	       }catch(Exception e) {
	    	   e.printStackTrace();
	       }
		
	}
}