
package org.vehicle.showroom;

import org.vehicle.showroom.subjects.VehicleSubject;
import org.vehicle.showroom.observers.VisitorObserver;
import org.vehicle.showroom.models.AVehicle;
import java.util.ArrayList;
import java.util.Scanner;
import org.vehicle.showroom.constants.EngineTypes;
import org.vehicle.showroom.constants.TurboTypes;
import org.vehicle.showroom.constants.VehicleTypes;


public class VehicleShowroom{

    public static void main(String[] args) {
        
        VehicleSubject vehicleList = VehicleSubject.getInstance();
        VisitorObserver visitorObserver = VisitorObserver.getInstance();
        vehicleList.register(visitorObserver);
        
        Scanner in = new Scanner(System.in).useDelimiter("\n");
        
        String vehicleType;
        String modelNumber;
        String engineType;
        int enginePower;
        int tireSize;
        String turbo = "\0";
        float weight = 0;
        int defaultInstructionsNumber = 4;
        
        ArrayList<String> vehicleTypesList = getVehicleTypesList();
        ArrayList<String> engineTypesList = getEngineTypesList();
        ArrayList<String> turboList = getTurboList();
        
        AVehicle vehicle;
        
        while(true){
            
            int input = getDefaultInput(in, 1, defaultInstructionsNumber);
                        
            if(input == 1){
                
                int vehicleTypeInput = getVehicleTypeInput(vehicleTypesList, in);
                
                switch (vehicleTypeInput) {
                    case 1:
                        vehicleType = VehicleTypes.NORMAL;
                        int engineTypeInput = getEngineTypeInput(engineTypesList, in);
                        engineType = getEngineType(engineTypeInput);
                        break;
                    case 2:
                        vehicleType = VehicleTypes.SPORTS;
                        engineType = EngineTypes.OIL;
                        int turboInput = getTurboInput(turboList, in);
                        turbo = getTurbo(turboInput);
                        break;
                    default:
                        vehicleType = VehicleTypes.HEAVY;
                        engineType = EngineTypes.DIESEL;
                        weight = getWeight(in);
                        break;
                }
                

                modelNumber = getModelNumber(in);
                enginePower = getEnginePower(in);
                tireSize = getTireSize(in);

                vehicle = VehicleFactory.getInstance().getVehicle(vehicleType, modelNumber, engineType, enginePower,
                        tireSize,turbo, weight);

                vehicleList.addVehicleToList(vehicle);
            }
            
            else if(input == 2){
                removeVehicle(vehicleList, in);
            }
            
            else if(input == 3){
                vehicleList.printVehicleList();
            }
            
            else if(input == 4){
                System.out.println("Goodbye");
                break;
            }
            
        }
        
    }

    private static int getTireSize(Scanner in) {
        int tireSize = 0;
        
        do{
            System.out.print("\nEnter the tire size of the vehicle in inches\n\n");
            try{
                tireSize = in.nextInt();
            } catch(Exception e){
                in.next();
                System.out.println("Please enter a valid input");
            }
        }while(tireSize <= 0);
        
        return tireSize;
    }

    private static int getEnginePower(Scanner in) {
        int enginePower = 0;
        
        do{
            System.out.print("\nEnter the engine power of the vehicle in hp\n\n");
            try{
                enginePower = in.nextInt();
            } catch(Exception e){
                in.next();
                System.out.println("Please enter a valid input");
            }
        }while(enginePower <= 0);
        
        return enginePower;
    }

    private static String getModelNumber(Scanner in) {
        String modelNumber = "0";
        do{
            System.out.print("\nEnter the model number of the vehicle\n\n");
            try{
                modelNumber = in.next();
            } catch(Exception e){
                in.next();
                System.out.println("Please enter a valid input");
            }
        } while(modelNumber.isEmpty());
        
        return modelNumber;
    }

    private static float getWeight(Scanner in) {
        float weight = 0;
        
        do{
            System.out.print("\nEnter the weight of the vehicle in kg\n\n");
            try{
                weight = in.nextFloat();
            } catch(Exception e){
                in.next();
                System.out.println("Please enter a valid input");
            }
        }while(weight <= 0);
        return weight;
    }

    private static String getTurbo(int turboInput) {
        String turbo;
        
        switch (turboInput) {
            case 1:
                turbo = TurboTypes.SINGLE;
                break;
            case 2:
                turbo = TurboTypes.TWIN;
                break;
            case 3:
                turbo = TurboTypes.TWIN_SCROLL;
                break;
            case 4:
                turbo = TurboTypes.VARIABLE_GEOMETRY;
                break;
            case 5:
                turbo = TurboTypes.VARIABLE_TWIN_SCROLL;
                break;
            default:
                turbo = TurboTypes.ELECTRIC;
                break;
        }
        
        return turbo;
    }

    private static int getTurboInput(ArrayList<String> turboList, Scanner in) {
        int turboInput = 0;
        do{
            printTurboTypeInstructions(turboList);
            
            try{
                turboInput = in.nextInt();
            } catch(Exception e){
                in.next();
                System.out.println("Please enter a valid input");
            }
        } while(turboInput < 1 || turboInput > turboList.size());
        return turboInput;
    }

