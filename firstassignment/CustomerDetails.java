/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package firstassignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class CustomerDetails implements Constants{
    public static int CURRENT_ID = 1;
    private int customerID;
    private String customerName;
    private List<Cars> customerCars ;
   
    public CustomerDetails()
    {
        customerCars = new ArrayList<Cars>();
    }
    public void setID()
    {
        customerID = CURRENT_ID++;
    }
    public void setName()
    {
        System.out.print("Enter Customer Name : ");
        customerName = input.next();
        
    }
    
    public void addCar()
    {   int carMake;
        System.out.print("Enter 1 for Hyundai \n Enter 2 for Toyota \n Enter 3 for Maruti \n Enter car Make : ");
        carMake = input.nextInt();
        Cars newCar = null;
        if(carMake==HYUNDAI)
        {
             newCar = new Hyundai();
        }
        else if (carMake == TOYOTA)
        {
             newCar = new Toyota();
        }
        else if (carMake ==  MARUTI)
        {
             newCar = new Maruti();
        }
        else 
        {
            System.out.print("Wrong Input");
            
        }
        if(newCar != null)
        {
           
           newCar.setCarModel();
           newCar.setPrice();
           customerCars.add(newCar);
           
        }
     }
    
    public String getName()
    {
        return customerName;
    }
    
    public int getID()
    {
        return customerID;
    }
    public List<Cars> getCars(){
    
    return customerCars;
    }
    
    
    

}
