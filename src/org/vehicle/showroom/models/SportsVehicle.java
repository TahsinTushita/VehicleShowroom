/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.vehicle.showroom.models;

import org.vehicle.showroom.constants.EngineTypes;
import org.vehicle.showroom.constants.VehicleTypes;
import org.vehicle.showroom.models.AVehicle;

/**
 *
 * @author pc
 */
public class SportsVehicle extends AVehicle{
    
    private String turbo;
    
    public SportsVehicle(String modelNumber, int enginePower, int tireSize, String turbo) {
        super(modelNumber, EngineTypes.OIL, enginePower, tireSize, VehicleTypes.SPORTS);
        
        this.turbo = turbo;
    }
    
    @Override
    public String toString(){
        return "Vehicle Type: "  + this.getVehicleType() + "\nModel Number: "+ this.getModelNumber() + "\nEngine Type: " +
                this.getEngineType() + "\nEnginePower: " + this.getEnginePower() + "\nTire Size: "+ this.getTireSize() +
                "\nTurbo: " + this.turbo + "\n";
    }
    
}
