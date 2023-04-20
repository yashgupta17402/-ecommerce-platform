package demo;
import ecomm.*;
import ecomm.Globals.Category;
//import java.util.*;
import java.util.ArrayList;


public class Yash extends Seller //seller3
{
    Product book1 = new Book("sns","Y101-sns",145,6);
    Product book2 = new Book("dsa","Y101-dsa",40,12);     //created book objects 
    Product book3 = new Book("eng","Y101-eng",200,3);
    Product mobile1 = new Mobile("sam","Y101-sam",10000,20);    //created mobile objects 
    Product mobile2 = new Mobile("apple","Y101-apple",55000,10);
    Product mobile3 = new Mobile("beetle","Y101-beetle",15000,90);
    
    ArrayList<Product> mobile=new ArrayList<>();       //this arraylist has objects of mobile in it
    ArrayList<Product> book=new ArrayList<>();         //this arraylist has objects of book in it
        
    public Yash(String id)          //Seller Yash constructor
    {
        super(id);
        mobile.add(mobile1);      
        mobile.add(mobile2); //adding objects of mobile
        mobile.add(mobile3);
        book.add(book1);
        book.add(book2);
        book.add(book3);//adding objects of book
    }
    public  void addPlatform(Platform thePlatform)
    {
        thePlatform.addSeller(this);            //adds seller to platform
        
    }
    @Override
    public ArrayList<Product> findProducts(Category whichOne)
    {
        ArrayList<Product> output=new ArrayList<>();        //arraylist created for output
        if(whichOne.equals(Globals.Category.Mobile))
        {
            for(int i=0;i<mobile.size();i++)
            {
                output.add(mobile.get(i));
            }
            
        }
        else
        {
            for(int i=0;i<book.size();i++)
            {
                    output.add(book.get(i));   //adds obj to output
            }
        }
            return output;
    }
    @Override
    public boolean buyProduct(String productID, int quantity)    //helps in buying any product wrt to productID and its quantity
    {

        for(int i=0;i<mobile.size();i++)
        {
            Product pr=mobile.get(i); 
            //System.out.println("In Mobiles");
            if(pr.getProductID().equals(productID))
            {
                //System.out.println("Mobile found");
                if(pr.getQuantity()>=quantity){                         //works only when quantity available>= quantity purchased
                    pr.updateQuantity(pr.getQuantity()-quantity);       //updates the quantity
                    return true;
                }
                else
                {
                    return false;//if quantity exceeds
                }
                
            }
        }
        for(int i=0;i<book.size();i++)
        {
            Product pr=book.get(i); 
            // System.out.println("In Books");
            if(pr.getProductID().equals(productID))
            {
                // System.out.println("Book found");
                if(pr.getQuantity()>=quantity)                   //works only when quantity available>= quantity purchased
                {
                    pr.updateQuantity(pr.getQuantity()-quantity);         //updates the quantity
                    return true;
                }
                else
                {
                    return false;//if quantity exceeds
                }
            }
        }
        return false;//if product id does not match
    }
    
}



    

