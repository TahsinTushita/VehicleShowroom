
package org.vehicle.showroom.models;

import org.vehicle.showroom.constants.VehicleTypes;


public class NormalVehicle extends AVehicle{
    
    public NormalVehicle(String modelNumber, String engineType, int enginePower, int tireSize) {
        super(modelNumber, engineType, enginePower, tireSize, VehicleTypes.NORMAL);
    }
    
}
