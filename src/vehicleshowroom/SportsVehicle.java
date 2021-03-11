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
public class SportsVehicle extends AVehicle{
    
    private String turbo;
    
    public SportsVehicle(String modelNumber, int enginePower, int tireSize, String turbo) {
        super(modelNumber, "Oil", enginePower, tireSize, "Sports");
        
        this.turbo = turbo;
    }
    
    @Override
    public String toString(){
        return "mn: "+ this.getModelNumber() + "  et: " + this.getEngineType() + "  ep:  "+this.getEnginePower() + 
                "  ts:  "+this.getTireSize() + "  vt:  "  + this.getVehicleType() + " tb:  " + this.turbo;
    }
    
}
