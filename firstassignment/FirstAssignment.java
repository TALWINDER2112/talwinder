/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package firstassignment;

import static firstassignment.Constants.CRETA;
import static firstassignment.Constants.GRAND_I10;
import static firstassignment.Constants.I10;
import static firstassignment.Constants.VERNA;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import sun.text.normalizer.CharTrie;

/**
 *
 * @author Admin
 */
public class FirstAssignment implements Constants{

   public static int CURRENT_ID = 1;
   private List<CustomerDetails> allCustomers ;
   
   CustomerDetails newCustomer ;
   CustomerDetails existingCustomer;
   
   List<Cars> customerCars ;
   private static Boolean doNext = true;
   public FirstAssignment()
   {
       allCustomers = new ArrayList<CustomerDetails>();
   }
   public static void main(String[] args) {
        FirstAssignment firstAssignment = new FirstAssignment();
        firstAssignment.display();
        
        }
       
   
   
    public void display()
    {
         do{
         System.out.println("_________________WELCOME_________________");
         System.out.print(" Enter 1 to ADD NEW CUSTOMER \n Enter 2 to ADD NEW CAR \n Enter 3 to LIST CUSTOMERS \n Enter 4 LIST CUSTOMERS ON ID \n Enter 5 to GENERATE PRIZES \n Enter 0 to exit.");
         switch(input.nextInt())
         {
             case ADD_NEW_CUSTOMER : {addCustomer();
                       System.out.println("Customer Added Successfully !");
                      }
                 break;
             case ADD_NEW_CAR : {addCar();
                       System.out.println("Car Added Successfully!");
                      }
                 break;
             case LIST_CUSTOMERS : listCustomers();
                 break;
             case LIST_CUSTOMERS_ON_ID : getCustomer();
                 break;
             case GENERATE_PRIZES  : generatePrizes();
                 break;
             case EXIT : System.exit(0);
             default : System.out.println("Wrong Input");
         
         }
         }
         while(doNext);
    }
    
    
    
    public void addCustomer(){
        newCustomer = new CustomerDetails();
        newCustomer.setID();
        newCustomer.setName();
        newCustomer.addCar();
        allCustomers.add(newCustomer);
        
    }
    
    public void addCar(){ 
        int customerID ,customerIndex = 0;
        Collections.sort(allCustomers, new Comparator<CustomerDetails>(){
     public int compare(CustomerDetails customer1, CustomerDetails customer2){
         if(customer1.getID() == customer2.getID())
             return 0;
         return customer1.getID() < customer2.getID() ? -1 : 1;
     }
});
        System.out.println("__________LIST OF CUSTOMERS__________");
        while (customerIndex < allCustomers.size())
        {
        System.out.println("|    "+allCustomers.get(customerIndex).getID() + "     |     " + allCustomers.get(customerIndex).getName()+"      |");
        System.out.println("___________________________");
        customerIndex++;
        }
        System.out.println("Enter Customer ID to Add new Car");
        customerID = input.nextInt();
        if(customerID>0 && customerID<=allCustomers.size()){
           customerIndex = getCustomerIndexForID(customerID);
           existingCustomer = allCustomers.get(customerIndex);
           existingCustomer.addCar();
        }
        else 
            System.out.print("Customer Doesn't Exist");
    }
    
    public void listCustomers()
    {
        int customerIndex = 0;
        
        Collections.sort(allCustomers,new Comparator<CustomerDetails>() {public int compare(CustomerDetails c1 , CustomerDetails c2)
        {return c1.getName().compareTo(c2.getName());}});  
        
        System.out.println("__________-LIST OF ALL CUSTOMERS-___________");
        System.out.println(" CustomerID       Customer Name    Cars ");
        while(customerIndex < allCustomers.size())
        {
            existingCustomer = allCustomers.get(customerIndex);
            System.out.print(""+existingCustomer.getID()+ "            ");
            System.out.print(""+existingCustomer.getName()+ "              ");
            customerCars =  existingCustomer.getCars();
            int carIndex=0;
            while(carIndex < customerCars.size())
            { System.out.print(""+customerCars.get(carIndex).model+"  ");
              carIndex++;
            }  
            System.out.println("");
            customerIndex++;
        }
    }
    
    public void getCustomer(){
        int customerID;
        
        System.err.println("Enter customer ID : ");
        customerID = input.nextInt();
        if (customerID>0 && customerID<=allCustomers.size())
        {
            
            existingCustomer = allCustomers.get(getCustomerIndexForID(customerID));
            System.out.println("  CUSTOMER ID       NAME        CARS        PRICE      RESALE VALUE");
            System.out.print(""+existingCustomer.getID()+ "              ");
            System.out.print(""+existingCustomer.getName()+ "              ");
            customerCars =  existingCustomer.getCars();
            int carIndex=0;
            while(carIndex < customerCars.size())
            { System.out.println(""+customerCars.get(carIndex).model+"  "+customerCars.get(carIndex).price +"  "+customerCars.get(carIndex).resaleValue );
              System.out.print("                                 ");
              carIndex++;
            }  
            System.out.println("");
        }
        else 
            System.out.println("Customer Doen't Exist.");
    }
    public int getCustomerIndexForID(int ID)
    {
        int customerIndex = 0;
        while(customerIndex < allCustomers.size())
            {
                existingCustomer = allCustomers.get(customerIndex);
                if(existingCustomer.getID() == ID)
                    break;
                customerIndex++;
            }
        return customerIndex;
    }
    public void generatePrizes()
    {
        Random random = new Random() ;
        int max = allCustomers.size();
        int min = 1;
        Set<Integer> randomNumber = null;
        
        int customerIds[] = new int[3] ;
        while(randomNumber.size()<7)
        {
            randomNumber.add (random.nextInt((max-min)+1)+min);
        }
        System.out.println("enter 3 CustomerIDs : ");
        for (int customerIDIndex = 0;customerIDIndex<3;customerIDIndex++)
        {
         customerIds[customerIDIndex] = input.nextInt();
        }
        for(int customerIdIndex = 0;customerIdIndex<3;customerIdIndex++)
        {
            if (randomNumber.contains(customerIds[customerIdIndex]))
                {
                    existingCustomer = allCustomers.get(getCustomerIndexForID(customerIds[customerIdIndex]));
                    System.out.println("Congratulations : "+ existingCustomer.getID() + "  " + existingCustomer.getName());
                }
            
        }
    }

   
}
