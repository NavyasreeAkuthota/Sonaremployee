
import java.util.Scanner;
import java.util.logging.Logger;

public class EmplMain {
	public static void main(String[] args) {
		var ch=0;
		var sel=0;
		var scan= new Scanner(System.in);
		var logger = Logger.getLogger(EmplMain.class.getName());
		
		     do{
		    	 logger.info("1.CREATE AN EMPLOYEE \n2.DISPLAY ALL EMPLOYEES \n3.DISPLAY EMPLOYEE BY DESIGNATION \n4.RAISE THE SALARIES OF ALL EMPLOYEES \n5.RAISE SALARY BY ID \n6.DELETE EMPLOYEE BY ID \n7.EXIT \nENTER YOUR CHOICE");
		       ch=scan.nextInt();
		       if(ch==7) break;
		       switch(ch){
		       case 1: do { logger.info("YOU WOULD LIKE TO CREATE  \n1.MANAGER \n2.CLERK \n3.PROGRAMMER \n4.QUIT");
		               sel=scan.nextInt();
		              if(sel==4) break;
		              logger.info("ENTER NAME:");
		              String na=scan.next();
		              logger.info("ENYTER AGE:");
		              var ag=scan.nextInt();
		              switch(sel) {
		              case 1 :   Empl m=new Manager(na,ag);
		                         m.create();
		                         break;
		              case 2:    Empl c= new Clerk(na,ag);
		                         c.create();
		                         break;
		              case 3 :   Empl p= new Programmer(na,ag);
		                         p.create();
		                         break;
		              default:   logger.info("INVALID SELECTION...!");
		              }
		            }while(sel!=4);
		             break;
		     case 2:     new JdbcConnection().display();
		                  break;
		     case 3:     new JdbcConnection().displayByDesignation();
		    	         break;
		     case 4:    (new Clerk()).raiseSalary();
		                 logger.info("SALARIES RAISED\n");
		                  break;
		     case 5:    new JdbcConnection().raiseById();
		                logger.info("SALARY RAISED....!");
		                 break;
		     case 6:    new JdbcConnection().deleteEmployee();
		          
		                logger.info("EMPLOYEE DETAILS DELETED PERMANENTLY.......");
		                break;
		      default: logger.info("INVALID CHOICE....");
		     }                    
	   }while(ch!=7);
		     scan.close();
	
  }

}