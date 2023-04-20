package ecomm;

public class Mobile extends Product 
{
    public Mobile(String name, String id, float price, int quantity)//constructor of class mobile
    {
        this.price=price;
        this.quantity=quantity;
        this.id=id;
        this.name=name;
    }
	public String getName() //getter for name
    {
        return name;
    }
	public String getProductID()//getter for product id
    {
        return id;
    }
	public float getPrice()//getter for price id
    {
        return price;
    }
	public int getQuantity()//getter for quanity
    {
        return quantity;
    }
    public void updateQuantity(int q)//method to update quantity
    {
        this.quantity=q;
    }
    public Globals.Category getCategory()//to return category
    {
        return Globals.Category.Book;
    }
    private int quantity;//private variables type int for quantity and float for price and string for name and id
    private float price;
    private String name,id;
}