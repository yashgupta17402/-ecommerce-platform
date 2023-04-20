import demo.DemoPlatform;
import ecomm.Platform;
import ecomm.Seller;
import demo.*;
import java.util.*;

public class PlatformMain {

	public static void main(String[] args) 
	{

		Platform pf = new DemoPlatform();  
		Seller anuj=new Anuj("A101");// replace with appropriate derived class
		Seller chinmay=new Chinmay("C101");// replace with appropriate derived class
		Seller yash=new Yash("Y101");// replace with appropriate derived class
		pf.addSeller(anuj);
		pf.addSeller(chinmay);//adding sellers
		pf.addSeller(yash);
		Scanner sc=new Scanner(System.in);//scanner class
		while(true)//infinite loop
		{
			String s=sc.nextLine();
			if(s.equals("Check"))//if string equals check
			{
				pf.processRequests();//going to processrequests through object of platform
			}
			else
			{
				break;
			}
		}
		// create a number of sellers (of different sub-types of Seller)
		// Assign a name (sellerID) to each of them.
		
		// replace each of the XYZ below with the derived class name of one of the
		// team members.
		
		/*
		Seller s1 = new DemoSeller1("Seller1"); 
		s1.addPlatform(pf);

		Seller s2 = new SellerXYZ("Seller2");
		s1.addPlatform(pf);
		
		Seller s3 = new SellerXYZ2("Seller3");
		s1.addPlatform(pf);
 		*/
		
		/*
		// keep reading from System.in
		// If "Check" typed in
		// invoke 
			pf.processRequests();
		*/
		sc.close();//scanner class closed
	}

}
