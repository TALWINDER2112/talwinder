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


public class Maruti extends Cars{
    private static int CAR_ID = 1;
   
    public enum MarutiCars {
        ALTO , SWIFT ,SWIFT_DESIRE, CIAZ
        
    }
   public Maruti(){
     carID = CAR_ID++;  
    }
    public void setCarModel (){
    System.out.println("Enter car model :- \n Enter 1 for ALTO\n Enter 2 for SWIFT \n Enter 3 for SWIFT_DESIRE \n Enter 4 for CIAZ");
    
    switch(input.nextInt()){
        case ALTO : model = ""+MarutiCars.ALTO;
                break;
        case SWIFT : model = ""+MarutiCars.SWIFT;
                break;
        case SWIFT_DESIRE : model = ""+MarutiCars.SWIFT_DESIRE;
                break;
        case CIAZ : model = ""+MarutiCars.CIAZ;
                break;
        default : System.out.println("Wrong Input");
    }
               
    }
    public void setPrice()
    {
        System.out.println("Enter The Price for " + model + ": ");
        price = input.nextDouble();
        resaleValue = 0.6*price;
    }
}
