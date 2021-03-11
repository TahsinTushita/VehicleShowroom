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
public class VehicleFactory {
 
    private static VehicleFactory instance;
    
    private VehicleFactory(){};
    
    public static VehicleFactory getInstance(){
        if (instance == null){
            instance = new VehicleFactory();
        }
        
        return instance;
    }
    
    public static AVehicle getVehicle(String vehicleType, String modelNumber, String engineType, int enginePower,
            int tireSize, String turbo, float weight){
        
        switch(vehicleType){
            case "Sports":
                return new SportsVehicle(modelNumber, enginePower, tireSize, turbo); 
                
            case "Heavy":
                return new HeavyVehicle(modelNumber, enginePower, tireSize, weight);
                
            default:
                return new NormalVehicle(modelNumber, engineType, enginePower, tireSize);
        }
        
    }
    
}
