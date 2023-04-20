package ecomm;

public class Book extends Product
{
    private float price;          //price variable
    private String name;          //variable for name
    private String productid;    //variable for productID
    private int quantity;        //variable for quantity
    public Book(String Name, String ProductID,float Price,int Quantity)      //constructor
    {
        this.price=Price;
        this.name=Name;
        this.productid=ProductID;
        this.quantity=Quantity;
    }
    public String getName()            //getter for name
    {
        return name;
    }
    public String getProductID()          //getter for productID
    {
        return productid;
    }
    public float getPrice()      //getter for Price
    {
        return price;
    }
    public int getQuantity()             //getter for Quantity
    {
        return quantity;
    }
    public void updateQuantity(int q)      
    {
        this.quantity=q;
    }
    public Globals.Category getCategory()    //getter for category
    {
        return Globals.Category.Book;
    }

    



    
}
