/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.vehicle.showroom;

import org.vehicle.showroom.subjects.VehicleList;
import org.vehicle.showroom.observers.VisitorObserver;
import org.vehicle.showroom.models.AVehicle;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author pc
 */
public class VehicleShowroom{

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        
        VehicleFactory vehicleFactory = VehicleFactory.getInstance();
        VehicleList vehicleList = VehicleList.getInstance();
        VisitorObserver visitorObserver = VisitorObserver.getInstance();
        vehicleList.register(visitorObserver);
        
        Scanner in = new Scanner(System.in);
        
        String vehicleType;
        String modelNumber;
        String engineType;
        int enginePower;
        int tireSize;
        String turbo;
        float weight;
        int vehicleIndex;
        int input;
        AVehicle vehicle;
        
        while(true){
            
            input = in.nextInt();
            
            if(input == 1){
                vehicleType = in.next();
                modelNumber = in.next();
                engineType = in.next();
                enginePower = in.nextInt();
                tireSize = in.nextInt();
                turbo = in.next();
                weight = in.nextFloat();
                
                System.out.println(vehicleType);

                vehicle = vehicleFactory.getVehicle(vehicleType, modelNumber, engineType, enginePower, tireSize,
                        turbo, weight);

                vehicleList.addVehicleToList(vehicle);
            }
            
            else if(input == 2){
                if(vehicleList.getVehicleList().isEmpty())
                    System.out.println("There are no vehicles in the showroom to remove");
                else{
                    
                    vehicleIndex = in.nextInt();
                    
                    vehicleList.removeVehicleFromShowroom(vehicleIndex);
                }
            }
            
            else if(input == 3){
                vehicleList.printVehicleList();
            }
            
        }
        
    }
}
