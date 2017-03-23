/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package firstassignment;

import static firstassignment.Constants.CRETA;
import static firstassignment.Constants.GRAND_I10;
import static firstassignment.Constants.I10;
import static firstassignment.Constants.VERNA;
import static firstassignment.Constants.input;


public class Toyota extends Cars {
    private int CAR_ID = 1; 
    enum ToyotaCars
    {
        ETIOS , ETIOS_LIVA ,INNOVA
    }
   
     public Toyota(){
     carID = CAR_ID++;  
    }
    public void setCarModel (){
    System.out.println("Enter car model :- \n Enter 1 for ETIOS\n Enter 2 for ETIOS_LIVA \n Enter 3 for INNOVA ");
    
    switch(input.nextInt()){
        case ETIOS : model = ""+ToyotaCars.ETIOS;
                break;
        case ETIOS_LIVA : model = ""+ToyotaCars.ETIOS_LIVA;
                break;
        case INNOVA : model = ""+ToyotaCars.INNOVA;
                break;
       
        default : System.out.println("Wrong Input");
    }
               

    }
    public void setPrice()
    {
        System.out.println("Enter The Price for " + model + ": ");
        price = input.nextDouble();
        resaleValue = 0.4*price;
    }
}
