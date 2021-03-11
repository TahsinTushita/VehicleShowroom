/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.vehicle.showroom.subjects;

import org.vehicle.showroom.observers.VisitorObserver;
import org.vehicle.showroom.observers.Observer;
import org.vehicle.showroom.models.AVehicle;
import java.util.ArrayList;
import org.vehicle.showroom.constants.VehicleTypes;

/**
 *
 * @author pc
 */
public class VehicleList implements Subject{
    
    private ArrayList<AVehicle> vehicles;
    private ArrayList<Observer> observers;
    private VisitorObserver visitorObserver;
    
    private static VehicleList instance;
    
    private VehicleList(){
        
        vehicles = new ArrayList<>();
        observers = new ArrayList<>();
        visitorObserver = VisitorObserver.getInstance();
        
    };
    
    public static VehicleList getInstance(){
        if(instance == null){
            instance = new VehicleList();
        }
        
        return instance;
    }

    @Override
    public void register(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unregister(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyAllObservers(int input) {
        if(input == 1){
            for(Observer observer: observers){
                observer.vehicleAdded();
            }
        }
        else{
            for(Observer observer: observers){
                observer.vehicleRemoved();
            }
        }
    }

    public ArrayList<AVehicle> getVehicleList() {
        return vehicles;
    }
    
    
    
    public void printVehicleList(){
        
        int i = 1;
        
        if(!vehicles.isEmpty()){
            for (AVehicle vehicle: vehicles){
            System.out.println(i + ". "  +  vehicle);
            i++;
        }
            visitorObserver.printVisitorCount();
        }
        
        else{
            System.out.println("There are no vehicles in the showroom");
        }
        
    }
    
    public void addVehicleToList(AVehicle vehicle){
        vehicles.add(vehicle);
        
        if(vehicle.getVehicleType().equals(VehicleTypes.SPORTS)){
            notifyAllObservers(1);
        }
        
        printVehicleList();
    }
    
    public void removeVehicleFromShowroom(int vehicleIndex){
        
        AVehicle vehicle = vehicles.get(vehicleIndex - 1);
        
        if(vehicle.getVehicleType().equals(VehicleTypes.SPORTS)){
            notifyAllObservers(2);
        }

        vehicles.remove(vehicleIndex - 1);
        
        printVehicleList();
    }
}
