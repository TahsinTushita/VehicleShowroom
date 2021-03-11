/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.vehicle.showroom.models;

import org.vehicle.showroom.constants.VehicleTypes;
import org.vehicle.showroom.models.AVehicle;

/**
 *
 * @author pc
 */
public class NormalVehicle extends AVehicle{
    
    public NormalVehicle(String modelNumber, String engineType, int enginePower, int tireSize) {
        super(modelNumber, engineType, enginePower, tireSize, VehicleTypes.NORMAL);
    }
    
}
