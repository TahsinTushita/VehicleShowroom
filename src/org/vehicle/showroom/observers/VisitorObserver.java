
package org.vehicle.showroom.observers;

import org.vehicle.showroom.subjects.VehicleSubject;


public class VisitorObserver implements IObserver{
            
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
        if(VehicleSubject.getInstance().getVehicleList().isEmpty())
            System.out.println("No visitors are expected in the showroom as there are no vehicles");
        else
            System.out.println("Current expected visitor count:  " + visitorCount);
    }
    
}
