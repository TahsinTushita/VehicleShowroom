/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehicleshowroom;

/**
 *
 * @author pc
 */
public class NormalVehicle extends AVehicle{
    
    public NormalVehicle(String modelNumber, String engineType, int enginePower, int tireSize) {
        super(modelNumber, engineType, enginePower, tireSize, "Normal");
    }
    
}
