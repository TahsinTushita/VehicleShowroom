/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehicleshowroom;

/**
 *
 * @author pc
 */
public class HeavyVehicle extends AVehicle{
    private float weight;
    
    public HeavyVehicle(String modelNumber, int enginePower, int tireSize, float weight) {
        super(modelNumber, "Diesel" , enginePower, tireSize, "Heavy");
        
        this.weight = weight;
    }
    
    @Override
    public String toString(){
        return "mn: "+ this.getModelNumber() + "  et: " + this.getEngineType() + "  ep:  "+this.getEnginePower() + 
                "  ts:  "+this.getTireSize() + "  vt:  "  + this.getVehicleType() + " wt:  " + this.weight;
    }
    
}