    private static void printTurboTypeInstructions(ArrayList<String> turboList) {
        System.out.println();
        int turboTypeNumber = 1;
        
        for(String element: turboList){
            System.out.println(turboTypeNumber + ". If the turbo type is " + element + ", enter " +
                    turboTypeNumber);
            turboTypeNumber++;
        }
        
        System.out.print("\n\n");
    }

    private static String getEngineType(int engineTypeInput) {
        String engineType;
        
        switch (engineTypeInput) {
            case 1:
                engineType = EngineTypes.OIL;
                break;
            case 2:
                engineType = EngineTypes.GAS;
                break;
            default:
                engineType = EngineTypes.DIESEL;
                break;
        }
        
        return engineType;
    }

    private static int getEngineTypeInput(ArrayList<String> engineTypesList, Scanner in) {
        int engineTypeInput = 0;
        do{
            printEngineTypeInputInstructions(engineTypesList);
            
            try{
                engineTypeInput = in.nextInt();
            } catch(Exception e){
                in.next();
                System.out.println("Please enter a valid input");
            }
        } while(engineTypeInput < 1 || engineTypeInput > engineTypesList.size());
        return engineTypeInput;
    }

    private static void printEngineTypeInputInstructions(ArrayList<String> engineTypesList) {
        System.out.println();
        int engineTypeNumber = 1;
        for(String element: engineTypesList){
            System.out.println(engineTypeNumber + ". If the engine type is " + element + ", enter " +
                    engineTypeNumber);
            engineTypeNumber++;
        }
        System.out.print("\n\n");
    }

    private static int getVehicleTypeInput(ArrayList<String> vehicleTypesList, Scanner in) {
        int vehicleTypeInput = 0;
        do{
            printVehicleTypeInputInstructions(vehicleTypesList);
            
            try{
                vehicleTypeInput = in.nextInt();
            } catch(Exception e){
                in.next();
                System.out.println("Please enter a valid input");
            }
        } while(vehicleTypeInput < 1 || vehicleTypeInput > vehicleTypesList.size());
        return vehicleTypeInput;
    }

    private static void printVehicleTypeInputInstructions( ArrayList<String> vehicleTypesList) {
        System.out.println();
        int vehicleTypeNumber = 1;
        for(String element: vehicleTypesList){
            System.out.println(vehicleTypeNumber + ". For adding a " + element + " vehicle, enter " +
                    vehicleTypeNumber);
            vehicleTypeNumber++;
        }
        System.out.print("\n\n");
    }
    

    private static int getDefaultInput( Scanner in, int a, int b) {
        int input = getInputInRange(in,a,b,"1. For adding a vehicle, enter 1\n"
                    + "2. For removing a vehicle, enter 2\n"
                    + "3. To see the Vehicle List and expected number of visitors, enter 3\n"
                + "4. To exit, enter 4\n\n");
        return input;
    }
    
    private static int getInputInRange(Scanner in, int a, int b, String instructions){
        int input = a - 1;
        
        do{
            System.out.print(instructions);
            
            try{
                input = in.nextInt();
            } catch(Exception e){
                in.next();
                System.out.println("Please enter a valid input");
            }
        } while(input < a || input > b);
        return input;
    }

    private static ArrayList<String> getTurboList() {
        ArrayList<String> turboList = new ArrayList<String>();
        turboList.add(TurboTypes.SINGLE);
        turboList.add(TurboTypes.TWIN);
        turboList.add(TurboTypes.TWIN_SCROLL);
        turboList.add(TurboTypes.VARIABLE_GEOMETRY);
        turboList.add(TurboTypes.VARIABLE_TWIN_SCROLL);
        turboList.add(TurboTypes.ELECTRIC);
        return turboList;
    }

    private static ArrayList<String> getEngineTypesList() {
        ArrayList<String> engineTypesList = new ArrayList<String>();
        engineTypesList.add(EngineTypes.OIL);
        engineTypesList.add(EngineTypes.GAS);
        engineTypesList.add(EngineTypes.DIESEL);
        return engineTypesList;
    }

    private static ArrayList<String> getVehicleTypesList() {
        ArrayList<String> vehicleTypesList = new ArrayList<String>();
        vehicleTypesList.add(VehicleTypes.NORMAL);
        vehicleTypesList.add(VehicleTypes.SPORTS);
        vehicleTypesList.add(VehicleTypes.HEAVY);
        return vehicleTypesList;
    }

    private static void removeVehicle(VehicleSubject vehicleList, Scanner in) {
        int vehicleIndex = 0;
        ArrayList<AVehicle> getVehicleList = vehicleList.getVehicleList();
        if(getVehicleList.isEmpty())
            System.out.println("\nThere are no vehicles in the showroom to remove\n"
                    + "\n---------------------------------------------------------------\n");
        else{
            
            do{
                System.out.print("\nEnter the serial number of the vehicle in the list to remove\n\n");
                try{
                    vehicleIndex = in.nextInt();
                } catch(Exception e){
                    in.next();
                    System.out.println("Please enter a valid input");
                }
            }while(vehicleIndex < 1 || vehicleIndex > getVehicleList.size());
            
            vehicleList.removeVehicleFromShowroom(vehicleIndex);
        }
    }
}
