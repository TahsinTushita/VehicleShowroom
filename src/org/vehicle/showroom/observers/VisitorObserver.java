/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.vehicle.showroom.observers;

import org.vehicle.showroom.subjects.VehicleList;

/**
 *
 * @author pc
 */
public class VisitorObserver implements Observer{
            
    private static VisitorObserver instance;
    
    private VisitorObserver(){
            
    };
    
    public static VisitorObserver getInstance(){
        if(instance == null){
            instance = new VisitorObserver();
        }
        
        return instance;
    }
    
    private int visitorCount = 30;

    @Override
    public void vehicleAdded() {
        visitorCount = visitorCount + 20;
    }

    @Override
    public void vehicleRemoved() {
        visitorCount = visitorCount - 20;
    }

    public void printVisitorCount(){
        if(VehicleList.getInstance().getVehicleList().isEmpty())
            System.out.println("There are no visitors in the showroom as there are no vehicles");
        else
            System.out.println("Current visitor count  " + visitorCount);
    }
    
}
