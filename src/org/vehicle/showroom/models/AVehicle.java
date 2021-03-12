
package org.vehicle.showroom.models;

public abstract class AVehicle {
    private String modelNumber;
    private String engineType;
    private int enginePower;
    private int tireSize;
    private String vehicleType;
    
    public AVehicle(String modelNumber, String engineType, int enginePower, int tireSize, String vehicleType){
        this.modelNumber = modelNumber;
        this.engineType = engineType;
        this.enginePower = enginePower;
        this.tireSize = tireSize;
        this.vehicleType = vehicleType;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public String getEngineType() {
        return engineType;
    }

    public int getEnginePower() {
        return enginePower;
    }

    public int getTireSize() {
        return tireSize;
    }

    public String getVehicleType() {
        return vehicleType;
    }    
   
    @Override
    public String toString(){
        return "Vehicle Type: "  + this.vehicleType + "\n   Model Number: "+ this.modelNumber + "\n   Engine Type: " +
                this.engineType + "\n   EnginePower: " + this.enginePower + " hp\n   Tire Size: "+ this.tireSize + 
                " inch\n";
    }
}
