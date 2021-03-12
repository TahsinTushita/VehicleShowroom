
package org.vehicle.showroom.models;

import org.vehicle.showroom.constants.EngineTypes;
import org.vehicle.showroom.constants.VehicleTypes;


public class HeavyVehicle extends AVehicle{
    private float weight;
    
    public HeavyVehicle(String modelNumber, int enginePower, int tireSize, float weight) {
        super(modelNumber, EngineTypes.DIESEL , enginePower, tireSize, VehicleTypes.HEAVY);
        
        this.weight = weight;
    }
    
    @Override
    public String toString(){
        return "Vehicle Type: "  + this.getVehicleType() + "\n   Model Number: "+ this.getModelNumber() +
                "\n   Engine Type: " + this.getEngineType() + "\n   EnginePower: " + this.getEnginePower() +
                " hp\n   Tire Size: "+ this.getTireSize() + " inch\n   Weight: " + this.weight + " kg\n";
    }
    
}
