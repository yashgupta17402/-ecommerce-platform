package demo;
import ecomm.*;
import java.util.*;
import ecomm.Platform;
import ecomm.Seller;
import java.io.*;

public class DemoPlatform extends Platform 
{
  ArrayList<Seller> sellersList=new ArrayList<>(); // Array list to store list of sellers
  HashMap<String,Integer> reqprocessed=new HashMap<>(); // hash map to store whether the request has
  //been processed
  @Override
  public boolean addSeller(Seller aSeller) 
  {
        
      sellersList.add(aSeller); // Adding Sellers to list
      return true;
  
  }

  @Override
  public void processRequests() // Method to Process requests
  {
  Globals global = new Globals();
  File file = new File("PortalToPlatform.txt");//Opens file to read
  try 
  {

    try (FileWriter wrt = new FileWriter("PlatformToPortal.txt", true);
        BufferedWriter bow = new BufferedWriter(wrt); // File writer
        PrintWriter fWriter = new PrintWriter(bow)) 
    {
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()) //runs till there is a line in the file
        {
          String s = sc.nextLine();
          String[] input=s.split(" ");
          if((!reqprocessed.containsKey((input[1]))))//true if the requestID is not processed
          { 
            reqprocessed.put(input[1],1);
            if (input[2].equals("Start")) 
            {
            String s1 = (input[0] +" " + input[1] + " " + global.getCategoryName(Globals.Category.Book)+ " " +
              global.getCategoryName(Globals.Category.Mobile));
            fWriter.println(s1);
            }
            else if (input[2].equals("List")) 
            {
          
              // fWriter.println(input[0]+" "+input[1]+" "); // String type=input[3];
              ArrayList<Product> prodList = new ArrayList<>();
              for (var e : sellersList)//iterator of seller
              {
                if (global.getCategoryName (Globals.Category.Book).equals(input[3]))
                {
                  prodList = e.findProducts(Globals.Category.Book);//goes to seller findProduct
                } 
                else
                {
                  prodList = e.findProducts(Globals.Category.Mobile);//goes to seller findProduct
                }
                for (var p: prodList) 
                {
                    String s1 = (input[0] + " " + input[1] + " ");
                    fWriter.print(s1);
                    String ss2=(p.getName() + " " + e.getID() + "-" +  p.getName() + " " + p.getPrice()+" "
                  + p.getQuantity());
                    fWriter.println(ss2);
                }
              }
            }
            else if(input[2].equals("Buy"))
            {
              ArrayList<Product> Plist2 = new ArrayList<>();
              ArrayList<Product> Plist1 = new ArrayList<>(); 
              String[] splitName = input[3].split("-"); 
              for (var e: sellersList) 
              {
                if (e.getID().equals(splitName[0]))  // Search accordingly and write to file
                {

                    if(global.getCategoryName (Globals.Category.Book).equals("Book" ))
                    Plist1 = e.findProducts(Globals.Category.Book); 
                    Plist2 = e.findProducts (Globals.Category.Mobile); 
                    Boolean z = false;
                    for (Product p : Plist1) 
                    {
                      if(p.getName().equals(splitName[1]))
                      {
                        if (e.buyProduct(p.getProductID(),Integer.parseInt(input[4])))
                        {
                        String ss=(input[0] + " " + input[1] + " " + "Success");
                        fWriter.println(ss);
                        }
                        else
                        {
                        String ss=(input[0] + " " + input[1] + " " + "Failure");
                        fWriter.println(ss);
                        }
                        z=true;
                        break;
                      }
                    }
                  for(Product p:Plist2) // Search in Plist 2
                  {
                    if(p.getName().equals(splitName[1]))
                    {
                      if(e.buyProduct(p.getProductID(),Integer.parseInt(input[4])))
                      {
                        String ss=(input[0] + " " + input[1] + " " + "Success");
                        fWriter.println(ss);
                      }
                      else
                      {
                        String ss=(input[0] + " " + input[1] + " " + "Failure");
                        fWriter.println(ss);
                      }
                      z=true;
                      break;
                    }
                  }
                  if(!z)
                  {
                    String ss=(input[0] + " " + input[1] + " " + "Failure");
                    fWriter.println(ss);
                  }
                }
              }
            }
            else if (input[2].equals("Start")) 
            {
              // ArrayList<Globals> items = Arrays.asList(Globals.values()); 
              // Globals catgegories[]=Globals.values();
              String ss=(input[0] + " " + input[1] + " ");
              fWriter.println(ss);
              String s1="";
              for (Globals.Category cat : Globals.Category.values()) 
              {
                s1=s1+cat+" ";
              }
              fWriter.println(s1);
              
            }
        }
        else
        {
          continue;//if the request has been processed go to next request
        }
        }
        sc.close();
      }
      catch(FileNotFoundException e)
      {
        e.printStackTrace();
      }
    }
    catch (IOException e1) // error handling
    {
      e1.printStackTrace();
    }
  }
}
 




	

	


