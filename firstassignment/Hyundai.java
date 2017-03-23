/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package firstassignment;

import static firstassignment.Constants.I10;
import java.util.Scanner;


public class Hyundai extends Cars implements Constants{
    private static int CAR_ID = 1; 
    
    enum HyundaiCars{
    I10,GRAND_I10,CRETA,VERNA
   } 
     
    
    public Hyundai(){
     carID = CAR_ID++;  
    }
    public void setCarModel (){
    System.out.println("Enter car model :- \n Enter 1 for I10\n Enter 2 for GRAND_I10 \n Enter 3 for CRETA \n Enter 4 for VERNA");
    
    switch(input.nextInt()){
        case I10 : model = ""+HyundaiCars.I10;
                break;
        case GRAND_I10 : model = ""+HyundaiCars.GRAND_I10;
                break;
        case CRETA : model = ""+HyundaiCars.CRETA;
                break;
        case VERNA : model = ""+HyundaiCars.VERNA;
                break;
        default : System.out.println("Wrong Input");
    }
               
    }
    public void setPrice()
    {
        System.out.println("Enter The Price for " + model + ": ");
        price = input.nextDouble();
        resaleValue = 0.8*price;
    }
    }
    
    
    
    


