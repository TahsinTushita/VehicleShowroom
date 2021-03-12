
package org.vehicle.showroom;

import org.vehicle.showroom.constants.VehicleTypes;
import org.vehicle.showroom.models.SportsVehicle;
import org.vehicle.showroom.models.NormalVehicle;
import org.vehicle.showroom.models.HeavyVehicle;
import org.vehicle.showroom.models.AVehicle;


public class VehicleFactory {
 
    private static VehicleFactory instance;
    
    private VehicleFactory(){};
    
    public static VehicleFactory getInstance(){
        if (instance == null){
            instance = new VehicleFactory();
        }
        
        return instance;
    }
    
    public AVehicle getVehicle(String vehicleType, String modelNumber, String engineType, int enginePower,
            int tireSize, String turbo, float weight){
        
        switch(vehicleType){
            case VehicleTypes.SPORTS:
                return new SportsVehicle(modelNumber, enginePower, tireSize, turbo); 
                
            case VehicleTypes.HEAVY:
                return new HeavyVehicle(modelNumber, enginePower, tireSize, weight);
                
            default:
                return new NormalVehicle(modelNumber, engineType, enginePower, tireSize);
        }
        
    }
    
}
