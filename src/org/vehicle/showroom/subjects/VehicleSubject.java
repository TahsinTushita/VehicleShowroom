
package org.vehicle.showroom.subjects;

import org.vehicle.showroom.observers.VisitorObserver;
import org.vehicle.showroom.models.AVehicle;
import java.util.ArrayList;
import org.vehicle.showroom.constants.Enums.VehicleState;
import org.vehicle.showroom.constants.VehicleTypes;
import org.vehicle.showroom.observers.IObserver;


public class VehicleSubject implements ISubject{
    
    private ArrayList<AVehicle> vehicles;
    private ArrayList<IObserver> observers;
    private VisitorObserver visitorObserver;
    
    private static VehicleSubject instance;
    
    private VehicleSubject(){
        
        vehicles = new ArrayList<>();
        observers = new ArrayList<>();
        visitorObserver = VisitorObserver.getInstance();
        
    };
    
    public static VehicleSubject getInstance(){
        if(instance == null){
            instance = new VehicleSubject();
        }
        
        return instance;
    }

    @Override
    public void register(IObserver observer) {
        observers.add(observer);
    }

    @Override
    public void unregister(IObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyAllObservers(VehicleState state) {
        if(state == state.VEHICLE_ADDED){
            for(IObserver observer: observers){
                observer.vehicleAdded();
            }
        }
        else if(state == state.VEHICLE_REMOVED){
            for(IObserver observer: observers){
                observer.vehicleRemoved();
            }
        }
    }

    public ArrayList<AVehicle> getVehicleList() {
        return vehicles;
    }
    
    
    
    public void printVehicleList(){
        
        int i = 1;
        
        System.out.print("\n\n----------------------------------------------------------\nVehicle List:\n");
        
        if(!vehicles.isEmpty()){
            for (AVehicle vehicle: vehicles){
            System.out.println(i + ". "  +  vehicle);
            i++;
        }
            visitorObserver.printVisitorCount();
            System.out.print("\n----------------------------------------------------------\n\n");
        }
        
        else{
            System.out.println("There are no vehicles in the showroom"
                    + "\n----------------------------------------------------------\n");
        }
        
    }
    
    public void addVehicleToList(AVehicle vehicle){
        vehicles.add(vehicle);
        System.out.print("\nVehicle is added\n\n");
        
        if(vehicle.getVehicleType().equals(VehicleTypes.SPORTS)){
            notifyAllObservers(VehicleState.VEHICLE_ADDED);
        }
        
        printVehicleList();
    }
    
    public void removeVehicleFromShowroom(int vehicleIndex){
        
        AVehicle vehicle = vehicles.get(vehicleIndex - 1);
        
        if(vehicle.getVehicleType().equals(VehicleTypes.SPORTS)){
            notifyAllObservers(VehicleState.VEHICLE_REMOVED);
        }

        vehicles.remove(vehicleIndex - 1);
        System.out.print("\nVehicle is removed\n\n");
        printVehicleList();
    }
}
