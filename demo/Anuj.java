package demo;
import ecomm.*;
import ecomm.Globals.Category;
// import java.util.*;
import java.util.ArrayList;


public class Anuj extends Seller //seller1
{
    Product book1 = new Book("sns","A101-sns",1500,600);
    Product book2 = new Book("dsa","A101-dsa",400,102);        //created book objects 
    Product book3 = new Book("eng","A101-eng",2100,3000);
    Product mobile1 = new Mobile("sam","A101-sam",11000,12);        //created mobile objects
    Product mobile2 = new Mobile("apple","A101-apple",65000,11);
    Product mobile3 = new Mobile("beetle","A101-beetle",12000,96);
    
    ArrayList<Product> mobile=new ArrayList<>();       //this arraylist has objects of mobile in it
    ArrayList<Product> book=new ArrayList<>();         //this arraylist has objects of book in it
        
    public Anuj(String id)              //Seller Anuj constructor
    {
        super(id);
        mobile.add(mobile1);          //adding objects of mobile
        mobile.add(mobile2);
        mobile.add(mobile3);
        book.add(book1);
        book.add(book2);             //adding objects of book
        book.add(book3);
    }
    public  void addPlatform(Platform thePlatform)      
    {
        thePlatform.addSeller(this);                     //adds seller to platform
        
    }
    @Override
    public ArrayList<Product> findProducts(Category whichOne)
    {
        ArrayList<Product> output=new ArrayList<>();       //arraylist created for output
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
                    output.add(book.get(i));         //adds obj to output
            }
        }
            return output;
    }
    @Override
    public boolean buyProduct(String productID, int quantity)      //helps in buying any product wrt to productID and its quantity
    {

        for(int i=0;i<mobile.size();i++)
        {
            Product pr=mobile.get(i); 
            // System.out.println("In Mobiles");
            if(pr.getProductID().equals(productID))
            {
                // System.out.println("Mobile found");
                if(pr.getQuantity()>=quantity)        //works only when quantity available>= quantity purchased
                {
                    pr.updateQuantity(pr.getQuantity()-quantity);      //updates quantity 
                    return true;
                }
                else
                {
                    return false;
                }
            }
        }
        for(int i=0;i<book.size();i++)
        {
            Product pr=book.get(i); 
            if(pr.getProductID().equals(productID))
            {
                if(pr.getQuantity()>=quantity){                     //works only when quantity available>= quantity purchased
                    pr.updateQuantity(pr.getQuantity()-quantity);   //updates quantity
                    return true;
                }
                else
                {
                    return false;//if quantity exceeds
                }
            }
        }
        return false;//if product id does not matches
        
    }
    
}



    

