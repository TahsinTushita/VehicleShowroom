/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehicleshowroom;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author pc
 */
public class VehicleShowroom {

    /**
     * @param args the command line arguments
     */
    
    public static ArrayList<AVehicle> vehicles = new ArrayList<>();
    
    public static void main(String[] args) {
        
        VehicleFactory vehicleFactory = VehicleFactory.getInstance();
        
        Scanner vType = new Scanner(System.in);
        Scanner modelNum = new Scanner(System.in);
        Scanner engType = new Scanner(System.in);
        Scanner engPow = new Scanner(System.in);
        Scanner tireSz = new Scanner(System.in);
        Scanner trbo = new Scanner(System.in);
        Scanner wt = new Scanner(System.in);
        
        String vehicleType;
        String modelNumber;
        String engineType;
        int enginePower;
        int tireSize;
        String turbo;
        float weight;
        AVehicle car;
        
        while(true){
            vehicleType = vType.nextLine();
            modelNumber = modelNum.nextLine();
            engineType = engType.nextLine();
            enginePower = engPow.nextInt();
            tireSize = tireSz.nextInt();
            turbo = trbo.nextLine();
            weight = wt.nextFloat();
            
            car = vehicleFactory.getVehicle(vehicleType, modelNumber, engineType, enginePower, tireSize, turbo, weight);
            vehicles.add(car);
            
            printVehicleList();
        }
        
    }
    
    public static void printVehicleList(){
        for (AVehicle vehicle: vehicles){
            System.out.println(vehicle);
        }
    }
    
}
