package demo;
import ecomm.*;
import ecomm.Globals.Category;
// import java.util.*;
import java.util.ArrayList;


public class Chinmay extends Seller //seller2
{
    Product book1 = new Book("sns","C101-sns",150,7);
    Product book2 = new Book("dsa","C101-dsa",60,12); //created book objects 
    Product book3 = new Book("eng","C101-eng",700,2);
    Product mobile1 = new Mobile("sam","C101-sam",21000,23); //created mobile objects 
    Product mobile2 = new Mobile("apple","C101-apple",75000,14);
    Product mobile3 = new Mobile("beetle","C101-beetle",14000,92);
    
    ArrayList<Product> mobile=new ArrayList<>();       //this arraylist has objects of mobile in it
    ArrayList<Product> book=new ArrayList<>();         //this arraylist has objects of book in it
        
    public Chinmay(String id)         //Seller Chinmay constructor
    {
        super(id);
        mobile.add(mobile1);
        mobile.add(mobile2);           //adding objects of mobile
        mobile.add(mobile3);
        book.add(book1);
        book.add(book2);           //adding objects of book
        book.add(book3);
    }
    public  void addPlatform(Platform thePlatform)
    {
        thePlatform.addSeller(this); //adds seller to platform
        
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
                    output.add(book.get(i)); //adds obj to output
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
            // System.out.println("In Mobiles");
            if(pr.getProductID().equals(productID))
            {
                // System.out.println("Mobile found");
                if(pr.getQuantity()>=quantity){                        //works only when quantity available>= quantity purchased
                    pr.updateQuantity(pr.getQuantity()-quantity);         //updates quantity 
                    return true;
                }
                else{
                    return false;
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
                if(pr.getQuantity()>=quantity)
                {       //works only when quantity available>= quantity purchased
                    pr.updateQuantity(pr.getQuantity()-quantity);          //updates quantity 
                    return true;
                }
                else
                {
                    return false;//if quantity changes
                }
            }
        }
        return false;//if product id does not match
    }
    
}



    

