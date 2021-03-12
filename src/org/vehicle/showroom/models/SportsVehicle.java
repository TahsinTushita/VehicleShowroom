
package org.vehicle.showroom.models;

import org.vehicle.showroom.constants.EngineTypes;
import org.vehicle.showroom.constants.VehicleTypes;


public class SportsVehicle extends AVehicle{
    
    private String turbo;
    
    public SportsVehicle(String modelNumber, int enginePower, int tireSize, String turbo) {
        super(modelNumber, EngineTypes.OIL, enginePower, tireSize, VehicleTypes.SPORTS);
        
        this.turbo = turbo;
    }
    
    @Override
    public String toString(){
        return "Vehicle Type: "  + this.getVehicleType() + "\n   Model Number: "+ this.getModelNumber() +
                "\n   Engine Type: " + this.getEngineType() + "\n   EnginePower: " + this.getEnginePower() +
                " hp\n   Tire Size: "+ this.getTireSize() + " inch\n   Turbo: " + this.turbo + "\n";
    }
    
}
